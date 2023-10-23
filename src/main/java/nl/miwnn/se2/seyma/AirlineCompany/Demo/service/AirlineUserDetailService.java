package nl.miwnn.se2.seyma.AirlineCompany.Demo.service;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.AirlineUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Provide details about a user
 */
@Service
@RequiredArgsConstructor
public class AirlineUserDetailService implements UserDetailsService {
    private final AirlineUserRepository airlineUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return airlineUserRepository.findAirlineUserByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException(String.format("User: %s does not exist", username))
        );
    }

}