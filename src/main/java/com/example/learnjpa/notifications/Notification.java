package com.example.learnjpa.notifications;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "notifications")
@NoArgsConstructor(force = true)
@ToString
@RequiredArgsConstructor
public class Notification {
  @Id
  @GeneratedValue(strategy = javax.persistence.GenerationType.IDENTITY)
  private Long id;

  final private String title;
  final private String content;
  final private String target;

  final private NotificationName name;
  final private NotificationCategory category;

  final private NotificationStatus status;

  final private LocalDateTime createdAt;
  final private LocalDateTime expiredAt;

  public static Notification buildValidationEmail(String target, String title, String content) {
    LocalDateTime now = LocalDateTime.now();
    return new Notification(title, content, target, NotificationName.EMAIL_VALIDATION, NotificationCategory.EMAIL,
        NotificationStatus.PENDING, LocalDateTime.now(), now.plusMinutes(5));
  }
}

enum NotificationCategory {
  EMAIL,
  SHORT_MESSAGE
}

enum NotificationStatus {
  PENDING,
  PROCESSED
}

enum NotificationName {
  EMAIL_VALIDATION,
  PHONE_VALIDATION,

  PASSWORD_RESET_BY_PHONE,
  PASSWORD_RESET_BY_EMAIL,

  IDLE_NOTEBOOK_WARNING,
  IDLE_NOTEBOOK_KILL,

  LOW_QUOTA_WARNING,
  OUT_OF_QUOTA_KILL,

  SERVING_LOW_QUOTA_WARNING,
  SERVING_OUT_OF_QUOTA_KILL,

  RESOURCE_TRANSFER_REQUEST,
  RESOURCE_TRANSFER_REQUEST_REJECTED,
  RESOURCE_TRANSFER_REQUEST_APPROVED,

  INVITATION_MEMBER_REQUEST,

  INSUFFICIENT_BALANCE,

  DEPOSIT_SUCCESS,
  ORDER_SUCCESS,
  RENEW_SUBSCRIPTION_SUCCESS,
  UPGRADE_SUBSCRIPTION,
  DEGRADE_SUBSCRIPTION
}