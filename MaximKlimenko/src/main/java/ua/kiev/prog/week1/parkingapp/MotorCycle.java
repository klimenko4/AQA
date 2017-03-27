package ua.kiev.prog.week1.parkingapp;

/**
 * Created by Maxim Klimenko on 27.03.2017.
 */
public class MotorCycle {

    private String plateNumber;
    private String model;
    private String ownerName;
    public MotorCycle(String plateNumber,String model,String ownerName) {
        this.plateNumber = plateNumber;
        this.model = model;
        this.ownerName = ownerName;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getModel() {return model; }

    public String getOwnerName() {
        return ownerName;
    }
}
