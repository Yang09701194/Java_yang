package plane.redis;


import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

@EnableScheduling
@Component
public class PlaneFinderPoller {
    private WebClient client = WebClient.create("http://localhost:7634/aircraft");
    private final RedisConnectionFactory factory;
    private final RedisOperations<String, Aircraft> redisOperations;

    public PlaneFinderPoller(RedisConnectionFactory factory, RedisOperations<String, Aircraft> redisOperations) {
        this.factory = factory;
        this.redisOperations = redisOperations;
    }

    @Scheduled(fixedRate = 10000)
    private void pollPlanes(){
        factory.getConnection().serverCommands().flushDb();

        client.get().retrieve().bodyToFlux(Aircraft.class).filter(plane -> !plane.getReg().isEmpty()).toStream().forEach(ac -> redisOperations.opsForValue().set(ac.getReg(), ac));

        redisOperations.opsForValue().getOperations().keys("*").forEach(ac -> System.out.println(redisOperations.opsForValue().get(ac)));

    }
}
