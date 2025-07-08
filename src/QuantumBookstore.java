public class QuantumBookstore {
    private Inventory inventory;
    private ShippingService shippingService;
    private MailService mailService;
    
    public QuantumBookstore() {
        this.inventory = new Inventory();
        this.shippingService = new ShippingService();
        this.mailService = new MailService();
        System.out.println("Welcome to Quantum Bookstore!");
    }
    
    public void addBook(AbstractBook book) {
        inventory.addBook(book);
    }
    
    public void removeOutdatedBooks(int years) {
        System.out.println("Removing outdated books (older than " + years + " years)");
        inventory.removeOutdatedBooks(years);
    }
    
    public double buyBook(String ISBN, int quantity, String email, String address) {
        System.out.println("Processing order for: " + ISBN);
        
        AbstractBook book = inventory.getBook(ISBN);
        if (book == null) {
            System.out.println("Book not found!");
            return 0.0;
        }
        
        if (!book.isForSale()) {
            System.out.println("Sorry, this item is not available for purchase");
            return 0.0;
        }
        
        if (book instanceof PaperBook) {
            PaperBook paperBook = (PaperBook) book;
            if (paperBook.getQuantity() < quantity) {
                System.out.println("Not enough copies in stock. We have " + paperBook.getQuantity() + " available.");
                return 0.0;
            }
            
            paperBook.reduceQuantity(quantity);
            shippingService.shipBook(book, address, quantity);
        } 
        else if (book instanceof EBook) {
            mailService.sendEBook((EBook) book, email);
        }
        
        double totalAmount = book.getPrice() * quantity;
        System.out.println("Order completed! You paid: $" + totalAmount);
        return totalAmount;
    }
    
    public void displayInventory() {
        System.out.println("--- Inventory ---");
        inventory.displayInventory();
    }
}
