import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student {
    private String name;
    private LocalDate birthDate;
    private String address;
    private String gender;
    private List<Course> courseList = new ArrayList<Course>();


    public Student() {
    }
    public Student(String name, LocalDate birthDate, String address, String gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.address = address;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(birthDate, student.birthDate) && Objects.equals(address, student.address) && Objects.equals(gender, student.gender) && Objects.equals(courseList, student.courseList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, address, gender, courseList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
