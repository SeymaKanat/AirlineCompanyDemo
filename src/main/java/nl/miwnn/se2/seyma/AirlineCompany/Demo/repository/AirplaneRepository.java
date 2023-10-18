package nl.miwnn.se2.seyma.AirlineCompany.Demo.repository;

import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Airplane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirplaneRepository extends JpaRepository<Airplane, Long> {
}
