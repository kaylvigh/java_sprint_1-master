
public class Book extends Main implements Borrowable{

    private String title;
    private String author;
    private String isbn; 
    private String publisher;
    private int numOfCopies;
    private Status status;

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publisher='" + publisher + '\'' +
                ", numOfCopies=" + numOfCopies +
                ", status=" + status +
                '}';
    }

    public Book(String title, String author, String isbn, String publisher, int numOfCopies, Status status){
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publisher = publisher;
        this.numOfCopies = numOfCopies;
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setNumOfCopies(int numOfCopies) {
        this.numOfCopies = numOfCopies;
    }

    public int getNumOfCopies() {
        return numOfCopies;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    // Borrow Book:
    @Override
    public synchronized void borrowBook(Book book, int numOfCopies) {
        try {
            if (book == null) {
                throw new IllegalArgumentException("Book cannot be null.");
            }
            if (numOfCopies < 1) {
                throw new IllegalArgumentException("Number of copies must be positive.");
            }
            if (book.getNumOfCopies() < numOfCopies) {
                throw new IllegalArgumentException("Not enough copies available to borrow.");
            }
            book.setNumOfCopies(book.getNumOfCopies() - numOfCopies);
            System.out.println("Your book(s) have successfully been borrowed, we hope to see you again!");
        } catch (Exception e) {
            System.out.println("Error borrowing book: " + e.getMessage());
        }
    }

    // Return Book:
    @Override
    public synchronized void returnBook(Book book, int numOfCopies) {
        try {
            if (book == null) {
                throw new IllegalArgumentException("Book cannot be null.");
            }
            if (numOfCopies < 1) {
                throw new IllegalArgumentException("Number of copies must be positive.");
            }
            book.setNumOfCopies(book.getNumOfCopies() + numOfCopies);
            System.out.println("Your book(s) have successfully been returned.");
        } catch (Exception e) {
            System.out.println("Error returning book: " + e.getMessage());
        }
    }
}

