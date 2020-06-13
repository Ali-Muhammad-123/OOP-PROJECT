package Classes;

public class Salary implements Finance {

    private float Gross_amount;
    private float Net_amount;


    public float getGross_amount() {
        return 0;
    }

    public float getGross_amount(Teacher teacher) {
        Gross_amount = (teacher.Count_Courses() * fee_per_course) * (100 - University_percentage)/100;
        return Gross_amount;
    }

    public float getGross_amount(Lab_instructor lab_instructor) {
        Gross_amount = (lab_instructor.Count_Courses() * fee_per_course) * (100 - University_percentage)/100;
        return Gross_amount;
    }


    public float getNet_amount() {
        return 0;
    }

    public float getNet_amount(Teacher teacher) {
        Net_amount =  getGross_amount(teacher) - (getGross_amount() * income_tax/100);
        return Net_amount;
    }


    public float getNet_amount(Lab_instructor lab_instructor) {
        Net_amount =  getGross_amount(lab_instructor) - (getGross_amount() * income_tax/100);
        return Net_amount;
    }

}
