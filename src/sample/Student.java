package sample;

import java.io.Serializable;

public class Student implements Serializable{
    private String Name;
    private int Student_ID;
    private String Semester;
    private String Gender;
    private String programme;
    Courses Course1,Course2,Course3,Course4,Course5,Course6,Course7;

    Student(String Name,int Student_ID,String Gender ,String Semester , String programme){
        this.Student_ID = Student_ID;
        this.Name = Name;
        this.Gender=Gender;
        this.programme = programme;
        this.Semester = Semester;
    }

    public void setCourse1(Courses course1) {
        Course1 = course1;
    }

    public void setCourse2(Courses course2) {
        Course2 = course2;
    }

    public void setCourse3(Courses course3) {
        Course3 = course3;
    }

    public void setCourse4(Courses course4) {
        Course4 = course4;
    }

    public void setCourse5(Courses course5) {
        Course5 = course5;
    }

    public void setCourse6(Courses course6) {
        Course6 = course6;
    }

    public Courses getCourse1() {
        return Course1;
    }

    public Courses getCourse2() {
        return Course2;
    }

    public Courses getCourse3() {
        return Course3;
    }

    public Courses getCourse4() {
        return Course4;
    }

    public Courses getCourse5() {
        return Course5;
    }

    public Courses getCourse6() {
        return Course6;
    }

    public Courses getCourse7() {
        return Course7;
    }

    public void setCourse7(Courses course7) {
        Course7 = course7;
    }

    public String getGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public int getStudent_ID() {
        return Student_ID;
    }

    public String getProgramme() {
        return programme;
    }

    public String getSemester() {
        return Semester;
    }
}
