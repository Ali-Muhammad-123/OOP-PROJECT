package Classes;

public class Student extends Person {

    private String Semester;
    private String programme;
    Courses[] Courses = new Courses[5];

    public Student(String Name, String Gender, String Semester, String programme){
        super(Name,Gender);
        this.programme = programme;
        this.Semester = Semester;
    }

    public void Assign_Courses(Courses[] course) throws IllegalArgumentException{
        this.Courses = course;
        if (Count_Courses() > 5){
            this.Courses = null;
        throw new IllegalArgumentException("The max number of courses allowed for students is 5");
        }
        else {
            this.Courses = course;
        }
    }

    public int Count_Courses() {
        int out=0;
        for (int i=0 ; i<Courses.length ; i++){
            if (Courses[i] != null){
                out++;
            }
        }
        return out;
    }

    public Courses[] getCourses() { return Courses; }

    public String getProgramme() {
        return programme;
    }



    public String getSemester() {
        return Semester;
    }
}
