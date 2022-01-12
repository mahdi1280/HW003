import java.time.LocalDateTime;

public class Library {

    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public void findWriter(String lastName){
        for (Book book: this.books) {
            if(book.getWriter().getLastName().equals(lastName)){
                System.out.println(book.getWriter().toString());
            }
        }
    }

    public void findWriter(String lastName,String firName){
        for (Book book: this.books) {
            if(book.getWriter().getLastName().equals(lastName) &&
                    book.getWriter().getFirstName().equals(firName)){
                System.out.println(book.toString());
            }
        }
    }


    public void findByBookName(String name){
        for (Book book: this.books) {
            if(book.getName().equals(name))
                System.out.println(book.toString());
        }
    }


    public boolean reserved(User user){
        if(user.getBook().length ==2 &&
                user.getBook()[1] != null)
            return false;
        return true;
    }

    public int getPrice(User user){
        int sum=0;
        for (ReservBook book: user.getBook()) {
          int a=  LocalDateTime.now().getDayOfYear() -  book.getLocalDateTime().getDayOfYear();
          a-=7;
          if(a>0)
              sum += a*1000;
        }
        return sum;
    }
}
