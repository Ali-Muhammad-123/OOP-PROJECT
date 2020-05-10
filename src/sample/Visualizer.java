package sample;

public class Visualizer {
    private int Cases_in_Sindh =61;
    private int Cases_in_KPK = 49;
    private int Cases_in_Punjab = 94;
    private int Cases_in_Kashmir = 55;
    private int Cases_in_Balochistan = 74;

    Visualizer(int Cases_in_Sindh , int Cases_in_KPK , int Cases_in_Punjab , int Cases_in_Kashmir , int Cases_in_Balochistan)
    {
        this.Cases_in_Balochistan=Cases_in_Balochistan;
        this.Cases_in_Kashmir = Cases_in_Kashmir;
        this.Cases_in_KPK=Cases_in_KPK;
        this.Cases_in_Punjab=Cases_in_Punjab;
        this.Cases_in_Sindh = Cases_in_Sindh;
    }

    public int getCases_in_Balochistan() {
        return Cases_in_Balochistan;
    }

    public int getCases_in_Kashmir() {
        return Cases_in_Kashmir;
    }

    public int getCases_in_KPK() {
        return Cases_in_KPK;
    }

    public int getCases_in_Punjab() {
        return Cases_in_Punjab;
    }

    public int getCases_in_Sindh() {
        return Cases_in_Sindh;
    }

    public void setCases_in_Balochistan(int cases_in_Balochistan) {
        Cases_in_Balochistan = cases_in_Balochistan;
    }

    public void setCases_in_Kashmir(int cases_in_Kashmir) {
        Cases_in_Kashmir = cases_in_Kashmir;
    }

    public void setCases_in_KPK(int cases_in_KPK) {
        Cases_in_KPK = cases_in_KPK;
    }

    public void setCases_in_Punjab(int cases_in_Punjab) {
        Cases_in_Punjab = cases_in_Punjab;
    }

    public void setCases_in_Sindh(int cases_in_Sindh) {
        Cases_in_Sindh = cases_in_Sindh;
    }
}
