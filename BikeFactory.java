/**
 * BikeFactory that produce road bike and electric bike
 */
public class BikeFactory {
    public static RoadBike createRoadBike() {
        return new RoadBike();
    }
    public static ElectricBike createElectricBike(){
        return new ElectricBike();
    }
}
