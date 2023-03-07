
import java.util.Date;
import java.util.List;
import javax.swing.text.StyledEditorKit;

public class Library extends Main {
    public static void main(String[] args) {
        Status available = Status.AVAILABLE;
        Status checkedOut = Status.CHECKED_OUT;
        Status overdue = Status.OVERDUE;

        Library library = new Library();

        Author author1 = new Author("RICHARD_ADAMS", new Date(1960, 06, 7), new String[]{"WATERSHIP_DOWN", "THE_PLAGUE_DOGS"});
        Author author2 = new Author("", new Date(1943, 11, 12), new String[]{""});
        Author author3 = new Author("", new Date(1929, 12, 24), new String[]{""});
        Author author4 = new Author("", new Date(1907, 05, 15), new String[]{""});
        Author author5 = new Author("", new Date(1934, 07, 24), new String[]{"" });

        Main.addAuthor(author1);
        Main.addAuthor(author2);
        Main.addAuthor(author3);
        Main.addAuthor(author4);
        Main.addAuthor(author5);

        Book book1 = new Book("WATERSHIP_DOWN","RICHARD_ADAMS", "1","",1, overdue);
        Book book2 = new Book("PLAGUE_DOGS","RICHARD_ADAMS", "124","",2, checkedOut);
        Book book3 = new Book("", "","125", "", 3, overdue);
        Book book4 = new Book("", "", "126", "", 4, available);
        Book book5 = new Book("", "","127", "", 5, available);
        Book book6 = new Book("", "", "128", "", 6, available);
        Book book7 = new Book("", "", "129", "", 7, available);
        Book book8 = new Book("", "", "130", "", 8, available);
        Book book9 = new Book("", "", "131", "", 9, available);
        Book book10 = new Book("", "", "132", "", 10, checkedOut);

        Main.addBook(book1);
        Main.addBook(book2);
        Main.addBook(book3);
        Main.addBook(book4);
        Main.addBook(book5);
        Main.addBook(book6);
        Main.addBook(book7);
        Main.addBook(book8);
        Main.addBook(book9);
        Main.addBook(book10);

        Patron patron1 = new Patron("James Kirk", "42 Canada Drive", "(709)123-4567",null);
        Patron patron2 = new Patron("Mr. Spock", "1 First Street", "(709)891-2345", null);
        Patron patron3 = new Patron("Leonard McCoy", "435 Meowmeow Crescent", "(709)678-9123", null);
        Patron patron4 = new Patron("Nyota Uhura", "6 Bunny Boulevard", "(709)456-7891", null);
        Patron patron5 = new Patron("Montgomery Scott", "37 Fishbone Parkway", "(709)234-5678", null);

        library.addPatron(patron1);
        library.addPatron(patron2);
        library.addPatron(patron3);
        library.addPatron(patron4);
        library.addPatron(patron5);
    }