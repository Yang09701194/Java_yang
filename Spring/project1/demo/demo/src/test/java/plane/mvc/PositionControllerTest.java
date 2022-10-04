package plane.mvc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;

@SpringBootApplication
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PositionControllerTest.class)
//@AutoConfigureWebClient
class PositionControllerTest {

    @BeforeEach
    void setUp() {
        client = client.mutate()
                .responseTimeout(Duration.ofMillis(60000))
                .build();
    }

    @AfterEach
    void tearDown() {
    }


    @Autowired
    private WebTestClient client;
    @Test
    void getCurrentAircraftPositions(/*@Autowired WebTestClient client*/) {
        assert client.get().uri("/aircraftapi").exchange().expectStatus().isOk()
                .expectBody(Iterable.class).returnResult().getResponseBody()
                .iterator().hasNext();
    }
}