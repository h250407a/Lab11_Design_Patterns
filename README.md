# Lab 11: Design Patterns

**Student Details:**
- **Name:** Anesu B Kahanda
- **Registration Number:** H250407A
- **Department:** Computer Science
- **Course:** Object-Oriented Programming in Java

---

## Overview
This laboratory examines fundamental GoF (Gang of Four) object-oriented design patterns:
1. **Singleton Pattern:** Enforces a single instance per application with global access via private constructors.
2. **Factory Pattern:** Encapsulates object instantiation logic behind an interface or factory class.
3. **Strategy Pattern:** Enables algorithms to be swapped interchangeably at runtime via interface abstraction.
4. **Observer Pattern:** Decouples event publishers from subscriber listeners for one-to-many broadcast notifications.

---

## Files in this Directory

| File Name | Description |
|---|---|
| `SingletonFactoryDemo.java` | Program 11.1: Implements `AppConfig` singleton and `NotificationFactory` returning polymorphic email/SMS notifiers. |
| `StrategyObserverDemo.java` | Program 11.2: Implements dynamic price discount strategies and observer-based grade book notifications. |

---

## How to Compile and Run

To compile all files:
```bash
javac *.java
```

To run individual programs:
```bash
java SingletonFactoryDemo
java StrategyObserverDemo
```

---

## Expected Output Samples

### `SingletonFactoryDemo.java`
```
Same instance? true -> Harare Institute of Technology
Email Sent: Lab 11 assignment is ready for review
SMS Sent: Submission deadline is approaching
```

### `StrategyObserverDemo.java`
```
Regular Price: $200.0
Student Discount Price: $180.0

Publishing course marks:
Student portal: Object-Oriented Programming = 78
Student portal: Database Systems = 44
Academic Advisor Alert: Database Systems has failed!
```
