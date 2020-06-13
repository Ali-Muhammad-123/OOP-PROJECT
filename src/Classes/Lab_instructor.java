package Classes;

public class Lab_instructor extends Teacher {


    public Lab_instructor(String Name, String Gender, String Qualification) {
        super(Name, Gender, Qualification);
    }

    @Override
    public void Assign_Courses(Classes.Courses[] course) throws IllegalArgumentException {
        if (Count_Courses() > 1){
            this.Courses = null;
            throw new IllegalArgumentException("The max number of courses allowed for lab instructors is 1"); }
        else {
            this.Courses = course;
        }
    }
}
