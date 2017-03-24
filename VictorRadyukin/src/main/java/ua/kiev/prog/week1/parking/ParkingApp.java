package ua.kiev.prog.week1.parking;

/**
 * Created by Zver on 24.03.2017.
 */
public class ParkingApp {
    public static void main(String[] args) {
        Vehicle bmw = new Car("x5", "666");
        System.out.println(bmw.getModel());
        System.out.println(bmw.getPlateNum());
        Parking parking = new Parking(10);
        parking.showAllVehicles();
        parking.addMotorbikeBySpaceNum(3, new Motorbike("honda", "777"));
        parking.getMotobikeBySpaceNum(3);

    }
}

