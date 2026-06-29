interface Notification {

    void send();
}

// Concrete Classes
class EmailNotification implements Notification {

    public void send() {
        System.out.println("Sending Email Notification");
    }
}

class SMSNotification implements Notification {

    public void send() {
        System.out.println("Sending SMS Notification");
    }
}

class PushNotification implements Notification {

    public void send() {
        System.out.println("Sending Push Notification");
    }
}

// Factory Class
class NotificationFactory {

    public Notification createNotification(String type) {

        if (type.equalsIgnoreCase("EMAIL")) {
            return new EmailNotification();
        }

        if (type.equalsIgnoreCase("SMS")) {
            return new SMSNotification();
        }

        if (type.equalsIgnoreCase("PUSH")) {
            return new PushNotification();
        }

        return null;
    }
}

public class FactoryMethodExample {

    public static void main(String[] args) {

        NotificationFactory factory =
                new NotificationFactory();

        Notification n1 =
                factory.createNotification("EMAIL");

        Notification n2 =
                factory.createNotification("SMS");

        Notification n3 =
                factory.createNotification("PUSH");

        n1.send();
        n2.send();
        n3.send();
    }
}