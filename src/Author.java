
// import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Author {
    // Variables: 
    private String name;
    private Date dateOfBirth;
    public String[] booksWritten;

    // Method override:
    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", booksWritten='" + Arrays.toString(booksWritten) + '\'' +
                '}';
    }

    public Author(String name, Date dateOfBirth, String[] booksWritten){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.booksWritten = booksWritten;
    }

    public void setAuthorName(String name) {
        this.name = name;
    }

    public String getAuthorName() {
        return name;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
