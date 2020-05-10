package sample;

public class Patient extends Wards{
    private  int  patient_id;
    private String patient_name;
    private int patient_age;
    private String Area;

    Patient(int duration_of_stay, double Charges_per_Hour){
        super(duration_of_stay,Charges_per_Hour);
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_age(int patient_age) {
        this.patient_age = patient_age;
    }

    public int getPatient_age() {
        return patient_age;
    }

    public void setArea(String area) {
        Area = area;
    }

    public String getArea() {
        return Area;
    }
}