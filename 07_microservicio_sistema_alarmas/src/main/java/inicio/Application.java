package inicio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"controller", "service"})
@EntityScan(basePackages = {"model"})
@EnableJpaRepositories(basePackages = {"daos"})
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@LoadBalanced //HABILITA USO DE LIBRERIA RIBBON
 	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}
}