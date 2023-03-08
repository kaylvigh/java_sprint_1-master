
import java.util.List;
import java.util.Scanner;
import java.util.Date;

public class Library extends Main{
    private List<Patron> patrons;
    public List<Book> books;
    public List<Author> authors;

    public void addPatron(Patron patron) {
        patrons.add(patron);
    }

    public static void addBook(Book book) {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\nAdd a new book:\n- What is the title of the book?");
            input.nextLine();
            String title = input.nextLine();
            System.out.println("- What is the name of the author?");
            input.nextLine();
            String author = input.nextLine();
            System.out.println("- What is the ISBN?");
            input.nextLine();
            String isbn = input.nextLine();
            System.out.println("- Who is the publisher?");
            input.nextLine();
            String publisher = input.nextLine();
            System.out.println("- How many copies are there?");
            input.nextLine();
            int numOfCopies = input.nextInt();
            Book book = new Book(title, author, isbn, publisher, numOfCopies, Status.AVAILABLE);
            books.add(book);
            System.out.println("\n'" + title + "' has been added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Let's try again!");
            addBook();
        }
    }

    public static void addAuthor() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\nAdd a new author:\n- What is the author's name?");
            input.nextLine();
            String name = input.nextLine();
            System.out.println("- What is the author's birthdate? (YYYY-MM-DD)");
            String birthdateStr = input.nextLine();
            Date birthdate = Date.valueOf(birthdateStr);
            System.out.println("- What are the author's notable works? (separated by commas)");
            String[] notableWorks = input.nextLine().split(",");
            Author author = new Author(name, birthdate, notableWorks);
            library.addAuthor(author);
            System.out.println("\n'" + name + "' has been added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Let's try again!");
            addAuthor();
        }
    }

    
}
