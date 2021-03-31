package ru.engineers.AniHelperv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class AniHelperv1Application {

	public static void main(String[] args) {
		SpringApplication.run(AniHelperv1Application.class, args);
	}

}
