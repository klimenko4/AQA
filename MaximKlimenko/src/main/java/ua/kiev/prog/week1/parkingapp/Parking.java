package ua.kiev.prog.week1.parkingapp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Parking {
    private Vehicle[] localParking = new Vehicle[10];

    private boolean parkingStatus = false;

    public void open() {
        this.parkingStatus = true;
    }

    public void close() {
        this.parkingStatus = false;
    }

    public boolean isOpen() {
        return parkingStatus;
    }

    public void status() {
        if (isOpen()) {
            System.out.println("We are opened");
        } else {
            System.out.println("We are closed");
        }
    }

    public boolean addVehicleAtFreePlace(Vehicle vehicle) {
        if (isOpen()) {
            if (Objects.nonNull(vehicle)) {
                for (int i = 0; i < localParking.length; i++) {
                    if (Objects.isNull(localParking[i])) {
                        localParking[i] = vehicle;
                        return true;
                    }
                }
                System.out.println("parking is full");
                return false;
            }
        }
        System.out.println("Can`t place vehicle to parking, parking is closed.");
        return false;
    }

    public boolean addVehicleByPlace(Vehicle vehicle, int i) {
        if (isOpen() && Objects.isNull(localParking[i]) && i < localParking.length) {
            localParking[i] = vehicle;
        } else {
            if (isOpen() == false) {
                status();
            } else {
                System.out.println("Parking place is already taken");
            }
        }
        return false;
    }

    public void showVehicleByPlace(int i) {
        if (i > 0 && i < localParking.length) {
            System.out.println(localParking[i]);
        } else {
            System.out.println("No such place in parking");
        }
    }

    public void showParking() {
        System.out.println(Arrays.toString(localParking));
    }

    public boolean removeVehicleFromLastPlace() {
        if (isOpen()) {
            for (int i = localParking.length; i > 0; i--) {
                if (Objects.nonNull(localParking[i])) {
                    localParking[i] = null;
                    return true;
                }
            }
        } else {
            status();

        }
        return false;
    }

    public boolean removeVehicleByPlace(int i) {
        if (isOpen() && Objects.nonNull(localParking[i])) {
            localParking[i] = null;
            return true;
        } else {
            if (!isOpen()) {
                status();
            } else {
                System.out.println("No vehicle at parking place");
            }
        }
        return false;

    }

    public void changeAddress(int oldPlace, int newPlace) {
        if (isOpen()) {
            if (oldPlace < localParking.length && oldPlace >= 0 && newPlace < localParking.length && newPlace >= 0) {
                if (Objects.nonNull(localParking[oldPlace]) && Objects.isNull(localParking[newPlace])) {
                    localParking[newPlace] = localParking[oldPlace];
                    localParking[oldPlace] = null;
                } else {
                    System.out.println("Old place is empty or new place is taken");
                }
            } else {
                System.out.println("Address should be more or equal 0 and less than " + localParking.length);
            }
        } else {
            status();
        }
    }


    public void clearParking() {
        if (isOpen()) {
            for (int i = 0; i < localParking.length; i++) {
                localParking[i] = null;
            }
        } else {
            status();
        }
    }
}
