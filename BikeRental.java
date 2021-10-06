import java.util.ArrayList;
import java.util.HashMap;

/**
 * Bike Rental System
 */
public class BikeRental {

    public HashMap<String, CustomerRecord> customerRecords;
    public HashMap<String, RoadBike> roadBikes;
    public HashMap<String, ElectricBike> electricBikes;
    public int remainedRoadBikes;
    public int remainedElectricBikes;
    public HashMap<CustomerRecord, Bike> bikeRent;

    public BikeRental(HashMap customerRecords) {
        this.roadBikes = new HashMap<>();
        this.electricBikes = new HashMap<>();
        this.bikeRent = new HashMap<>();
        for (int i = 0; i<50; i++) {
            RoadBike bike = BikeFactory.createRoadBike();
            this.roadBikes.put(bike.getId(), bike);
        }
        for (int i = 0; i<10; i++) {
            ElectricBike bike = BikeFactory.createElectricBike();
            this.electricBikes.put(bike.getId(), bike);
        }
        this.remainedElectricBikes = 10;
        this.remainedRoadBikes = 50;
        this.customerRecords = customerRecords;
    }

    public int availableBikes(BikeType bikeType) {
        int avaliable = 0;
        if (bikeType.equals(BikeType.ROADBIKE)) {
            for (RoadBike bike : roadBikes.values())
                if (!bike.isRent())
                    avaliable++;
        }
        else if (bikeType.equals(BikeType.ELECTRICBIKE)){
            for (ElectricBike bike : electricBikes.values())
                if (!bike.isRent())
                    avaliable++;
        }
        return avaliable;
    }

    public ArrayList<Bike> getRentedBikes() {
        ArrayList<Bike> bikes = new ArrayList<>();
        for (RoadBike bike : roadBikes.values()) {
            if (bike.isRent())
                bikes.add(bike);
        }
        for (ElectricBike bike : electricBikes.values()) {
            if (bike.isRent())
                bikes.add(bike);
        }
        return bikes;
    }

    public Bike getBike(CustomerRecord customerRecord) {
        if (bikeRent.containsKey(customerRecord)) {
            return bikeRent.get(customerRecord);
        }
        return null;
    }

    public boolean issueBike(CustomerRecord customerRecord, BikeType bikeType) {
        if (bikeRent.containsKey(customerRecord))
            return false;
        if (!customerRecords.containsKey(customerRecord.getId()))
            return false;
        if (bikeType.equals(BikeType.ELECTRICBIKE) && (!customerRecord.isGoldClass() || customerRecord.getAge() < 21))
            return false;
        if (bikeType.equals(BikeType.ELECTRICBIKE) && this.remainedElectricBikes <= 0)
            return false;
        if (bikeType.equals(BikeType.ROADBIKE) && this.remainedRoadBikes <= 0)
            return false;
        if (bikeType.equals(BikeType.ROADBIKE)) {
            for (RoadBike bike : roadBikes.values()) {
                if (!bike.isRent()) {
                    bikeRent.put(customerRecord, bike);
                    bike.setRent(true);
                    remainedRoadBikes--;
                    break;
                }
            }
        }
        else if (bikeType.equals(BikeType.ELECTRICBIKE)) {
            for (ElectricBike bike : electricBikes.values()) {
                if (!bike.isRent()) {
                    bikeRent.put(customerRecord, bike);
                    bike.setRent(true);
                    remainedElectricBikes--;
                    break;
                }
            }
        }
        return true;
    }

    public boolean terminateRental(CustomerRecord customerRecord) {
        if (bikeRent.containsKey(customerRecord)) {
            Bike bike = bikeRent.get(customerRecord);
            bikeRent.remove(customerRecord);
            if (bike instanceof RoadBike) {
                remainedRoadBikes++;
            }
            else if (bike instanceof ElectricBike) {
                remainedElectricBikes++;
                ((ElectricBike) bike).recharge();
            }
            bike.setRent(false);
            return true;
        }
        return false;
    }


}
