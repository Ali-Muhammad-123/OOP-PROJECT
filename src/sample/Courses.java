package sample;

import java.io.Serializable;

public class Courses extends Teacher implements Serializable {
    String Course_ID;
    String Course_Name;
    int Credit_Hours;

    Courses(){}
    Courses(String Course_ID,String Course_Name, int Credit_Hours, String Name,int Age,String Qualification) {
        super(Name,Age, Qualification);
        this.Course_ID = Course_ID;
        this.Course_Name=Course_Name;
        this.Credit_Hours=Credit_Hours;
    }


    void Lab_instructor() {
        if(Course_Name.contains("LAB")){
            super.Lab_instructor=true;
        }
        else {
            super.Lab_instructor=false;
        }
    }

    public String getCourse_ID() {
        return Course_ID;
    }

    public int getCredit_Hours() {
        return Credit_Hours;
    }

    public String getCourse_Name() {

        return Course_Name;
    }
}

