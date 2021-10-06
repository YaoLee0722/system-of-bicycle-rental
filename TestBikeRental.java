import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

public class TestBikeRental {
    public static BikeRental initBikeRental() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1995);
        birthday.set(Calendar.MONDAY, 11);
        birthday.set(Calendar.DATE, 1);
        Calendar issueDate = Calendar.getInstance();
        issueDate.set(Calendar.YEAR, 2018);
        issueDate.set(Calendar.MONDAY, 11);
        issueDate.set(Calendar.DATE, 1);
        CustomerRecord c1 =
                new CustomerRecord("James", "Bond", birthday.getTime(), issueDate.getTime(), false);
        CustomerRecord c2 =
                new CustomerRecord("Tony", "Davis", birthday.getTime(), issueDate.getTime(), true);
        CustomerRecord c3 =
                new CustomerRecord("Mary", "Evans", birthday.getTime(), issueDate.getTime(), true);
        HashMap<String, CustomerRecord> map = new HashMap<>();
        map.put(c1.getId(), c1);
        map.put(c2.getId(), c2);
        map.put(c3.getId(), c3);
        return new BikeRental(map);
    }

    public static void testRoadBike() {
        RoadBike bike = new RoadBike();
        assert bike.toString().equals("RoadBike{id='ab101', rent=false}");
    }

    public static void testElectricBike(){
        ElectricBike bike = new ElectricBike();
        assert bike.toString().equals("ElectricBike{id='ab101', rent=false, fullBattery=true}");
    }

    public static void testCustomerRecord(){
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1999);
        birthday.set(Calendar.MONDAY, 11);
        birthday.set(Calendar.DATE, 1);
        CustomerRecord customerRecord =
                new CustomerRecord("James", "Bond", birthday.getTime(), new Date(2018, 1, 1), false);
        assert customerRecord.getId().equals("JB-1999-00");
    }


    public static void testAvaliableBikes() {
        BikeRental bikeRental = initBikeRental();
        assert bikeRental.availableBikes(BikeType.ROADBIKE) == 50;
        assert bikeRental.availableBikes(BikeType.ELECTRICBIKE) == 10;
    }

    public static void testIssueBike() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1995);
        birthday.set(Calendar.MONDAY, 11);
        birthday.set(Calendar.DATE, 1);
        Calendar issueDate = Calendar.getInstance();
        issueDate.set(Calendar.YEAR, 2018);
        issueDate.set(Calendar.MONDAY, 11);
        issueDate.set(Calendar.DATE, 1);
        CustomerRecord c1 =
                new CustomerRecord("James", "Bond", birthday.getTime(), issueDate.getTime(), false);
        CustomerRecord c2 =
                new CustomerRecord("Tony", "Davis", birthday.getTime(), issueDate.getTime(), true);
        CustomerRecord c3 =
                new CustomerRecord("Mary", "Evans", birthday.getTime(), issueDate.getTime(), true);
        HashMap<String, CustomerRecord> map = new HashMap<>();
        map.put(c1.getId(), c1);
        map.put(c2.getId(), c2);
        map.put(c3.getId(), c3);
        BikeRental bikeRental = new BikeRental(map);
        assert bikeRental.issueBike(c1, BikeType.ELECTRICBIKE) == false;
        assert bikeRental.issueBike(c2, BikeType.ELECTRICBIKE) == true;
        assert bikeRental.issueBike(c3, BikeType.ELECTRICBIKE) == true;
        assert bikeRental.getRentedBikes().toString().equals("[ElectricBike{id='ab159', rent=true, fullBattery=true}, ElectricBike{id='ab155', rent=true, fullBattery=true}]");
    }


    public static void testTerminateRental() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1995);
        birthday.set(Calendar.MONDAY, 11);
        birthday.set(Calendar.DATE, 1);
        Calendar issueDate = Calendar.getInstance();
        issueDate.set(Calendar.YEAR, 2018);
        issueDate.set(Calendar.MONDAY, 11);
        issueDate.set(Calendar.DATE, 1);
        CustomerRecord c1 =
                new CustomerRecord("James", "Bond", birthday.getTime(), issueDate.getTime(), false);
        CustomerRecord c2 =
                new CustomerRecord("Tony", "Davis", birthday.getTime(), issueDate.getTime(), true);
        CustomerRecord c3 =
                new CustomerRecord("Mary", "Evans", birthday.getTime(), issueDate.getTime(), true);
        HashMap<String, CustomerRecord> map = new HashMap<>();
        map.put(c1.getId(), c1);
        map.put(c2.getId(), c2);
        map.put(c3.getId(), c3);
        BikeRental bikeRental = new BikeRental(map);
        bikeRental.issueBike(c2, BikeType.ELECTRICBIKE);
        bikeRental.issueBike(c3, BikeType.ELECTRICBIKE);
        bikeRental.terminateRental(c2);
        assert bikeRental.getRentedBikes().toString().equals("[ElectricBike{id='ab155', rent=true, fullBattery=true}]");
    }

    public static void testGetRentedBikes() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1995);
        birthday.set(Calendar.MONDAY, 11);
        birthday.set(Calendar.DATE, 1);
        Calendar issueDate = Calendar.getInstance();
        issueDate.set(Calendar.YEAR, 2018);
        issueDate.set(Calendar.MONDAY, 11);
        issueDate.set(Calendar.DATE, 1);
        CustomerRecord c1 =
                new CustomerRecord("James", "Bond", birthday.getTime(), issueDate.getTime(), false);
        CustomerRecord c2 =
                new CustomerRecord("Tony", "Davis", birthday.getTime(), issueDate.getTime(), true);
        CustomerRecord c3 =
                new CustomerRecord("Mary", "Evans", birthday.getTime(), issueDate.getTime(), true);
        HashMap<String, CustomerRecord> map = new HashMap<>();
        map.put(c1.getId(), c1);
        map.put(c2.getId(), c2);
        map.put(c3.getId(), c3);
        BikeRental bikeRental = new BikeRental(map);
        bikeRental.issueBike(c2, BikeType.ELECTRICBIKE);
        bikeRental.issueBike(c3, BikeType.ELECTRICBIKE);
        bikeRental.terminateRental(c2);
        assert bikeRental.getRentedBikes().size() == 1;
    }

    public static void testGetBike() {
        Calendar birthday = Calendar.getInstance();
        birthday.set(Calendar.YEAR, 1995);
        birthday.set(Calendar.MONDAY, 11);
        birthday.set(Calendar.DATE, 1);
        Calendar issueDate = Calendar.getInstance();
        issueDate.set(Calendar.YEAR, 2018);
        issueDate.set(Calendar.MONDAY, 11);
        issueDate.set(Calendar.DATE, 1);
        CustomerRecord c1 =
                new CustomerRecord("James", "Bond", birthday.getTime(), issueDate.getTime(), false);
        CustomerRecord c2 =
                new CustomerRecord("Tony", "Davis", birthday.getTime(), issueDate.getTime(), true);
        CustomerRecord c3 =
                new CustomerRecord("Mary", "Evans", birthday.getTime(), issueDate.getTime(), true);
        HashMap<String, CustomerRecord> map = new HashMap<>();
        map.put(c1.getId(), c1);
        map.put(c2.getId(), c2);
        map.put(c3.getId(), c3);
        BikeRental bikeRental = new BikeRental(map);
        bikeRental.issueBike(c2, BikeType.ELECTRICBIKE);
        bikeRental.issueBike(c3, BikeType.ELECTRICBIKE);
        assert bikeRental.getBike(c2).toString().equals("ElectricBike{id='ab159', rent=true, fullBattery=true}");
    }

    public static void main(String[] args) {
//        testRoadBike();
//        testElectricBike();
//        testCustomerRecord();
//        testAvaliableBikes();
//        testIssueBike();
//        testTerminateRental();
//        testGetRentedBikes();
//        testGetBike();
    }
}
