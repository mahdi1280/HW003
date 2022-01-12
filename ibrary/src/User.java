import java.time.LocalDateTime;

public class User {

    private String name;
    private ReservBook[] book = new ReservBook[2];

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public ReservBook[] getBook() {
        return book;
    }

    public void setBook(ReservBook[] book) {
        this.book = book;
    }
}
