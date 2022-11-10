package main.plane.r2dbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class RSocketRequesterConfig {

    @Bean
    RSocketRequester requester(RSocketRequester.Builder builder){
        return builder.tcp("localhost", 7635);
    }

}
