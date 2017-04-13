package ua.kiev.prog.week3.domain;

public class Company {

    private String name;
    private long totalRevenue;

    public Company(String name, long totalRevenue) {
        this.name = name;
        this.totalRevenue = totalRevenue;
    }

    public long getTotalRevenue() {
        return totalRevenue;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", totalRevenue=" + totalRevenue +
                '}';
    }
}
