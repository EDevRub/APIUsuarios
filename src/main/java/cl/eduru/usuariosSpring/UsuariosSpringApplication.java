package cl.eduru.usuariosSpring;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API de Usuarios",
				version = "1.0.0",
				description = "API para el control de usuarios desarrollada en Spring Boot"
		)
)
public class UsuariosSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsuariosSpringApplication.class, args);
	}

}
