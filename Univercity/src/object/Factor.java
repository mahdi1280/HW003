package object;

public class Factor {

    private int id;
    private User user;
    private TermCourse termCourse;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public TermCourse getTermCourse() {
        return termCourse;
    }

    public void setTermCourse(TermCourse termCourse) {
        this.termCourse = termCourse;
    }
}
