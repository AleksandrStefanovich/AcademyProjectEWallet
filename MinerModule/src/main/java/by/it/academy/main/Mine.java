package by.it.academy.main;

import by.it.academy.model.User;
import by.it.academy.repository.UserRepository;
import by.it.academy.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/*
Service is used for mining coins (blocks)
it uses username to know which user is mining
 */

@Service
public class Mine {

    @Autowired
    CoinService coinService;

    @Autowired
    UserRepository userRepository;


    @Scheduled(fixedRate = 5000)
    public void mine(){
        /**
         * userId should be replaced by username for proper mining
         * this method uses random user1-user10 usernames for presentation purpose
         * database should be filled with users named those usernames using RegisterController in ServerModule
         * when it is running in Tomcat
         */

        String userId = "user" + (int)Math.floor(Math.random()*10+1);
        User user = userRepository.findByUserId(userId);
          createNewCoin(user);
    }




    public boolean createNewCoin(User user) {
        return coinService.createCoin(user);
    }
}
