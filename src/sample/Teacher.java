package sample;

public class Teacher extends Person {

    String Qualification;

    Courses[] courses = new Courses[3];
    boolean Lab_instructor;

    Teacher(){}
    Teacher(String Name,int ID,String Gender ,int Age ,String Qualification)
    {
        super(Name,ID,Gender,Age);
        this.Qualification = Qualification;
    }

    @Override
    public void Courses_Assigned() {

    }


    public String getQualification() {
        return Qualification;
    }

}
