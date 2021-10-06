public class RoadBike extends Bike{
    @Override
    public String toString() {
        return "RoadBike{" +
                "id='" + getId() + '\'' +
                ", rent=" + isRent() +
                '}';
    }
}
