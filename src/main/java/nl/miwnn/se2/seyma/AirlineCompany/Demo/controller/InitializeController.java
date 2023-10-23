package nl.miwnn.se2.seyma.AirlineCompany.Demo.controller;

import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;
import net.datafaker.providers.base.Name;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.AirlineUser;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Airplane;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Company;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Employee;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.AirlineUserRepository;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.AirplaneRepository;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.CompanyRepository;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.EmployeeRepository;
import org.apache.tomcat.jni.Library;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Locale;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Initializes my DB with some test data
 */
@Controller
@RequiredArgsConstructor
public class InitializeController {
    private final EmployeeRepository employeeRepository;
    private final CompanyRepository companyRepository;
    private final AirplaneRepository airplaneRepository;
    private final AirlineUserRepository airlineUserRepository;
    private  final PasswordEncoder passwordEncoder;
    @GetMapping("/initialize")
    private String initializeDB() {
        if (!companyRepository.findAll().isEmpty()) {
            return "redirect:/";
        }

        AirlineUser adminUser = new AirlineUser();
        adminUser.setUsername("admin");
        adminUser.setPassword(passwordEncoder.encode("admin"));
        System.err.println("Admin user created, please make sure to change the password");
        airlineUserRepository.save(adminUser);


//        Faker faker = new Faker(new Locale("nl"));
//
//        ArrayList<Employee> employees = new ArrayList<>();
//        for (int employee = 0; employee < 10; employee++) {
//            Name name = faker.name();
//            employees.add(new Employee(name.firstName(),name.lastName()));
//
//        }
//
//        employeeRepository.saveAll(employees);

        Employee seyma  = new Employee("Seyma",  "Kanat");
        Employee halil  = new Employee("Halil",  "Kanat");

        employeeRepository.save(seyma);
        employeeRepository.save(halil);

        Company KLM = new Company("KLM");
        KLM.addEmployee(seyma);

        companyRepository.save(KLM);

        ArrayList<Airplane> airplanes = new ArrayList<>();

        airplanes.add(new Airplane(KLM));
        airplanes.add(new Airplane(KLM));
        airplanes.add(new Airplane(KLM));

        Company bus = new Company("De groene luchtvaartmaatschappij");
        bus.addEmployee(halil);
        companyRepository.save(bus);

        airplanes.add(new Airplane(bus));
        airplanes.add(new Airplane(bus));

        airplaneRepository.saveAll(airplanes);


        return "redirect:/"; // Boylece test data yaptik sanirim

    }

}
