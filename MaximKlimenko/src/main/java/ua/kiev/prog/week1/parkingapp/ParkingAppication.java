package ua.kiev.prog.week1.parkingapp;

/**
 * Created by Maxim Klimenko on 27.03.2017.
 */
public class ParkingAppication {
    public static void main(String[] args) {
        MotorCycle cycle1 = new MotorCycle("4422", "bugatti", "Peter Blood1");
        MotorCycle cycle2 = new MotorCycle("4422", "bugatti", "Peter Blood2");
        MotorCycle cycle3 = new MotorCycle("4422", "bugatti", "Peter Blood3");

        Parking parking = new Parking(10);
//        parking.status();
        parking.open();
//        parking.status();
        parking.addVehicleAtFreePlace(cycle1);
        parking.addVehicleAtFreePlace(cycle2);
        parking.addVehicleAtFreePlace(cycle3);
//        parking.addVehicleAtFreePlace(cycle1);
//        parking.addVehicleAtFreePlace(cycle1);

//        parking.showVehicleByPlace();
//        parking.showParking();
//        parking.removeVehicleFromLastPlace();
//        System.out.println("");
//        parking.showParking();

//        parking.addVehicleByPlace(cycle2,9);
//        parking.showVehicleByPlace(9);
//        parking.removeVehicleByPlace(9);
//        parking.removeVehicleByPlace(9);

//        parking.takeLastVehicle();
//        parking.changeAddress(1,2);
//        parking.showParking();
        parking.close();
        parking.clearParking();
        System.out.println("");
        parking.showParking();

    }


}
