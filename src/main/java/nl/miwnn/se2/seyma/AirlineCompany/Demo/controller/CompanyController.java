package nl.miwnn.se2.seyma.AirlineCompany.Demo.controller;

import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Purpose of the program
 */
@Controller
public class CompanyController {
    private final CompanyRepository companyRepository;

    public CompanyController(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @GetMapping("/")
    private String showCompanyOverview(Model model) {
        model.addAttribute("allCompanies", companyRepository.findAll());

        return "companyOverview";

    }

}
