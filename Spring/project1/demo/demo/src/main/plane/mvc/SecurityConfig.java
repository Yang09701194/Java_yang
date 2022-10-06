package plane.mvc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig {

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
