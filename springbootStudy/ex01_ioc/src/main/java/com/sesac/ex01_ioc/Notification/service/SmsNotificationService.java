package com.sesac.ex01_ioc.Notification.service;

import org.springframework.stereotype.Service;

@Service
public class SmsNotificationService implements NotificationService {
  @Override
  public void sendNotification(String message) {
    System.out.println("SMS Notification: " + message);
  }

}
