package plane.mvc;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;


//@SpringBootApplication
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = PositionControllerTest.class)
//@AutoConfigureWebClient
@WebFluxTest(controllers = {PositionController.class})
class PositionControllerTest {

    @MockBean
    private PositionRetriever retriever;
    @MockBean
    private AircraftRepository repository;

    private Aircraft ac1, ac2;

    @BeforeEach
    void setUp() {
        client = client.mutate()
                .responseTimeout(Duration.ofMillis(60000))
                .build();

// Spring Airlines flight 001 en route, flying STL to SFO,
        //    at 30000' currently over Kansas City
        ac1 = new Aircraft(1L, "SAL001", "sqwk", "N12345", "SAL001",
                "STL-SFO", "LJ", "ct",
                30000, 280, 440, 0, 0,
                39.2979849, -94.71921, 0D, 0D, 0D,
                true, false,
                Instant.now(), Instant.now(), Instant.now());

        // Spring Airlines flight 002 en route, flying SFO to STL,
        //    at 40000' currently over Denver
        ac2 = new Aircraft(2L, "SAL002", "sqwk", "N54321", "SAL002",
                "SFO-STL", "LJ", "ct",
                40000, 65, 440, 0, 0,
                39.8560963, -104.6759263, 0D, 0D, 0D,
                true, false,
                Instant.now(), Instant.now(), Instant.now());

        Mockito.when(retriever.getAircraftPositions("aircraft"))
                .thenReturn(List.of(ac1, ac2));
        Mockito.when(repository.findAll()).thenReturn(List.of(ac1, ac2));
    }

    @AfterEach
    void tearDown() {
    }


    @Autowired
    private WebTestClient client;
    @Test
    void getCurrentAircraftPositions(/*@Autowired WebTestClient client*/) {
//        assert client.get().uri("/aircraftapi").exchange().expectStatus().isOk()
//                .expectBody(Iterable.class).returnResult().getResponseBody()
//                .iterator().hasNext();

        assertEquals(List.of(ac1, ac2),client.get()
                .uri("/aircraftapi")
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Aircraft.class)
                .returnResult()
                .getResponseBody());
    }
    @Test
    void findAll() {
        assertEquals(List.of(ac1, ac2),repository.findAll());
    }
    @Test
    void equal() {
        Aircraft obj1 = new Aircraft(), obj2 = new Aircraft();
        obj1.setId(Long.valueOf(123));
        List<Aircraft> list1 = new ArrayList<>();
        List<Aircraft> list2 = new ArrayList<>();
        list1.add(obj1);
        list2.add(obj2);

        assert list1.equals(list2);
    }


}