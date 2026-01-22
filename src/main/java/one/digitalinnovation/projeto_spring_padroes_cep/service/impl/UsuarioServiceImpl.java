package one.digitalinnovation.projeto_spring_padroes_cep.service.impl;

import one.digitalinnovation.projeto_spring_padroes_cep.model.Endereco;
import one.digitalinnovation.projeto_spring_padroes_cep.model.Usuario;
import one.digitalinnovation.projeto_spring_padroes_cep.repository.EnderecoRepository;
import one.digitalinnovation.projeto_spring_padroes_cep.repository.UsuarioRepository;
import one.digitalinnovation.projeto_spring_padroes_cep.service.UsuarioService;
import one.digitalinnovation.projeto_spring_padroes_cep.service.ViaCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private EnderecoRepository enderecoRepository;
    @Autowired
    private ViaCepService viaCepService;
    

    @Override
    public Iterable<Usuario> buscarTodos() {
        // Buscar todos os Usuarios.
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario buscarPorId(Long id) {
        // Buscar Usuario por ID.
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        return usuario.get();
    }

    @Override
    public void inserir(Usuario usuario) {
        salvarUsuarioComCep(usuario);
    }

    @Override
    public void atualizar(Long id, Usuario usuario) {
        // Buscar Usuario por ID, caso exista:
        Optional<Usuario> usuarioBd = usuarioRepository.findById(id);
        if (usuarioBd.isPresent()) {
            salvarUsuarioComCep(usuario);
        }
    }

    @Override
    public void deletar(Long id) {
        // Deletar Usuario por ID.
        usuarioRepository.deleteById(id);
    }

    private void salvarUsuarioComCep(Usuario usuario) {

        String cep = usuario.getEndereco().getCep();
        Endereco endereco = enderecoRepository.findById(cep).orElseGet(() -> {

            Endereco novoEndereco = viaCepService.consultarCep(cep);
            enderecoRepository.save(novoEndereco);
            return novoEndereco;
        });
        usuario.setEndereco(endereco);

        usuarioRepository.save(usuario);
    }
}
