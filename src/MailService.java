public class MailService {
    
    public MailService() {
        System.out.println("Quantum Bookstore - Mail Service initialized");
    }
    
    public void sendEBook(EBook ebook, String email) {
        System.out.println("Quantum Bookstore - Sending EBook '" + ebook.getTitle() + "' to email: " + email);
        System.out.println("Quantum Bookstore - EBook format: " + ebook.getFileType());
        System.out.println("Quantum Bookstore - Email sent successfully!");
    }
}
