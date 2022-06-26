import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Course {
    private String courseName;
    private String courseCode;
    private int creditScore;
    private List<Student> courseList = new ArrayList<Student>();
    private Instructor instructor;

    public Course() {
    }
    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public List<Student> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Student> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return creditScore == course.creditScore && Objects.equals(courseName, course.courseName) && Objects.equals(courseCode, course.courseCode) && Objects.equals(courseList, course.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, creditScore, courseList);
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseName='" + courseName + '\'' +
                ", courseCode='" + courseCode + '\'' +
                ", creditScore=" + creditScore +
                ", courseList=" + courseList +
                '}';
    }
}
