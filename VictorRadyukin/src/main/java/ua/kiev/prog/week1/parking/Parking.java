package ua.kiev.prog.week1.parking;

/**
 * Created by Zver on 24.03.2017.
 */
public class Parking {
    private boolean isOpen;
    private int numOfPlaces;
    private Vehicle parkingSpaces[];

    public Parking(int numOfPlaces, boolean isOpen) {
        this.isOpen = isOpen;
        this.numOfPlaces = numOfPlaces;
        this.parkingSpaces = new Vehicle[numOfPlaces];
    }

    public Parking(int numOfPlaces) {
        this.isOpen = false;
        this.numOfPlaces = numOfPlaces;
        this.parkingSpaces = new Vehicle[numOfPlaces];
    }

    public boolean open() {
        if (this.isOpen == false) {
            this.isOpen = true;
        }
        return this.isOpen;
    }

    public boolean close() {
        if (this.isOpen == true) {
            this.isOpen = false;
        }
        return this.isOpen;
    }

    public void showAllVehicles() {
        String allVehicles = "";
        for(int i=0; i< this.numOfPlaces; i++) {
            if (parkingSpaces[i] != null) {
                allVehicles += parkingSpaces[i] + ";";
            }
        }
        if (!allVehicles.equals("")) {
            System.out.println(allVehicles);
        } else {
            System.out.println("All parking spaces are empty");
        }
    }

    public void clearAllParkingSpaces() {
        this.parkingSpaces = new Vehicle[numOfPlaces];
    }

    public void getMotobikeBySpaceNum(int num) {
       if (this.parkingSpaces[num] instanceof Motorbike)
        System.out.println(this.parkingSpaces[num]);
     /*
     } else {
     return null;
     }
     */
    }

    public int addMotorbikeBySpaceNum(int num, Motorbike motorbike) {
        if (this.parkingSpaces[num] == null) {
            this.parkingSpaces[num] = motorbike;
            return num;
        } else {
            return (-1);
        }
    }


}
