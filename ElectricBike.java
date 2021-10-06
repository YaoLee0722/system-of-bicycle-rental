public class ElectricBike extends Bike{

    private boolean fullBattery;

    public ElectricBike() {
        super();
        this.fullBattery = true;
    }

    public ElectricBike(String id, boolean rent, boolean fullBattery) {
        super(id, rent);
        this.fullBattery = fullBattery;
    }

    public boolean isFullBattery() {
        return fullBattery;
    }

    public void setFullBattery(boolean fullBattery) {
        this.fullBattery = fullBattery;
    }

    public void recharge() {
        setFullBattery(true);
    }

    @Override
    public String toString() {
        return "ElectricBike{" +
                "id='" + getId() + '\'' +
                ", rent=" + isRent() +
                ", fullBattery=" + fullBattery +
                '}';
    }
}
