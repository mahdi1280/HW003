package object;

public class Course {

    private int id;
    private String name;
    private int ooz;

    public Course(int id, String name, int ooz) {
        this.id = id;
        this.name = name;
        this.ooz = ooz;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOoz() {
        return ooz;
    }

    public void setOoz(int ooz) {
        this.ooz = ooz;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ooz=" + ooz +
                '}';
    }
}
