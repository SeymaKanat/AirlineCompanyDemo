package nl.miwnn.se2.seyma.AirlineCompany.Demo.configuration;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Configure security for the airline company
 */
@Configuration
@EnableWebSecurity
public class AirlineDemoSecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/css/**", "/webjars/**").permitAll()
                        .antMatchers("/", "/company/overview").permitAll()
                        .antMatchers("/", "/company/detail").permitAll()
                        .anyRequest().authenticated())
                .formLogin().and().logout().logoutSuccessUrl("/company/overview");


        return httpSecurity.build();
    }

}
