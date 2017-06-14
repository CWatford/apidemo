package apitask2.config;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = { "apitask2" })
public class SpringBootWebApp {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(SpringBootWebApp.class, args);
	}

}