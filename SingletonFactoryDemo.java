// Demonstrates Singleton and Factory object creation patterns.
// ---------- SINGLETON PATTERN ----------
class AppConfig {
    // Eagerly instantiated private static final instance
    private static final AppConfig INSTANCE = new AppConfig();
    private final String institution = "Harare Institute of Technology";

    // Private constructor prevents external instantiation
    private AppConfig() {}

    public static AppConfig getInstance() {
        return INSTANCE;
    }

    public String getInstitution() {
        return institution;
    }
}

// ---------- FACTORY PATTERN ----------
interface Notification {
    void send(String message);
}

class EmailNotification implements Notification {
    @Override
    public void send(String m) {
        System.out.println("Email Sent: " + m);
    }
}

class SmsNotification implements Notification {
    @Override
    public void send(String m) {
        System.out.println("SMS Sent: " + m);
    }
}

class NotificationFactory {
    // Factory method decouples client code from concrete implementations
    static Notification create(String type) {
        return switch (type.toLowerCase()) {
            case "email" -> new EmailNotification();
            case "sms" -> new SmsNotification();
            default -> throw new IllegalArgumentException("Unknown notification type: " + type);
        };
    }
}

public class SingletonFactoryDemo {
    public static void main(String[] args) {
        // Singleton verification
        AppConfig a = AppConfig.getInstance();
        AppConfig b = AppConfig.getInstance();
        System.out.println("Same instance? " + (a == b) + " -> " + a.getInstitution());

        // Factory usage
        Notification notif1 = NotificationFactory.create("email");
        Notification notif2 = NotificationFactory.create("sms");

        notif1.send("Lab 11 assignment is ready for review");
        notif2.send("Submission deadline is approaching");
    }
}
