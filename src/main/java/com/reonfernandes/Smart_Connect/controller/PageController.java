package com.reonfernandes.Smart_Connect.controller;

import com.reonfernandes.Smart_Connect.form.UserForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class PageController {

    // Step 1: Declare a static logger instance
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);
    private static final List<String> genders = Arrays.asList("Male", "Female", "Others");
    private static final List<String> roles = Arrays.asList("Admin", "User", "Member", "Guest");
    private static final List<String> regions = Arrays.asList(
            "Asia", "Africa", "Europe", "Australia", "North America", "South America");

    @GetMapping("/home")
    public String homePage(){
        // Step 2: Use the logger instead of System.out.println
        logger.info("Home page loaded.");
        return "home";
    }

    @GetMapping("/about")
    public String aboutPage(){
        logger.info("About page loaded.");
        return "about";
    }

    @GetMapping("/services")
    public String servicesPage(){
        logger.info("Services page loaded.");
        return "services";
    }

    @GetMapping("/contact")
    public String contactPage(){
        logger.info("Contact page loaded.");
        return "contact";
    }

    @GetMapping("/login")
    public String loginPage(){
        logger.info("Login page loaded.");
        return "login";
    }

    @GetMapping("/sign-up")
    public String signUpPage(Model model){
        UserForm userForm = new UserForm();
        userForm.setGender("");
        userForm.setRole("");
        userForm.setRegion("");

        model.addAttribute("userForm", userForm);
        model.addAttribute("genders", genders);
        model.addAttribute("roles", roles);
        model.addAttribute("regions", regions);

        logger.info("Sign-Up page loaded.");
        return "sign-up";
    }

    // Processing Form (Sign-Up)
    @PostMapping("/register-form")
    public String processSignUpForm(){
        logger.info("Processing Form");
        return "redirect:/sign-up";
    }
}