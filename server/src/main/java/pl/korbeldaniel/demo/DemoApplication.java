package pl.korbeldaniel.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Properties;

@EnableSwagger2
@SpringBootApplication
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(DemoApplication.class);
		Properties properties = new Properties();
		properties.put("spring.jersey.type", "filter");
		application.setDefaultProperties(properties);
		application.run(args);
	}
}
