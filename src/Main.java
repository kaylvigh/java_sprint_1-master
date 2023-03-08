
// Author: Kayleigh McGrath
// S3 Java Sprint 1

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> books;
    private static Library library;

    public static void main(String[] args) {

        Status available = Status.AVAILABLE;
        Status checkedOut = Status.CHECKED_OUT;
        Status overdue = Status.OVERDUE;
        books = new ArrayList<>();
        library = new Library();

        // Add Authors
        Author author1 = new Author("RICHARD_ADAMS", new Date(1920, 05, 9), new String[]{"WATERSHIP_DOWN", "THE_PLAGUE_DOGS", "SHARDIK"});
        Author author2 = new Author("GEORGE_ORWELL", new Date(1903, 06, 25), new String[]{"NINETEEN_EIGHTY-FOUR", "ANIMAL_FARM"});
        Author author3 = new Author("RAY_BRADBURY", new Date(1920, 08, 22), new String[]{"FARENHEIT_451", "THE_MARTIAN_CHRONICLES"});
        Author author4 = new Author("STEPHEN_KING", new Date(1947, 09, 21), new String[]{"THE_MIST", "UNDER_THE_DOME"});
        Author author5 = new Author("UPTON_SINCLAIR", new Date(1878, 09, 20), new String[]{"THE_JUNGLE"});

        Main.addAuthor(author1);
        Main.addAuthor(author2);
        Main.addAuthor(author3);
        Main.addAuthor(author4);
        Main.addAuthor(author5);

        // Add Books
        Book book1 = new Book("WATERSHIP_DOWN","RICHARD_ADAMS", 	"0901720313","REX_COLLINGS",1, overdue);
        Book book2 = new Book("THE_PLAGUE_DOGS","RICHARD_ADAMS", "9780713910551","ALLAN_LANE",2, checkedOut);
        Book book3 = new Book("NINETEEN_EIGHTY-FOUR", "GEORGE_ORWELL","9780451524935", "SECKER_&_WARBURG", 3, overdue);
        Book book4 = new Book("ANIMAL_FARM", "GEORGE_ORWELL", "9789356569058", "SECKER_&_WARBURG", 4, available);
        Book book5 = new Book("FARENHEIT_451", "RAY_BRADBURY","9780743247221", "SIMON_&_SCHUSTER", 5, available);
        Book book6 = new Book("THE_MARTIAN_CHRONICLES", "RAY_BRADBURY", "0553229680", "DOUBLEDAY", 6, available);
        Book book7 = new Book("THE_MIST", "STEPHEN_KING", "9780451223296", "VIKING_PRESS", 7, available);
        Book book8 = new Book("UNDER_THE_DOME", "STEPHEN_KING", "9781439148501", "SCRIBNER", 8, available);
        Book book9 = new Book("THE_JUNGLE", "UPTON_SINCLAIR", "9781503331860", "RANDOM_HOUSE", 9, available);
        Book book10 = new Book("SHARDIK", "RICHARD_ADAMS", "0380509970", "ALLEN_LANE", 10, checkedOut);

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

        // Add patrons
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

        System.out.println("\nWelcome to our Library!");
        promptUser();
    }
    public static void promptUser(){
        try{
            System.out.println("\nWho are you? \n1) Librarian \n2) Patron");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            input.nextLine();
            if (choice ==1){
                promptLibrarian();
            }else if (choice == 2) {
                promptPatron();
            } else {
                System.out.println("Invalid input.");
                promptUser();
            }
        } catch(Exception e){
            System.out.println("Invalid input.");
            promptUser();
        }
    }

    // ---- LIBRARIAN OPTIONS ----

    public static void promptLibrarian() {
        try {
            System.out.println("\nWhat would you like to do?");
            System.out.println("0) Exit.");
            System.out.println("1) Add Book.");
            System.out.println("2) Edit Book.");
            System.out.println("3) Delete Book.");
            System.out.println("4) Add Author.");
            System.out.println("5) Edit Author.");
            System.out.println("6) Delete Author.");
            System.out.println("7) Print all books.");
            System.out.print("Your choice: ");

            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    return;
                case 1:
                    addBook();
                    break;
                case 2:
                    editBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    addAuthor();
                    break;
                case 5:
                    editAuthor();
                    break;
                case 6:
                    deleteAuthor();
                    break;
                case 7:
                    printAll();
                    break;
                default:
                    System.out.println("Invalid input.");
            }
        } catch (Exception e){
            System.out.println("Invalid input.");
            promptLibrarian();
        }

    }

    public static void addBook() {
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

    // Case 2 - EDIT BOOK

    // This method is so that the user can declare the book they are editing by the ISBN.
    public static Book findBookByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null; // ISBN not found.
    }
    // EDIT BOOK
    private static void editBook() {
        System.out.print("Enter the ISBN of the book you want to edit: ");
        Scanner scanner = new Scanner(System.in);
        String isbnToEdit = scanner.nextLine();
    
        Book bookToEdit = findBookByISBN(isbnToEdit);
    
        if (bookToEdit != null) {
    
            System.out.println("What do you want to edit?");
            System.out.println("1. Title");
            System.out.println("2. Author");
            System.out.println("3. ISBN");
            System.out.println("4. Publisher");
            System.out.println("5. Status");
            System.out.print("Enter your choice: ");
    
            int choice = scanner.nextInt();
            scanner.nextLine();
    
            switch (choice) {
                case 1:
                    System.out.print("Enter the new title: ");
                    String newTitle = scanner.nextLine();
                    bookToEdit.setTitle(newTitle);
                    break;
                case 2:
                    System.out.print("Enter the new author: ");
                    String newAuthor = scanner.nextLine();
                    bookToEdit.setAuthor(newAuthor);
                    break;
                case 3:
                    System.out.print("Enter the new ISBN: ");
                    String newISBN = scanner.nextLine();
                    bookToEdit.setIsbn(newISBN);
                    break;
                case 4:
                    System.out.print("Enter the new publisher: ");
                    String newPublisher = scanner.nextLine();
                    bookToEdit.setPublisher(newPublisher);
                    break;
                case 5:
                    System.out.println("Available statuses:");
                    for (Status status : Status.values()) {
                        System.out.println(status.ordinal() + ". " + status);
                    }
                    System.out.print("Enter the new status: ");
                    int newStatusIndex = scanner.nextInt();
                    Status newStatus = Status.values()[newStatusIndex];
                    bookToEdit.setStatus(newStatus);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
            System.out.println("Book updated successfully.");
        } else {
            System.out.println("Book not found. Please try again.");
            editBook();
        }
    }

    // Case 3 - DELETE BOOK
    public static void deleteBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the ISBN of the book you want to delete:");
        String isbnToDelete = scanner.nextLine();

        boolean bookDeleted = false;

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getIsbn().equals(isbnToDelete)) {
                books.remove(i);
                bookDeleted = true;
                break;
            }
        }

        if (!bookDeleted) {
            System.out.println("Book not found in the library."); 
        }
    }

    // Case 4 - ADD AUTHOR
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

    // Case 5 - EDIT AUTHOR
    private static void editAuthor() {

    }

    // Case 6 - DELETE AUTHOR
    private static void deleteAuthor() {

    }

    // Case 7 - PRINT ALL BOOKS
    private static void printAll() {
        for(int i = 0; i < books.size(); i++){
            System.out.println(books.get(i));
        }
    }

    // ---- Patron Options ----

    public static void promptPatron() {
        try {
            System.out.println("\nWhat would you like to do?");
            System.out.println("0) Exit.");
            System.out.println("1) See All Books.");
            System.out.println("2) Search Book.");
            System.out.println("3) Borrow Book.");
            System.out.println("4) Return Book.");
            System.out.print("Enter your choice: ");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    return;
                case 1:
                    printAll();
                    break;
                case 2:
                    searchBook();
                    break;
                case 3:
                System.out.println("Enter the ISBN of the book you want to borrow:");
                String isbnToBorrow = scanner.nextLine();
                Book bookToBorrow = findBookByISBN(isbnToBorrow);
                if (bookToBorrow != null) {
                    System.out.println("How many copies do you want to borrow?");
                    int numOfCopiesToBorrow = scanner.nextInt();
                    bookToBorrow.borrowBook(bookToBorrow, numOfCopiesToBorrow);
                } else {
                    System.out.println("Book not found in the library.");
                }
                break;
                case 4:
                System.out.println("Enter the ISBN of the book you want to return:");
                String isbnToReturn = scanner.nextLine();
                Book bookToReturn = findBookByISBN(isbnToReturn);
                if (bookToReturn != null) {
                    System.out.println("How many copies are you returning?");
                    int numOfCopiesToReturn = scanner.nextInt();
                    bookToReturn.returnBook(bookToReturn, numOfCopiesToReturn);
                } else {
                    System.out.println("Book not found in the library.");
                }
                break;
                default:
                    System.out.println("Invalid input.");
            }
        } catch (Exception e){
            System.out.println("Invalid input.");
            promptPatron();
        }
    }

    // SEARCH BOOK
    private static List<Book> searchBook() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nSearch books by:");
        System.out.println("1. Title");
        System.out.println("2. Author");
        System.out.println("3. ISBN");
        System.out.print("Enter your choice: ");
    
        int choice = scanner.nextInt();
        scanner.nextLine();
    
        System.out.print("Enter the search term: ");
        String searchTerm = scanner.nextLine();
    
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (choice == 1 && book.getTitle().toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingBooks.add(book);
            } else if (choice == 2 && book.getAuthor().toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingBooks.add(book);
            } else if (choice == 3 && book.getIsbn().toLowerCase().contains(searchTerm.toLowerCase())) {
                matchingBooks.add(book);
            }
        }
        if (matchingBooks.isEmpty()) {
            System.out.println("No matching books found.");
        } else {
            System.out.println("Matching books:");
            for (Book book : matchingBooks) {
                System.out.println(book);
            }
        }
        return matchingBooks;
    }
}
