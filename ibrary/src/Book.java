public class Book {

    private String name;
    private String nasher;
    private String createdYear;
    private Writer writer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNasher() {
        return nasher;
    }

    public void setNasher(String nasher) {
        this.nasher = nasher;
    }

    public String getCreatedYear() {
        return createdYear;
    }

    public void setCreatedYear(String createdYear) {
        this.createdYear = createdYear;
    }

    public Writer getWriter() {
        return writer;
    }

    public void setWriter(Writer writer) {
        this.writer = writer;
    }


    @Override
    public String toString() {
        return name+" "+name+" "+ createdYear;
    }
}
