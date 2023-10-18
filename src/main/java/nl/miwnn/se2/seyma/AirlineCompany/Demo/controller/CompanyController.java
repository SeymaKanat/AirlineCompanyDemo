package nl.miwnn.se2.seyma.AirlineCompany.Demo.controller;

import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Company;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.CompanyRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
    @GetMapping("/company/new") //Burasi company olusturmak icin
    private String showCompanyForm(Model model) {
        model.addAttribute("company", new Company());

        return "companyForm";
    }
    @PostMapping("/company/new") //Save company butonu icin
    private String saveOrUpdateCompany(@ModelAttribute("company") Company companyToBeSaved, BindingResult result){
        if (!result.hasErrors()){
            companyRepository.save(companyToBeSaved);
        }
        return "redirect:/";
    }




}
