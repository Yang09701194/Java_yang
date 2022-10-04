package plane.redisrepo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");
    private final RedisConnectionFactory factory;

//    private final RedisOperations<String, com.example.app.Aircraft> redisOperations;

    private final AircraftRepository repository;

    public PlaneFinderPoller(RedisConnectionFactory factory, AircraftRepository repository) {
        this.factory = factory;
        this.repository = repository;
    }

    @Scheduled(fixedRate = 10000)
    private void pollPlanes(){
        factory.getConnection().serverCommands().flushDb();
        System.out.println(1);
//        client.get().retrieve().bodyToFlux(com.example.app.Aircraft.class).filter(plane -> !plane.getReg().isEmpty()).toStream().forEach(ac -> redisOperations.opsForValue().set(ac.getReg(), ac));

        client.get().retrieve().bodyToFlux(Aircraft.class).filter(plane -> !plane.getReg().isEmpty()).toStream().forEach(repository::save);
//
////        redisOperations.opsForValue().getOperations().keys("*").forEach(ac -> System.out.println(redisOperations.opsForValue().get(ac)));
        repository.findAll().forEach(System.out::println);
    }
}

