package ru.engineers.AniHelperv1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"ru.engineers.AniHelperv1.enteties"} )
@EnableJpaRepositories(basePackages = {"ru.engineers.AniHelperv1.repos"})
public class AniHelperv1Application {

	public static void main(String[] args) {
		SpringApplication.run(AniHelperv1Application.class, args);
	}

}
