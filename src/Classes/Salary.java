package Classes;

public class Salary implements Finance {
    Teacher teacher;
    private float Gross_amount;
    private float Net_amount;

    public Salary(Teacher teacher){
        this.teacher = teacher;
    }

    public float getGross_amount() {
        Gross_amount = (teacher.Count_Courses() * fee_per_course) * (100 - University_percentage)/100;
        return Gross_amount;
    }


    public float getNet_amount() {
        Net_amount =  getGross_amount() - (getGross_amount() * income_tax/100);
        return Net_amount;
    }
}
