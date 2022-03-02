package com.example.learnjpa.first.domain;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserRepositoryTest {
  @Autowired
  private UserRepository userRepository;
  @Test
  void should_save_and_fetch_data_success() {
    Address address = new Address("Beijing", "Beijing", "Daojiayuan", "No.1");
    User user = new User("zhangsan", address);
    userRepository.save(user);
    userRepository.findByUsername(user.getUsername()).ifPresent(System.out::println);
  }
}