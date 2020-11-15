package by.it.academy;


import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @see by.it.academy.main.Mine
 * this app runs coins(blocks) mining every 5 seconds
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableScheduling
public class ApplicationConfiguration {

    public static void main(String[] args) {
        SpringApplication.run(ApplicationConfiguration.class);
    }


}
