import java.time.LocalDate;

public class ShippingService {
    
    public ShippingService() {
        System.out.println("Quantum Bookstore - Shipping Service initialized");
    }
    
    public void shipBook(AbstractBook book, String address, int quantity) {
        System.out.println("Quantum Bookstore - Shipping " + quantity + " copy(ies) of '" + book.getTitle() + "'");
        System.out.println("Quantum Bookstore - Destination: " + address);
        System.out.println("Quantum Bookstore - Expected delivery: " + LocalDate.now().plusDays(3));
        System.out.println("Quantum Bookstore - Book shipped successfully!");
    }
}