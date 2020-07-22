package id.lock.secure.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RestController
public class SpringBootStarterApplication {
	
	@RequestMapping("/", method = GET)
	public String home() {
		return "Hello Docker World Version 3";
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringBootStarterApplication.class, args);
	}

}
