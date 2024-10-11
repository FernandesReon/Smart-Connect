package com.reonfernandes.Smart_Connect.controller;

import com.reonfernandes.Smart_Connect.model.Providers;
import com.reonfernandes.Smart_Connect.service.implement.UserServiceImpl;
import com.reonfernandes.Smart_Connect.form.UserForm;
import com.reonfernandes.Smart_Connect.model.User;
import jakarta.servlet.http.HttpSession;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

@Data
@Controller
public class PageController {

    @Value("${user.default.profilePic}")
    private String defaultIcon;

    private final UserServiceImpl userServices;
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final List<String> genders = Arrays.asList("Male", "Female", "Others");
    private static final List<String> roles = Arrays.asList("Admin", "User", "Member", "Guest");
    private static final List<String> regions = Arrays.asList(
            "Asia", "Africa", "Europe", "Australia", "North America", "South America");

    public PageController(UserServiceImpl userServices) {
        this.userServices = userServices;
    }

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
    public String signUpPage(Model model, HttpSession session){
        UserForm userForm = new UserForm();
        userForm.setGender("");
        userForm.setRole("");
        userForm.setRegion("");

        model.addAttribute("userForm", userForm);
        model.addAttribute("genders", genders);
        model.addAttribute("roles", roles);
        model.addAttribute("regions", regions);

        // Retrieve and clear session attributes
        if (session.getAttribute("success") != null) {
            model.addAttribute("success", session.getAttribute("success"));
            session.removeAttribute("success"); // Clear the success message
        }
        if (session.getAttribute("error") != null) {
            model.addAttribute("error", session.getAttribute("error"));
            session.removeAttribute("error"); // Clear the error message
        }


        logger.info("Sign-Up page loaded.");
        return "sign-up";
    }

    // Processing Form (Sign-Up)
    @PostMapping("/register-form")
    public String processSignUpForm(@ModelAttribute UserForm userForm, HttpSession session){
        System.out.println(userForm.toString());
        logger.info("Processing Form");

         /*
         User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .gender(userForm.getGender())
                .phoneNumber(userForm.getPhoneNumber())
                .role(userForm.getRole())
                .region(userForm.getRegion())
                .address(userForm.getAddress())
                .profilePic(defaultIcon)
                .providers(Providers.SELF)
                .build();
           */
        try{
            User user = new User();
            user.setName(userForm.getName());
            user.setEmail(userForm.getEmail());
            user.setPassword(userForm.getPassword());
            user.setGender(userForm.getGender());
            user.setPhoneNumber(userForm.getPhoneNumber());
            user.setRole(userForm.getRole());
            user.setRegion(userForm.getRegion());
            user.setAddress(userForm.getAddress());
            user.setProfilePic(defaultIcon);

            User savedUser = userServices.saveUser(user);
            session.setAttribute("success", "Success! Your account has been created.");
        }
        catch (Exception e){
            session.setAttribute("error", "Error! There was an issue creating your account. Please try again.");

        }

        return "redirect:/sign-up";
    }
}