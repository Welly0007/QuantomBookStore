import java.time.Year;

public class DemoBook extends AbstractBook {
    
    public DemoBook(String ISBN, String title, String author, Year yearPublished) {
        super(ISBN, title, author, yearPublished, 0);
    }
    
    @Override
    public String getBookType() {
        return "Demo Book";
    }
    
    @Override
    public boolean isForSale() {
        return false;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("*** THIS IS A DEMO BOOK - NOT FOR SALE ***");
    }
}
