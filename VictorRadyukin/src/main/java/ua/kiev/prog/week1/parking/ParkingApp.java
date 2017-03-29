package ua.kiev.prog.week1.parking;

/**
 * Created by Zver on 24.03.2017.
 */
public class ParkingApp {

    public static void main(String[] args) {

        Parking parking = new Parking(4);

        Vehicle car = new Car("x5", "667");
        Vehicle bike = new Motorbike("honda", "643");

        parking.addVehicleBySpaceNum(1,car);
        parking.addVehicleBySpaceNum(3,bike);


        parking.showAllVehicles();
        parking.getVehicleBySpaceNum(4);

    }
}

