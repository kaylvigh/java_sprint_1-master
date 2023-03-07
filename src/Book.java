
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

    // Borrow Book:
    @Override
    public void borrowBook(Book book, int numOfCopies) {
        if (numOfCopies == 0) {
            System.out.println("We do not have enough of this book to fulfil your request. Please try again!");
        } else if  (book.getNumOfCopies() < 0){
            System.out.println("Sorry! We do not currently have the book you are looking for.");
        } else if (book.getNumOfCopies() - numOfCopies < 0) {
            System.out.println("Sorry! We currently have" + book.getNumOfCopies() + " copies of " + book.getTitle() + "with us today!");
        } else if (book.getNumOfCopies() - numOfCopies >= 0 ) {
            book.setNumOfCopies(book.getNumOfCopies() - numOfCopies);
            System.out.println("Your book(s) have successfully been borrowed, we hope to see you again!");
        }
    }

    // Return Book:
    @Override
    public void returnBook(Book book, int numOfCopies) {
        book.setNumOfCopies(book.getNumOfCopies() + numOfCopies);
    }

}
