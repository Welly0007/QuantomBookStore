import java.time.Year;

public class Test {
    
    public static void main(String[] args) {
        System.out.println("=".repeat(60));
        System.out.println("Quantum Bookstore - Full System Test");
        System.out.println("=".repeat(60));
        
        // Create the bookstore
        QuantumBookstore bookstore = new QuantumBookstore();
        
        // Test 1: Adding books to inventory
        System.out.println("\n1. ADDING BOOKS TO INVENTORY:");
        
        EBook ebook = new EBook("ISBN-001", "Java Programming", "Ahmed Adel", Year.of(2023), 25, "PDF");
        PaperBook paperBook = new PaperBook("ISBN-002", "Design Patterns", "Samir Walid", Year.of(2022), 45, 10);
        DemoBook demoBook = new DemoBook("ISBN-003", "Free Sample Book", "Walid Salim", Year.of(2024));
        PaperBook oldBook = new PaperBook("ISBN-004", "Ancient Programming", "Ahmed Zewil", Year.of(1945), 15, 5);
        
        bookstore.addBook(ebook);
        bookstore.addBook(paperBook);
        bookstore.addBook(demoBook);
        bookstore.addBook(oldBook);
        
        // Test 2: Display inventory
        System.out.println("\n2. CURRENT INVENTORY:");
        bookstore.displayInventory();
        
        // Test 3: Remove outdated books
        System.out.println("\n3. REMOVING OUTDATED BOOKS (older than 30 years):");
        bookstore.removeOutdatedBooks(30);
        
        System.out.println("\nInventory after removing outdated books:");
        bookstore.displayInventory();
        
        // Test 4: Buying books
        System.out.println("\n4. BUYING BOOKS:");
        System.out.println("-".repeat(40));
        
        // Buy EBook
        System.out.println("Buying EBook...");
        double amount1 = bookstore.buyBook("ISBN-001", 1, "customer@email.com", "123 Giza");
        System.out.println("Amount paid for EBook: $" + amount1);
        
        // Buy Paper Book
        System.out.println("\nBuying Paper Book...");
        double amount2 = bookstore.buyBook("ISBN-002", 2, "customer@email.com", "123 Giza");
        System.out.println("Amount paid for Paper Book: $" + amount2);

        // Try to buy Demo Book (should fail)
        System.out.println("\nTrying to buy Demo Book...");
        double amount3 = bookstore.buyBook("ISBN-003", 1, "customer@email.com", "123 Giza");
        System.out.println("Amount paid for Demo Book: $" + amount3);

        // Try to buy more than available (should fail)
        System.out.println("\nTrying to buy more paper books than available...");
        double amount4 = bookstore.buyBook("ISBN-002", 20, "customer@email.com", "123 Giza");
        System.out.println("Amount paid for excess Paper Books: $" + amount4);

        // Try to buy non-existent book (should fail)
        System.out.println("\nTrying to buy non-existent book...");
        double amount5 = bookstore.buyBook("ISBN-999", 1, "customer@email.com", "123 Giza");
        System.out.println("Amount paid for non-existent book: $" + amount5);

        // Test 5: Final inventory check
        System.out.println("\n5. FINAL INVENTORY STATUS:");
        bookstore.displayInventory();
        
        System.out.println("\n" + "=".repeat(60));
        System.out.println("Quantum Bookstore - Test completed successfully!");
    }
}
