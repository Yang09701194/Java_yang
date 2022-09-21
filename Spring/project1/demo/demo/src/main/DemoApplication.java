package com.example.app;

//import main.plane.redis.Serialize;

import main.plane.redisrepo.App;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication(scanBasePackages={/*"com.example.app","main.plane.redis","main.plane.redisrepo",*/"main.plane.jpa_mysql"})
@ConfigurationPropertiesScan(basePackages={/*"com.example.app","main.plane.redis","main.plane.redisrepo",*/"main.plane.jpa_mysql"})
@ComponentScan(basePackages={/*"com.example.app","main.plane.redis","main.plane.redisrepo",*/"main.plane.jpa_mysql"})
@EnableJpaRepositories(basePackages={/*"com.example.app","main.plane.redis","main.plane.redisrepo",*/"main.plane.jpa_mysql"})
@EnableAutoConfiguration
@EntityScan(basePackages={/*"com.example.app","main.plane.redis","main.plane.redisrepo",*/"main.plane.jpa_mysql"})
public class DemoApplication {

	public static void main(String[] args) {
//		SpringApplication.run(App.class, args);
//		SpringApplication.run(Serialize.class, args);
		SpringApplication.run(DemoApplication.class, args);

	}



	@Bean
	@ConfigurationProperties(prefix="droid")
	com.example.app.Droid createDroid(){
		return new com.example.app.Droid();
	}

}

