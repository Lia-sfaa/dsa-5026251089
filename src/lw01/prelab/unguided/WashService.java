package lw01.prelab.unguided;

public abstract class WashService implements Billable {
    private String id;
    private int days;
    private int units;
    
    protected WashService(String id, int days, int units) {
        if (days <= 0) {
            throw new IllegalArgumentException("Days cannot be zero or negative");
        }
        this.id = id;
        this.days = days;
        this.units = units;
    }

    public String getId() {
        return id;
    }

    public int getDays() {
        return days;
    }

    public abstract int calculateCharge();

    public int calculateCharge(int units) {
        if (units <= 0) {
            throw new IllegalArgumentException("Items cannot be zero or negative");
        }
        return units * calculateCharge();
    }

    public String label() {
        return "Service";
    }

    public String summary() {
        return id + " | " + label() + " | " + calculateCharge();
    }
}
