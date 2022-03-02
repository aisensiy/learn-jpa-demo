package com.example.learnjpa.notifications;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@Import(NotificationRepository.class)
class NotificationRepositoryTest {
  @Autowired NotificationRepository notificationRepository;
  @Test
  void test() {
    Notification notification = Notification.buildValidationEmail(
        "aisensiy@mail.com",
        "title",
        "validation content");
    notificationRepository.save(notification);
    System.out.println(notification);
    notificationRepository.findByStatus(NotificationStatus.PENDING).forEach(System.out::println);
  }
}