package plane.mvc;


import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

@RequiredArgsConstructor
@Configuration
public class PositionRetriever {

    @NonNull
    private final AircraftRepository repository;
    @NonNull
    private final WebSocketHandler handler;

    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    @Bean
    Consumer<List<Aircraft>> retrieveAircraftPositions() {
        return acList -> {
            repository.deleteAll();

            repository.saveAll(acList);

            repository.findAll().forEach(System.out::println);

            sendPositions();
        };
    }

    public AircraftRepository getRepository() {
        return repository;
    }

    private void sendPositions() {
        if (repository.count() > 0) {
            for (WebSocketSession sessionInList : handler.getSessionList()) {
                try {
                    sessionInList.sendMessage(
                            new TextMessage(repository.findAll().toString())
                    );
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public Iterable<Aircraft> getAircraftPositions() {
        //webclient
        repository.deleteAll();

        client.get().retrieve().bodyToFlux(Aircraft.class)
                .filter(plane -> !plane.getReg().isEmpty())
                .toStream().forEach(repository::save);

        return repository.findAll();


    }

}
