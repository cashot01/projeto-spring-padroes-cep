package one.digitalinnovation.projeto_spring_padroes_cep;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ProjetoSpringPadroesCepApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringPadroesCepApplication.class, args);
	}

}
