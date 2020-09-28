package by.it.academy.controller;

import by.it.academy.model.Transaction;
import by.it.academy.model.User;
import by.it.academy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/{userId}/new-transaction")
public class NewTransactionController {

    @Autowired
    UserService userService;

    @GetMapping
    public String showNewTransaction() {
        return "new-transaction";
    }

    @PostMapping
    public String createNewTransaction(
            @PathVariable String userId,
            @ModelAttribute Transaction transaction,
            Model model
    ) {
        transaction.setSenderId(userId);
        transaction.setStatus("new");
        if(userService.createNewTransaction(transaction)) {
            return "redirect:/home.html";
        } else {
            model.addAttribute("errorMessage","Can not create new transaction");
            return "error-page";
        }
    }
}
