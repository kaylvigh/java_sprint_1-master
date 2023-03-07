
public interface Borrowable {
    public void borrowBook(Book book, int numOfCopies);
    public void returnBook(Book book, int numOfCopies);
}
