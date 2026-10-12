// Demonstrates Strategy and Observer behavioral design patterns.
import java.util.ArrayList;
import java.util.List;

// ---------- STRATEGY PATTERN ----------
interface DiscountStrategy {
    double apply(double price);
}

class Checkout {
    private DiscountStrategy strategy;

    Checkout(DiscountStrategy strategy) {
        this.strategy = strategy;
    }

    void setStrategy(DiscountStrategy strategy) {
        this.strategy = strategy; // Change algorithm dynamically at runtime
    }

    double total(double price) {
        return strategy.apply(price);
    }
}

// ---------- OBSERVER PATTERN ----------
interface GradeListener {
    void onGradePublished(String course, int mark);
}

class GradeBook {
    private final List<GradeListener> listeners = new ArrayList<>();

    void subscribe(GradeListener l) {
        listeners.add(l);
    }

    void publish(String course, int mark) {
        for (GradeListener l : listeners) {
            l.onGradePublished(course, mark); // Broadcast notification to subscribers
        }
    }
}

public class StrategyObserverDemo {
    public static void main(String[] args) {
        // Strategy pattern with lambdas
        Checkout checkout = new Checkout(price -> price); // No discount
        System.out.println("Regular Price: $" + checkout.total(200));

        checkout.setStrategy(price -> price * 0.90); // 10% student discount
        System.out.println("Student Discount Price: $" + checkout.total(200));

        // Observer pattern: register listeners
        GradeBook book = new GradeBook();
        book.subscribe((course, mark) -> System.out.println("Student portal: " + course + " = " + mark));
        book.subscribe((course, mark) -> {
            if (mark < 50) {
                System.out.println("Academic Advisor Alert: " + course + " has failed!");
            }
        });

        System.out.println("\nPublishing course marks:");
        book.publish("Object-Oriented Programming", 78);
        book.publish("Database Systems", 44);
    }
}
