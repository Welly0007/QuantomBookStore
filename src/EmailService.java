public class EmailService implements DeliveryService {
    private String deliveryServiceName = "Email Service";
    private String bookTitle;
    private String customerName;
    private String customerEmail;

    public EmailService(String bookTitle, String customerName, String customerEmail) {
        this.bookTitle = bookTitle;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
    }
    @Override
    public void deliver() {
        System.out.println("An email has been sent to " + customerEmail + " for the book '" + bookTitle + "'");
        System.out.println("Dear " + customerName + ", your book is ready for download.");
    }
    public String getName() {
        return deliveryServiceName;
    }
}