
import java.time.Year;

public class EBook extends AbstractBook {
    private String fileType;

    public EBook(String ISBN, String title, String author, Year yearPublished, int price, String fileType) {
        super(ISBN, title, author, yearPublished, price);
        this.fileType = fileType;
    }
    
    public String getFileType() {
        return fileType;
    }
    
    @Override
    public String getBookType() {
        return "E-Book";
    }
    
    @Override
    public boolean isForSale() {
        return true;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("File Type: " + fileType);
    }
}
