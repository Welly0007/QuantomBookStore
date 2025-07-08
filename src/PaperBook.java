import java.time.Year;

public class PaperBook extends AbstractBook {
    private int quantity;

    public PaperBook(String ISBN, String title, String author, Year yearPublished, int price, int quantity) {
        super(ISBN, title, author, yearPublished, price);
        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity cannot be negative");
        }
        this.quantity = quantity;
    }

    public int getQuantity(){
        return quantity;
    }
    
    public void reduceQuantity(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot reduce by negative amount");
        }
        if (amount > quantity) {
            throw new IllegalArgumentException("Insufficient stock");
        }
        this.quantity -= amount;
    }
    
    @Override
    public String getBookType() {
        return "Paper Book";
    }
    
    @Override
    public boolean isForSale() {
        return quantity > 0;
    }
    
    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Quantity in stock: " + quantity);
    }
}
