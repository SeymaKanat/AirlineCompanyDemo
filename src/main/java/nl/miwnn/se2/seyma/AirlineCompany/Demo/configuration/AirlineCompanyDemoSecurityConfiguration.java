package nl.miwnn.se2.seyma.AirlineCompany.Demo.configuration;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.service.AirlineUserDetailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Configure security for the library
 */
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class AirlineCompanyDemoSecurityConfiguration {
    private final AirlineUserDetailService userDetailsService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests((authorize) -> authorize
                        .antMatchers("/css/**", "/webjars/**").permitAll()
                        .antMatchers("/initialize").permitAll()
                        .antMatchers("/", "/book/overview").permitAll()
                        .anyRequest().authenticated())
                .formLogin().and()
                .logout().logoutSuccessUrl("/company/overview");
        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

}