package by.it.academy.controller;

import by.it.academy.model.User;
import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register.html")
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping
    public String showRegister() {
        return "register";
    }

    @PostMapping
    public String createNewUser(
            @ModelAttribute User user,
            Model model
    ) {

        if(userService.createNewUser(user)) {
            return "redirect:home.html";
        } else {
            model.addAttribute("errorMessage","Can not crate new user");
            return "error-page";
        }
    }
}
