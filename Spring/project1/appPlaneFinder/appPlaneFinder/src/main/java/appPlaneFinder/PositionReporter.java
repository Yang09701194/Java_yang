package appPlaneFinder;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;

import java.io.IOException;
import java.security.Signature;
import java.util.List;
import java.util.function.Supplier;

@AllArgsConstructor
@Configuration
public class PositionReporter {

    private final PlaneFinderService service;

    @Bean
    Supplier<Flux<Aircraft>> reportPositions(){
        return ()->{
            try {
                return service.getAircraft();
            } catch (IOException e) {
                e.printStackTrace();
            }
            //return List.of();
            return new Flux<Aircraft>() {
                @Override
                public void subscribe(CoreSubscriber<? super Aircraft> coreSubscriber) {

                }
            };
        };
    }

}
