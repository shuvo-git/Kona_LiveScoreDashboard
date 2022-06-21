package com.jobayed.standalonesecurity;

import com.jobayed.standalonesecurity.authentication.UserService;
import com.jobayed.standalonesecurity.baserepository.BaseRepository;
import com.jobayed.standalonesecurity.livescore.model.Item;
import com.jobayed.standalonesecurity.livescore.service.ItemService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StandalonesecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(StandalonesecurityApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService, ItemService itemService
    ) {
        return args -> {
			userService.saveUser("jobayed","1234","ADMIN");
			userService.saveUser("saiful","1234","USER");




        };
    }

}
