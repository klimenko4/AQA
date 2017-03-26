package ua.kiev.prog.week1.parking;

/**
 * Created by Zver on 24.03.2017.
 */

/**
 * class Vehicle isn't abstract because there are no common methods with different implementations for Car, Motorbike.
 * classes Car, Motorbike just hold data: model, plateNum
 */

// should be abstract since creating an instance of Vehicle type makes no sense

public abstract class Vehicle {
    protected String model;
    protected String plateNum;

    public Vehicle(String model, String plateNum) {
        this.model = model;
        this.plateNum = plateNum;
    }

    public String getModel() {
        return model;
    }

    public String getPlateNum() {
        return plateNum;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "model='" + model + '\'' +
                ", plateNum='" + plateNum + '\'' +
                '}';
    }
}
