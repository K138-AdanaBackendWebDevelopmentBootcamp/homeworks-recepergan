import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Instructor {
    private String name;
    private String address;
    private String phoneNumber;
    private List<Course> studentList = new ArrayList<>();

    public Instructor() {
    }

    public Instructor(String name, String address, String phoneNumber, List<Course> studentList) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.studentList = studentList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Course> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Course> studentList) {
        this.studentList = studentList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructor that = (Instructor) o;
        return Objects.equals(name, that.name) && Objects.equals(address, that.address) && Objects.equals(phoneNumber, that.phoneNumber) && Objects.equals(studentList, that.studentList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, address, phoneNumber, studentList);
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", courseList=" + studentList +
                '}';
    }
}
