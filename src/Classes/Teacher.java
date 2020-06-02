package Classes;

import java.io.Serializable;

public class Teacher extends Person  implements Serializable {

    String Qualification;
    Courses[] Courses = new Courses[3];


    public Teacher(String Name, String Gender, String Qualification)
    {
        super(Name,Gender);
        this.Qualification = Qualification;
    }

    public void Assign_Courses(Courses[] course) throws IllegalArgumentException{
        if (Count_Courses() > 3){
            this.Courses = null;
            throw new IllegalArgumentException("The max number of courses allowed for teachers is 3"); }
        else {
            this.Courses = course;
        }
    }

    public int Count_Courses() {
        int out=0;
        for (int i=0 ; i<3 ; i++){
            if (Courses[i] != null){
                out++;
            }
        }
        return out;
    }

    public Classes.Courses[] getCourses() {
        return Courses;
    }

    public String getQualification() {
        return Qualification;
    }

}
