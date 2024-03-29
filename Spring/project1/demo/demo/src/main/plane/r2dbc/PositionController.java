package main.plane.r2dbc;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.reactivestreams.Publisher;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

//@RequiredArgsConstructor
@Controller
public class PositionController {


    private final RSocketRequester requester;
    private final PositionService service;


    public PositionController(RSocketRequester requester, PositionService service) {
        this.requester = requester;
        this.service = service;
    }

    @GetMapping("/aircraft")
    public String getCurrentAircraftPositions(Model model){

        //mongodb-reactive
        model.addAttribute("currentPositions", service.getAllAircraft());

        return "positions";
    }


    @ResponseBody
    @GetMapping("/acpos")
    public Flux<Aircraft> getCurrentACPositions(){
        return service.getAllAircraft();
    }

    @ResponseBody
    @GetMapping("acpos/search")
    public Publisher<Aircraft> searchForACPosition(@RequestParam Map<String, String> searchParams){
        if(!searchParams.isEmpty()){
            Map.Entry<String, String> setToSearch = searchParams.entrySet().iterator().next();

            if(setToSearch.getKey().equalsIgnoreCase("id")){
                return service.getAircraftById(Long.parseLong(setToSearch.getValue()));
            } else {
                return service.getAircraftByReg(setToSearch.getValue());
            }
        } else {
            return Mono.empty();
        }
    }


    // HTTP endpoint, RSocket client endpoint
    @ResponseBody
    @GetMapping(value = "/acstream", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Aircraft> getCurrnetACPositionStream(){
        return requester.route("acstream").data("Requesting aircraft positions").retrieveFlux(Aircraft.class);

    }

}
