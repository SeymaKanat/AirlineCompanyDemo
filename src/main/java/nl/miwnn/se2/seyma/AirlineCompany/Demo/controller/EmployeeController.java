package nl.miwnn.se2.seyma.AirlineCompany.Demo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.Employee;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.EmployeeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Handles everthing  regarding employees
 */
@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    @GetMapping("/all")
    protected String showAEmployeesOverview(Model model) {
        model.addAttribute("allEmployees", employeeRepository.findAll());
        model.addAttribute("newEmployee", new Employee());
        return "employeeOverview";
    }
    @PostMapping("/new") //Save employee butonu icin
    protected String saveOrUpdateEmployee(@ModelAttribute("newEmployee") Employee employee, BindingResult result){
        if (!result.hasErrors()){
            employeeRepository.save(employee);
        }
        return "redirect:/employee/all";
    }

}
