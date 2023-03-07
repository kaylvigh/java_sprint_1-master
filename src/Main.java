
// Author: Kayleigh McGrath
// S3 Java Sprint 1

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ArrayList<Book> books;

    public static void main(String[] args) {
        books = new ArrayList<>();

        System.out.println("\nWelcome to our Library!");
        promptUser();
    }
    public static void promptUser(){
        try{
            System.out.println("\nWho are you? \n1) Librarian \n2) Patron");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            if (choice ==1){
                promptLibrarian();
            }else if (choice == 2) {
                System.out.println("\nWhat would you like to do?");
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
            System.out.println("1) Add Book.");
            System.out.println("2) Edit Book.");
            System.out.println("3) Delete Book.");
            System.out.println("4) Add Author.");
            System.out.println("5) Edit Author.");
            System.out.println("6) Delete Author.");
            System.out.println("7) Print all books.");
            System.out.println("8) Exit.");
            Scanner input = new Scanner(System.in);
            int choice = input.nextInt();
            switch (choice) {
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
                case 8:
                    return;
                default:
                    System.out.println("Invalid input.");
            }
        } catch (Exception e){
            System.out.println("Invalid input.");
            promptLibrarian();
        }
        promptLibrarian();
    }

    // Case 1 - ADD BOOK
    private static void addBook() {
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("\nAdd a new book:\n- What is the title of the book?");
            String title = input.next();
            System.out.println("- What is the name of the author?");
            String author = input.next();
            System.out.println("- What is the ISBN?");
            String isbn = input.next();
            System.out.println("- Who is the publisher?");
            String publisher = input.next();
            System.out.println("- How many copies are there?");
            int numOfCopies = input.nextInt();
            Book book = new Book(title, author, isbn, publisher, numOfCopies, status);
            Main.addBook(book);
            System.out.println("\n'"+title+"' has been added successfully.");
        } catch (Exception e) {
            System.out.println("Invalid input. Let's try again!");
            addBook();
        }
    }

    // Case 2 - EDIT BOOK
    private static void editBook(Book book, String itemToEdit, String editedItem) {
        switch (itemToEdit.toLowerCase()){
            case "title" :
                System.out.println("This book's title has been changed to " + editedItem + ".");
                book.setTitle(editedItem);
                break;
            case "author" :
                System.out.println("This book's author has been changed to " + editedItem + ".");
                book.setTitle(editedItem);
                break;
            case "isbn" :
                System.out.println("This book's ISBN has been changed to " + editedItem + ".");
                book.setTitle(editedItem);
                break;
            case "publisher" :
                System.out.println("This book's publisher has been changed to " + editedItem + ".");
                book.setTitle(editedItem);
                break;
            case "numOfCopies" :
                System.out.println("This book's amount of copies has been changed " + editedItem + ".");
                book.setTitle(editedItem);
                break;
            default :
                System.out.println("Oops! Something went wrong.");
        }
    }

    // Case 3 - DELETE BOOK
    private static void deleteBook() {
        
    }

    // Case 4 -
    private static void addAuthor() {

    }

    // Case 5 - 
    private static void editAuthor() {

    }

    // Case 6 - 
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
        
    }

    public Book search(String key, String query){
        return null;
    }
    public static void addBook(Book newBook){
        books.add(newBook);
    }
}
