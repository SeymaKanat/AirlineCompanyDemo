package nl.miwnn.se2.seyma.AirlineCompany.Demo.repository;


import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.AirlineUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AirlineUserRepository extends JpaRepository<AirlineUser, Long> {
    Optional<AirlineUser> findAirlineUserByUsername(String username);
}
