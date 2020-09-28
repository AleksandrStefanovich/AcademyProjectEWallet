package by.it.academy.controller;

import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WalletController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/{userId}/wallet", method = RequestMethod.GET)
    public ModelAndView wallet(
            @PathVariable String userId,
            ModelAndView modelAndView) {
        modelAndView.addObject(userService.getWalletByUserId(userId));
        modelAndView.setViewName("wallet");
        return modelAndView;
    }
}
