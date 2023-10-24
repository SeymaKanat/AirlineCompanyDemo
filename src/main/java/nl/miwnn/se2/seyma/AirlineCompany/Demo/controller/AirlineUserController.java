package nl.miwnn.se2.seyma.AirlineCompany.Demo.controller;

import lombok.RequiredArgsConstructor;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.dto.PasswordDTO;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.model.AirlineUser;
import nl.miwnn.se2.seyma.AirlineCompany.Demo.repository.AirlineUserRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Handle everything regarding AirlineUser objects
 */

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class AirlineUserController {
    private final AirlineUserRepository airlineUserRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/changepassword")
    private String getChangePasswordForm(Model model) {
        model.addAttribute("passwordDetails", new PasswordDTO());

        return "passwordForm";
    }

    @PostMapping("/changepassword")
    private String updatePassword(@ModelAttribute("passwordDetails") PasswordDTO passwordDTO,
                                  Authentication authentication) {
        AirlineUser user = (AirlineUser) authentication.getPrincipal();

        if (passwordEncoder.matches(passwordDTO.getOldPassword(), user.getPassword())
                && passwordDTO.getNewPassword().equals(passwordDTO.getConfirmPassword())) {
            user.setPassword(passwordEncoder.encode(passwordDTO.getNewPassword()));
          airlineUserRepository.save(user);
        }

        return "redirect:/";
    }

}




