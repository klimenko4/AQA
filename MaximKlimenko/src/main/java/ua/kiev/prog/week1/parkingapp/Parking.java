package ua.kiev.prog.week1.parkingapp;


import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Parking {
    private List<MotorCycle> localParking = new ArrayList<>();

    private String parkingStatus;

    public void open(){
        this.parkingStatus = "open";
    }
    public void close(){
        this.parkingStatus = "close";
    }
    public boolean isOpen(){
        return parkingStatus.equals("open");
    }
    public void status() {
            if (isOpen()) {
                System.out.println("We are opened");
            }
            else {
                System.out.println("We are closed");
            }
    }
    public boolean addMotoAtFreePlace(MotorCycle motorCycle){
        if (isOpen()) {
            if (Objects.nonNull(motorCycle)) {
                localParking.add(motorCycle);
                return true;
            }
        }
        System.out.println("Can`t place vehicle to parking, parking is closed.");
        return false;
    }
}
