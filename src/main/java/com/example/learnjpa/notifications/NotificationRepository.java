package com.example.learnjpa.notifications;

import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class NotificationRepository {
  private final JpaNotificationMapper mapper;

  public void save(Notification notification) {
    mapper.save(notification);
  }

  public List<Notification> findByStatus(NotificationStatus status) {
    PageRequest pageRequest = PageRequest.of(0, 30, Sort.by("createdAt").descending());
    if (status == null) {
      return mapper.findAll(pageRequest).getContent();
    } else if (status == NotificationStatus.PENDING) {
      BooleanExpression withPendingStatus = QNotification.notification.status.eq(NotificationStatus.PENDING);
      BooleanExpression notExpired = QNotification.notification.expiredAt.gt(LocalDateTime.now());
      return mapper.findAll(
          withPendingStatus.and(notExpired),
          pageRequest
      ).getContent();
    } else {
      return mapper.findAll(
          QNotification.notification.status.eq(NotificationStatus.PROCESSED),
          pageRequest
      ).getContent();
    }
  }
}
