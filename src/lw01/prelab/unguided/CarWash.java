package lw01.prelab.unguided;

public class CarWash extends WashService {
    public CarWash(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        int days = getDays();
        int baseCharge = (days <= 3) ? (days * 35000) : (3 * 35000) + (days - 3) * 25000;
        return baseCharge + 15000;
    }

    @Override
    public String label() { 
        return "Car";
    }
    
}
