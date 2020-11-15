package by.it.academy.controller;

import by.it.academy.model.Coin;
import by.it.academy.repository.Dao;
import by.it.academy.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/*
Controller for checking if coins are valid
 */
@Controller
public class CheckController {
    @Autowired
    ValidationService validationService;
    @Autowired
    Dao<Coin> dao;

    @RequestMapping(value = "/{coinId}/check", method = RequestMethod.GET)
    public ModelAndView homePage(
            @PathVariable long coinId,
            ModelAndView modelAndView) {
        if (coinId == 0) {
            modelAndView.addObject("validity", "OK");
            modelAndView.setViewName("check");
            return modelAndView;
        } else {
            Coin coin = dao.read(Coin.class, coinId);
            boolean result = validationService.validate(coin);
            if (result) {
                modelAndView.addObject("validity", "OK");
            } else {
                modelAndView.addObject("validity", "NOT OK");
            }
            modelAndView.setViewName("check");
            return modelAndView;
        }
    }
}
