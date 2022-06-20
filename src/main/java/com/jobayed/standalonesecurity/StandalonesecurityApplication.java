package com.jobayed.standalonesecurity;

import com.jobayed.standalonesecurity.authentication.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StandalonesecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(StandalonesecurityApplication.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService
	){
		return args->{
//			userService.saveUser("jobayed","1234","ADMIN");
//			userService.saveUser("saiful","1234","USER");
		};
	}

}
