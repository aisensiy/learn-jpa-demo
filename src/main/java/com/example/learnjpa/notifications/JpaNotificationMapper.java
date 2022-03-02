package com.example.learnjpa.notifications;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface JpaNotificationMapper extends JpaRepository<Notification, Long>, QuerydslPredicateExecutor<Notification> {
}
