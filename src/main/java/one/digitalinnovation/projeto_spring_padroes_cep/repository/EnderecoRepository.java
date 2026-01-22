package one.digitalinnovation.projeto_spring_padroes_cep.repository;

import one.digitalinnovation.projeto_spring_padroes_cep.model.Endereco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}
