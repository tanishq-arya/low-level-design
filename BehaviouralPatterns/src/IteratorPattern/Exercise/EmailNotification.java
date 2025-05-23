// This class represents a collection of Email notifications and provides functionality to add notifications and create an iterator for traversing through them.

package IteratorPattern.Exercise;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class EmailNotification implements NotificationCollection {
    
    private List<Notification> emailNotifications;

    public EmailNotification() {
        emailNotifications = new ArrayList<>();
    }

    public void addNotification(String message) {
        emailNotifications.add(new Notification(message));
    }

    @Override
    public Iterator<Notification> createIterator() {
        // TODO: Return a new iterator for the Email Notifications using the EmailNotificationIterator class.
        return new EmailNotificationIterator(emailNotifications);
    }

    private class EmailNotificationIterator implements Iterator<Notification> {
        private int position = 0;
        private List<Notification> notifications;

        public EmailNotificationIterator(List<Notification> notifications) {
            this.notifications = notifications;
        }

        @Override
        public boolean hasNext() {
            return position < notifications.size();
        }

        @Override
        public Notification next() {
            return notifications.get(position++);
        }
    }
}