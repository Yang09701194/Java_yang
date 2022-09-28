package main.plane.mvc;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.function.Consumer;

@AllArgsConstructor
@Configuration
public class PositoinRetriever {
    private final AircraftRepository repository;

    @Bean
    Consumer<List<Aircraft>> retrieveAircraftPositions() {
        return acList -> {
            repository.deleteAll();

            repository.saveAll(acList);

            repository.findAll().forEach(System.out::println);
        };
    }

}
