package pk.edu.uitu.SpringBootDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootDemoApplication {

	public static void main(String[] args) {
		System.out.println("Hello!");
		SpringApplication.run(SpringBootDemoApplication.class, args);
	}
}
