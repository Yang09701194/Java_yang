package plane.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.OAuth2AuthorizedClientRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServletOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class SecurityConfig {

//    @Bean
    WebClient client(ClientRegistrationRepository regRepo, OAuth2AuthorizedClientRepository cliRepo) {
        ServletOAuth2AuthorizedClientExchangeFilterFunction filter = new ServletOAuth2AuthorizedClientExchangeFilterFunction(regRepo, cliRepo);

        filter.setDefaultOAuth2AuthorizedClient(true);

        return WebClient.builder().baseUrl("http://localhost:7634/").apply(filter.oauth2Configuration()).build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/ignore1", "/ignore2");
    }

    private PasswordEncoder pwEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

    @Bean
    UserDetailsService authentication(){
        UserDetails peter = User.builder().username("Peter").password(pwEncoder.encode("password"))
                .roles("USER").build();

        UserDetails jodie = User.builder().username("Jodie").password(pwEncoder.encode("password2"))
                .roles("USER", "ADMIN").build();

        System.out.println("encrypt: " + pwEncoder.encode("password"));

        return new InMemoryUserDetailsManager(peter, jodie);
    }

}
