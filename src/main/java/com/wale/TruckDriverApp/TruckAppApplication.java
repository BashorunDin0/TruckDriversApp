package com.wale.TruckDriverApp;

import com.wale.TruckDriverApp.Entity.Role;
import com.wale.TruckDriverApp.Entity.User;
import com.wale.TruckDriverApp.Repository.RoleRepository;
import com.wale.TruckDriverApp.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
@EnableAsync
public class TruckAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(TruckAppApplication.class, args);
	}

//	@Bean
//	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository,
//						  PasswordEncoder passwordEncoder) {
//		return args -> {
//			if (roleRepository.findByAuthority("ADMIN").isPresent())
//				return;
//			Role adminRole = roleRepository.save(new Role("ADMIN"));
//			roleRepository.save(new Role("USER"));
//
//			Set<Role> roles = new HashSet<>();
//			roles.add(adminRole);
//
//			User admin = new User(1, passwordEncoder.encode("password"), roles);
//			userRepository.save(admin);
//		};
	}


