package main.plane.r2dbc;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PositionService {

    private final AircraftRepository repository;
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    public PositionService(AircraftRepository repository) {
        this.repository = repository;
    }

    public Flux<Aircraft> getAllAircraft(){
        Flux<Aircraft> aircraftFlux = repository.deleteAll()
                .thenMany(client.get().retrieve().bodyToFlux(Aircraft.class)
                        .filter(plane -> !plane.getReg().isEmpty()))
                .flatMap(repository::save);
        return aircraftFlux.thenMany(repository.findAll());
    }

    public Mono<Aircraft> getAircraftById(Long id){
        return repository.findById(id);
    }

    public Flux<Aircraft> getAircraftByReg(String reg){
        return repository.findAircraftByReg(reg);
    }

}
