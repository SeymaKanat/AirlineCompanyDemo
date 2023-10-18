package nl.miwnn.se2.seyma.AirlineCompany.Demo.repository;

import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Company, Long> {

}
