package sample;

public class Teacher {
    String Name;
    int Age;
    String Qualification;
    boolean permanent;

    Teacher(){}

    Teacher(String Name,int Age,String Qualification,boolean permanent)
    {
        this.Name = Name;
        this.Age = Age;
        this.Qualification = Qualification;
        this.permanent =  permanent;
    }

    public String getName() {
        return Name;
    }

    public int getAge() {
        return Age;
    }

    public String getQualification() {
        return Qualification;
    }

}
