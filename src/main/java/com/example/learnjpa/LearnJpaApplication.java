package com.example.learnjpa;

import com.example.learnjpa.first.domain.Address;
import com.example.learnjpa.first.domain.User;
import com.example.learnjpa.first.domain.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class LearnJpaApplication {

  public static void main(String[] args) {
    SpringApplication.run(LearnJpaApplication.class, args);
  }

  @Bean
  @Transactional
  CommandLineRunner runner(UserRepository userRepository) {
    return args -> {

    };
  }
}
