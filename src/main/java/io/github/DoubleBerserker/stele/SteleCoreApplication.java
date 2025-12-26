package io.github.DoubleBerserker.stele;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource("classpath:application.yml")
public class SteleCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(SteleCoreApplication.class, args);
	}

}
