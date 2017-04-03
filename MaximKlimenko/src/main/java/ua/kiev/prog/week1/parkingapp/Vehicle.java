package ua.kiev.prog.week1.parkingapp;

public abstract class Vehicle {
    private String plateNumber;
    private String model;
    private String ownerName;


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

    public String getModel() {
        return model;
    }

    public String getOwnerName() {
        return ownerName;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Vehicle{");
        sb.append("plateNumber='").append(plateNumber).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", ownerName='").append(ownerName).append('\'');
        sb.append('}').append(System.lineSeparator());
        return sb.toString();
    }

}
