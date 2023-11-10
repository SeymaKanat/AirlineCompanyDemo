package nl.miwnn.se2.seyma.AirlineCompany.Demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Seyma Kanat <s.kanat@st.hanze.nl>
 * Home page
 */
@Controller
public class HomePageController {
    @GetMapping("/homePage")
    public String homePage() {

        // Ana sayfanın içeriğini oluşturacağınız yer
        return "homePage"; // Burada "home" şablonunu döndürdüğümüzü varsayalım.
    }
}




