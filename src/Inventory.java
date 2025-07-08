import java.util.HashMap;
import java.util.Map;
import java.time.Year;
public class Inventory{
    private Map<String, AbstractBook> books;

    public Inventory() {
        this.books = new HashMap<>();
    }
    public void addBook(AbstractBook book){
        if(book != null){
            books.put(book.getISBN(), book);
            System.out.println("Book added to inventory: " + book.getTitle());
        }else{
            System.out.println("Invalid book. Cannot add to inventory.");
        }
    }
    public void removeBook(AbstractBook book){
        if(book != null){
            books.remove(book.getISBN());
        }
    }
    public AbstractBook getBook(String ISBN){
        return books.get(ISBN);
    }
    public void displayInventory(){
        if(books.isEmpty()){
            System.out.println("Inventory is empty.");
        }else{
            System.out.println("Current Inventory:");
            for(AbstractBook book : books.values()){
                book.displayInfo();
                System.out.println("-------------------");
            }
        }
    }

    public void removeOutdatedBooks(int years) {
        Year deleteBefore = Year.now().minusYears(years);
        java.util.List<String> toRemove = new java.util.ArrayList<>();
        
        for(AbstractBook book: books.values()){
            if(book.getYearPublished().isBefore(deleteBefore)){
                System.out.println("Removing outdated book before year " + deleteBefore + ": " + book.getTitle() + " published in " + book.getYearPublished());
                toRemove.add(book.getISBN());
            }
        }
        
        for(String isbn : toRemove) {
            books.remove(isbn);
        }
    }
}