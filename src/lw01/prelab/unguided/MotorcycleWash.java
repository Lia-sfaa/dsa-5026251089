package lw01.prelab.unguided;

public class MotorcycleWash extends WashService {
    public MotorcycleWash(String id, int days, int units) {
        super(id, days, units);
    }

    @Override
    public int calculateCharge() {
        return ((15000 * getDays())+ 5000) * getUnits();
    }

    @Override
    public String label() { 
        return "Motorcycle";
    }
}
