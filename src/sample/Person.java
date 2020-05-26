package sample;

import java.io.Serializable;

abstract public class Person implements Serializable {
    private String Name;
    private int ID;
    private String Gender;
    private int Age;

    Person(){}

    Person(String Name,int ID,String Gender,int Age){
        this.Name = Name;
        this.ID = ID;
        this.Gender = Gender;
        this.Age =Age; }

        abstract public void Courses_Assigned();


    public String getGender() {
        return Gender;
    }

    public String getName() {
        return Name;
    }

    public int getID() {
        return ID;
    }
    public int getAge() {
        return Age;
    }
}
