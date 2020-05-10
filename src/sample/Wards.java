package sample;

public class Wards {
    private int no_of_beds;
    String[] Wards = {"General", "Emergecy", "Cardiology", "Corona Ward"};
    private int duration_of_stay;
    private double Charges_per_Hour ;
Wards(){

}
    Wards(int duration_of_stay, double Charges_per_Hour){
        this.duration_of_stay=duration_of_stay;
        this.Charges_per_Hour=Charges_per_Hour;
    }

    public double Calculate_Bill(){
        return duration_of_stay*Charges_per_Hour;
    }

}
