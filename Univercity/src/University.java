import object.*;

import java.util.ArrayList;
import java.util.List;

public class University {

    private final List<User> users = new ArrayList<>();
    private final List<Course> courses = new ArrayList<>();
    private final List<TermCourse> termCourses=new ArrayList<>();
    private final List<Term> terms=new ArrayList<>();
    private final List<Factor> factors=new ArrayList<>();
    private int factorId=0;
    private int terId=0;
    private int termCourseId=1;
    private int userId=1;
    private int courseId=1;

    public void saveCourse(String name,int ooz){
        Course course=new Course(courseId++,name,ooz);
        courses.add(course);
    }

    public boolean deleteCourse(int courseId){
        for (int i=0;i<this.courses.size();i++){
            if(this.courses.get(i).getId() == courseId) {
                this.courses.remove(this.courses.get(i));
                return true;
            }
        }
        return false;
    }

    public List<Course> getCourses(){
        return this.courses;
    }

    public void save(User user){
        user.setId(userId++);
        this.users.add(user);
    }

    public User login(String userName,String password){
        for (User user: users) {
            if(user.getUserName().equals(userName) && user.getPassword().equals(password)){
                return user;
            }
        }
        return null;
    }

    public List<User> getUserByRole(Role role){
        List<User> userList = new ArrayList<>();
        for (User user: this.users) {
            if(user.getRole().equals(role))
                userList.add(user);
        }
        return userList;
    }

    public boolean userDelete(int userId){
        for (int i=0;i<this.users.size();i++){
            if(this.users.get(i).getId() == userId) {
                this.users.remove(this.users.get(i));
                return true;
            }
        }
        return false;
    }

    public boolean updateUser(int id,String firstName,String lastName){
        for (int i=0;i<this.users.size();i++){
            if(this.users.get(i).getId() == id) {
                this.users.get(i).setFirstName(firstName);
                this.users.get(i).setFirstName(lastName);
                return true;
            }
        }
        return false;
    }

    public void addTermCourse(TermCourse termCourse){
        termCourse.setId(termCourseId);
        termCourseId++;
        termCourses.add(termCourse);

    }

    public Course getCoursesById(int index) {
        for(Course course:this.courses)
            if(course.getId()==index)
                return course;
            return null;

    }

    public void showTermCourse(User student) {
        for(User user:this.users){
            if(user.equals(student))
                user.getCourses().forEach(System.out::println);
        }
    }

    public void addNomre(int score,int id){
        for (TermCourse termCourse :this.termCourses) {
            if(termCourse.getId()==id)
                termCourse.setScore(score);
        }
    }
    public void shwFactor(User user){
        for(Factor factor:this.factors){
            if(factor.getUser().equals(user))
                System.out.println(factor.toString());
        }
    }
}
