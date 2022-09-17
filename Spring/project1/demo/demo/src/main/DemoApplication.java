package com.example.app;

import main.plane.redis.Serialize;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@SpringBootApplication
@ConfigurationPropertiesScan(basePackages = {"com.example.app", "main.plane.redis"})
public class DemoApplication {

	public static void main(String[] args) {

		SpringApplication.run(Serialize.class, args);
		SpringApplication.run(DemoApplication.class, args);

	}



	@Bean
	@ConfigurationProperties(prefix="droid")
	com.example.app.Droid createDroid(){
		return new com.example.app.Droid();
	}

}

