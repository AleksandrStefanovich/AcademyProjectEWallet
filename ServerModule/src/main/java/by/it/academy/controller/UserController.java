package by.it.academy.controller;

import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET)
    public ModelAndView homePage(
            @PathVariable String userId,
            ModelAndView modelAndView) {
        modelAndView.addObject(userService.getUserByUserId(userId));
        modelAndView.setViewName("user");
        return modelAndView;
    }
}
