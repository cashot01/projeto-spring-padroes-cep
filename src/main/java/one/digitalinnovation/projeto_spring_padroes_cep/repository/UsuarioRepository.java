package one.digitalinnovation.projeto_spring_padroes_cep.repository;

import one.digitalinnovation.projeto_spring_padroes_cep.model.Usuario;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
