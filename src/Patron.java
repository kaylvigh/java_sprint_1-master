
import java.util.ArrayList;
import java.util.List;

public class Patron {

    private String name;
    private String address;
    private String phoneNumber;
    private ArrayList<Book> borrowed;

    public Patron(String name, String address, String phoneNumber, ArrayList<Book> borrowed) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.borrowed = borrowed;
    }

    @Override
    public String toString() {
        return "Patron{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", borrowed=" + (borrowed) +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

   public List<Book> getBorrowed() { 
        return borrowed; 
    }

   public void addBorrowed(Book book) {
        this.borrowed.add(book); 
    }

   public void removeBorrowed(Book book) { 
        this.borrowed.remove(book);
    }
}
