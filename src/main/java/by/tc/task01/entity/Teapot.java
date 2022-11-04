package by.tc.task01.entity;

public class Teapot extends Appliance{
    private int powerConsumption;
    private double volume;
    private String color;

    public Teapot() {}

    public Teapot(String name, double price, int powerConsumption, double volume, String color) {
        super(name, price);
        this.powerConsumption = powerConsumption;
        this.volume = volume;
        this.color = color;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Teapot{" +
                "price=" + price +
                ", name='" + name + '\'' +
                ", powerConsumption=" + powerConsumption +
                ", volume=" + volume +
                ", color='" + color + '\'' +
                '}';
    }
}
