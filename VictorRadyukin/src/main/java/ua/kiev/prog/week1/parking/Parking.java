package ua.kiev.prog.week1.parking;

import java.util.Objects;
import java.util.Optional;

/**
 * Created by Zver on 24.03.2017.
 */
public class Parking {
    private boolean isOpen;
    private int numOfPlaces;
    private Vehicle[] parkingSpaces;

    public Parking(int numOfPlaces, boolean isOpen) {


        this.isOpen = isOpen;
        this.numOfPlaces = numOfPlaces;
        this.parkingSpaces = new Vehicle[numOfPlaces];
    }

    public Parking(int numOfPlaces) {
        // default value for boolean type is false
        // this.isOpen = false;
        //this.numOfPlaces = numOfPlaces;
        //this.parkingSpaces = new Vehicle[numOfPlaces];

        // you could reuse existing constructor and create an open parking
        new Parking(numOfPlaces, true);

    }

//    public boolean open() {
//        if (this.isOpen == false) {
//            this.isOpen = true;
//        }
//        return this.isOpen;
//    }

    // it'd do it returns "void" since there is no case it can not be open
    // the code can be simplified to the following
    public void open() {
        if (!this.isOpen) this.isOpen = true;
    }


//    public boolean close() {
//        if (this.isOpen == true) {
//            this.isOpen = false;
//        }
//        return this.isOpen;
//    }

    public void close() {
        if (this.isOpen) this.isOpen = false;
    }


//    public void showAllVehicles() {
//        String allVehicles = "";
//        for (int i = 0; i < this.numOfPlaces; i++) {
//            if (parkingSpaces[i] != null) {
//                allVehicles += parkingSpaces[i] + ";";
//            }
//        }
//        if (!allVehicles.equals("")) {
//            System.out.println(allVehicles);
//        } else {
//            System.out.println("All parking spaces are empty");
//        }
//    }

    // better to name it "printAllVehicles"
    public void showAllVehicles() {
        for (Vehicle vehicle : parkingSpaces) {
            if (Objects.nonNull(vehicle)) System.out.println(vehicle);
        }
    }

    public void clearAllParkingSpaces() {
        this.parkingSpaces = new Vehicle[numOfPlaces];
    }

//    public void getMotobikeBySpaceNum(int num) {
//        if (this.parkingSpaces[num] instanceof Motorbike)
//            System.out.println(this.parkingSpaces[num]);
//     /*
//     } else {
//     return null;
//     }
//     */
//    }

    // it'd be logical if getVehicle method returned rather Vehicle than void
    public Vehicle getVehicleBySpaceNum(int num) {

        if (num < 0 || num >= numOfPlaces)
            throw new IllegalArgumentException("no parking place with the given number exists ");

        Vehicle result = parkingSpaces[num];
        if (result != null) return result;
        return null;
    }

    // another way to use Optional from java 8 . see java Optional
    public Optional<Vehicle> getVehicleBySpaceNumwithOptional(int num) {

        if (num < 0 || num > parkingSpaces.length)
            throw new IllegalArgumentException("no parking with the given number exists ");

        return Optional.ofNullable(parkingSpaces[num]);

    }

//
//    public int addMotorbikeBySpaceNum(int num, Motorbike motorbike) {
//        if (this.parkingSpaces[num] == null) {
//            this.parkingSpaces[num] = motorbike;
//            return num;
//        } else {
//            return (-1);
//        }
//    }

    //
    public boolean addVehicleBySpaceNum(int num, Vehicle vehicle) {

        //check num
        //check vehicle
        Objects.requireNonNull(vehicle);

        if (parkingSpaces[num] == null) {
            parkingSpaces[num] = vehicle;
            return true;
        }
        return false;
    }
}
