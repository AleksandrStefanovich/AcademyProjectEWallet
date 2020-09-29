package by.it.academy.main;

import by.it.academy.model.User;
import by.it.academy.repository.UserRepository;
import by.it.academy.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Mine {

    @Autowired
    CoinService coinService;

    @Autowired
    UserRepository userRepository;


    @Scheduled(fixedRate = 6000)
    public void mine(){
        String userId = "user" + (int)Math.floor(Math.random()*10+1);
        User user = userRepository.findByUserId(userId);
          createNewCoin(user);
    }




    public boolean createNewCoin(User user) {
        return coinService.createCoin(user);
    }
}
