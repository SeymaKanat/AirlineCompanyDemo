package nl.miwnn.se2.seyma.AirlineCompany.Demo.repository;

import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
