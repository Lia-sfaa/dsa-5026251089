package lw01.prelab.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int units = getUnits();
        int baseCharge;
         
        if (days <= 3) {
            baseCharge = days * 35000;
        } else {
            baseCharge = (3 * 35000) + ((days - 3) * 25000);
        }
        return (baseCharge + 15000) * getUnits();
    }

    @Override
    public String label() { 
        return "Car";
    }
    
}
