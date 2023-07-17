package com.example.userservice;

import com.example.userservice.domain.Role;
import com.example.userservice.domain.User;
import com.example.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	CommandLineRunner run (UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));

			userService.saveUser(new User(null, "Thang", "thang", "123456", new ArrayList<>()));
			userService.saveUser(new User(null, "Bong", "bong", "123456", new ArrayList<>()));
			userService.saveUser(new User(null, "Bong nghi su", "bongnghisu", "123456", new ArrayList<>()));

			userService.addRoleToUser("thang", "ROLE_USER");
			userService.addRoleToUser("thang", "ROLE_ADMIN");
			userService.addRoleToUser("thang", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("bong", "ROLE_USER");
			userService.addRoleToUser("bongnghisu", "ROLE_ADMIN");
			userService.addRoleToUser("bong", "ROLE_SUPER_ADMIN");

		};
	}

	@Bean
	BCryptPasswordEncoder passwordEncoder () {
		return new BCryptPasswordEncoder();
	}

}
