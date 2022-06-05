package KauaNog.ApiRestLogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class ApiRestLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiRestLoginApplication.class, args);
	}

}
