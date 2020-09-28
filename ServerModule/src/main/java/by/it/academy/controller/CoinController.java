package by.it.academy.controller;

import by.it.academy.model.Coin;
import by.it.academy.service.CoinService;
import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CoinController {
    @Autowired
    CoinService coinService;

    @GetMapping("/coins.html")
    public ModelAndView coinList(ModelAndView modelAndView){

        List<Coin> coins =  coinService.getAll();
        modelAndView.setViewName("coins");
        modelAndView.addObject("coins", coins);
        return modelAndView;

    }
}
