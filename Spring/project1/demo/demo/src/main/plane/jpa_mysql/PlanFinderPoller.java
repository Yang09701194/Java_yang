package plane.jpa_mysql;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
@RequiredArgsConstructor
public class PlanFinderPoller {

    @NonNull
    private AircraftRepository repository;

    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    @Scheduled(fixedRate = 10000)
    private void pollPlanes(){
        repository.deleteAll();

        client.get().retrieve().bodyToFlux(Aircraft.class).filter(plane -> !plane.getReg().isEmpty())
                .toStream().forEach(repository::save);

        repository.findAll().forEach(System.out::println);
    }

}
