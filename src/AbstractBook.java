import java.time.Year;

public abstract class AbstractBook {
    protected String ISBN;
    protected String title;
    protected String author;
    protected Year yearPublished;
    protected int price;

    public AbstractBook(String ISBN, String title, String author, Year yearPublished, int price){
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.price = price;
    }

    public void displayInfo(){
        System.out.println("Quantum Bookstore - Book Details:");
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Year Published: " + yearPublished);
        if(price <= 0) {
            System.out.println("Price: This book is not for sale.");
        } else {
            System.out.println("Price: $" + price);
        }
    }
    
    public abstract String getBookType();
    public abstract boolean isForSale();

    public String getISBN() {
        return ISBN;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public Year getYearPublished() {
        return yearPublished;
    }
    
    public int getPrice() {
        return price;
    }
}
