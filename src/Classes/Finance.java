package Classes;

public interface Finance {
    int income_tax = 15;
    float fee_per_course = 18000;
    int University_percentage = 30;

    public float getNet_amount();
    public float getGross_amount();
}
