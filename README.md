# Quantum Bookstore System

Online bookstore system built for Fawry internship challenge.

## Problem
Need to create different book types (paper books with stock, e-books with email delivery, demo books not for sale) that behave differently when purchased. Each type needs its own delivery method without duplicating code.

## Solution
Used **Strategy Pattern** and **Template Method** to handle different book behaviors:

```java
// Different books, same interface
AbstractBook ebook = new EBook("ISBN-001", "Java Book", "Author", Year.of(2023), 25, "PDF");
AbstractBook paperBook = new PaperBook("ISBN-002", "Design Patterns", "Author", Year.of(2022), 45, 10);

// Purchase logic handles each type differently
bookstore.buyBook("ISBN-001", 1, "user@email.com", "123 Main St");
```

## Features
- Books with ISBN, title, author, price, year
- Paper books track quantity and ship physically
- E-books send via email with file type
- Demo books display but can't be purchased
- Inventory management with outdated book removal
- Purchase system with delivery routing
- Error handling (no stock, invalid books, demo purchases)
- **Extensible design** - add new book types without modifying existing code

## Extensibility
System designed for easy extension. To add a new book type:

```java
// 1. Create new book class extending AbstractBook
public class AudioBook extends AbstractBook {
    private String duration;
    
    public AudioBook(String ISBN, String title, String author, Year year, int price, String duration) {
        super(ISBN, title, author, year, price);
        this.duration = duration;
    }
    
    @Override
    public String getBookType() { return "Audio Book"; }
    
    @Override
    public boolean isForSale() { return true; }
}

// 2. Add delivery service if needed
public class StreamingService {
    public void streamAudio(AudioBook book, String email) { /* implementation */ }
}

// 3. Update buyBook() method in QuantumBookstore to handle new type
```

No changes needed to existing book classes, inventory, or core business logic.

## Run
```bash
cd src
javac *.java
java Test
```

## Files
- AbstractBook.java - base book template
- EBook.java, PaperBook.java, DemoBook.java - book types
- Inventory.java - book storage
- QuantumBookstore.java - main business logic
- MailService.java, ShippingService.java - delivery strategies
- Test.java - demo

The strategy pattern solved the delivery problem and template method avoided code duplication across book types.
