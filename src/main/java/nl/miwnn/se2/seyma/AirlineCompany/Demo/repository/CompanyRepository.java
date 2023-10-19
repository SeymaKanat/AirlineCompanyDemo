package nl.miwnn.se2.seyma.AirlineCompany.Demo.repository;

import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Company;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CompanyRepository extends JpaRepository<Company, Long> {
    Optional<Company> findCompanyByCompanyName(String companyName);

}
