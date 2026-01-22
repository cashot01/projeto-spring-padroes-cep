package one.digitalinnovation.projeto_spring_padroes_cep.service;

import one.digitalinnovation.projeto_spring_padroes_cep.model.Usuario;
import org.springframework.stereotype.Service;


public interface UsuarioService {
    Iterable<Usuario> buscarTodos();

    Usuario buscarPorId(Long id);

    void inserir(Usuario usuario);

    void atualizar(Long id, Usuario usuario);

    void deletar(Long id);
}
