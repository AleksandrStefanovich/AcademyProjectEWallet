package by.it.academy.controller;

import by.it.academy.model.Transaction;
import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class TransactionHistoryController {

    @Autowired
    UserService userService;

    @GetMapping(value = "/{userId}/transaction-history")
    public ModelAndView coinList(ModelAndView modelAndView,
                                @PathVariable String userId
    ){

        List<Transaction> transactions =  userService.getTransactionsByUserId(userId);
        modelAndView.setViewName("transaction-history");
        modelAndView.addObject("transactions", transactions);
        return modelAndView;

    }

}
