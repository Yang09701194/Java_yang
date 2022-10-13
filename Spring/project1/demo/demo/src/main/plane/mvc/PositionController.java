package plane.mvc;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.Instant;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class PositionController {

//    @NonNull
//    private final AircraftRepository repository;
    @NonNull
    private final PositionRetriever retriever;

    private WebClient client = WebClient.create("http://localhost:7634/aircraft");

    @GetMapping("/aircraft")
    public String getCurrentAircraftPositions(Model model) {

        //webclient
//        repository.deleteAll();
//
//        client.get().retrieve().bodyToFlux(Aircraft.class)
//                .filter(plane -> !plane.getReg().isEmpty())
//                .toStream().forEach(repository::save);

        //rabbitMQ
        model.addAttribute("currentPositions", retriever.getRepository().findAll());
        return "positions";
    }

    @ResponseBody
    @GetMapping("/aircraftapi")
    public Iterable<Aircraft> getCurrentAircraftPositionsApi() {
        System.out.println("api-start");
        try {
//            // Spring Airlines flight 001 en route, flying STL to SFO,
//            // at 30000' currently over Kansas City
//            var ac1 = new Aircraft(1L, "SAL001", "sqwk", "N12345", "SAL001",
//                    "STL-SFO", "LJ", "ct",
//                    30000, 280, 440, 0, 0,
//                    39.2979849, -94.71921, 0D, 0D, 0D,
//                    true, false,
//                    Instant.now(), Instant.now(), Instant.now());
//
//            // Spring Airlines flight 002 en route, flying SFO to STL,
//            // at 40000' currently over Denver
//            var ac2 = new Aircraft(2L, "SAL002", "sqwk", "N54321", "SAL002",
//                    "SFO-STL", "LJ", "ct",
//                    40000, 65, 440, 0, 0,
//                    39.8560963, -104.6759263, 0D, 0D, 0D,
//                    true, false,
//                    Instant.now(), Instant.now(), Instant.now());
//
//            repository.saveAll(List.of(ac1, ac2));

            //webclient
//            retriever.getRepository().deleteAll();
//
//            client.get().retrieve().bodyToFlux(Aircraft.class)
//                    .filter(plane -> !plane.getReg().isEmpty())
//                    .toStream().forEach(retriever.getRepository()::save);
//
//            return retriever.getRepository().findAll();
//

            return retriever.getAircraftPositions("aircraft");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @ResponseBody
    @GetMapping("/aircraftapi/admin")
    public Iterable<Aircraft> getCurrentAircraftPositionsApiAdmin() {
        System.out.println("api-start");
        try {
            return retriever.getAircraftPositions(" aircraftadmin");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
