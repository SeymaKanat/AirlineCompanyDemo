package nl.miwnn.se2.seyma.AirlineCompany.Demo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Airplane;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Company;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.AirplaneRepository;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 *
 * Handle everthing  regarding airplanes
 */
@Controller
@RequiredArgsConstructor     // Constructor yerine bunu ekledik
public class AirplaneController {
    private final CompanyRepository companyRepository;
    private final AirplaneRepository airplaneRepository;

@GetMapping("/airplane/new/{companyId}") //Burasi company olusturmak icin
    private String createNewAirplane(@PathVariable("companyId") Long companyId){
        Optional<Company> companyOptional = companyRepository.findById(companyId);

        if (companyOptional.isPresent()){
            Airplane airplane = new Airplane();
            airplane.setCompany(companyOptional.get());
            airplaneRepository.save(airplane);
        }
        return "redirect:/company/new";
    }



}
