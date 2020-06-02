package Classes;

public class Fees implements Finance {
    Student student1;
    private float Gross_amount;
    private float Net_amount;

    public Fees(Student student1){
        this.student1 = student1;
    }

    public float getGross_amount() {
        Gross_amount = (student1.Count_Courses() * fee_per_course);
        return Gross_amount;
    }


    public float getNet_amount() {
        Net_amount =  getGross_amount() - (getGross_amount() * income_tax/100);
        return Net_amount;
    }
}
