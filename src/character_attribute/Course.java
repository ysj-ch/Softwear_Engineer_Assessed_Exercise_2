package character_attribute;


public class Course {

    private String courseName;

    public Course() {}

    public Course(String cname) {
        this.courseName = cname;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String toString() {
        return "Coursename : " + courseName;
    }

}
