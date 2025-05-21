// This class manages different types of notifications (email, SMS, push) and provides methods to add notifications and print them using an iterator pattern.

package IteratorPattern.Exercise;

import java.util.Iterator;

public class NotificationManager {
    
    private NotificationCollection emailNotifications;
    private NotificationCollection smsNotifications;
    private NotificationCollection pushNotifications;

    public NotificationManager() {
        
        // TODO: Initialize Email Notifications using the class responsible for handling Email Notifications.
        emailNotifications = new EmailNotification();
        
        // TODO: Initialize SMS Notifications using the class responsible for handling SMS Notifications.
        smsNotifications = new SMSNotification();
        
        // TODO: Initialize Push Notifications using the class responsible for handling Push Notifications.
        pushNotifications = new PushNotification();

    }

    public void addEmailNotification(String message) {
        ((EmailNotification) emailNotifications).addNotification(message);
    }

    public void addSMSNotification(String message) {
        ((SMSNotification) smsNotifications).addNotification(message);
    }

    public void addPushNotification(String message) {
        ((PushNotification) pushNotifications).addNotification(message);
    }

    public void printAllNotifications() {
        printNotifications(emailNotifications.createIterator(), "Email");
        printNotifications(smsNotifications.createIterator(), "SMS");
        printNotifications(pushNotifications.createIterator(), "Push");
    }

    private void printNotifications(Iterator<Notification> iterator, String type) {
        System.out.println(type + " Notifications:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next().getMessage());
        }
    }
}