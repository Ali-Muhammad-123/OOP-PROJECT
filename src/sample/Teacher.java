package sample;

abstract public class Teacher {
    String Name;
    int Age;
    String Qualification;

    boolean Lab_instructor;

    Teacher(){}


    Teacher(String Name,int Age,String Qualification)
    {
        this.Name = Name;
        this.Age = Age;
        this.Qualification = Qualification;

    }

    abstract void Lab_instructor();

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
