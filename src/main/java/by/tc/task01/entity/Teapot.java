package by.tc.task01.entity;

public class Teapot extends Appliance{
    private int powerConsumption;
    private double frequencyRangeMin;
    private double frequencyRangeMax;
    private double volume;
    private String color;

    public Teapot(String name, double price, int powerConsumption, double frequencyMin, double frequencyMax, double volume, String color) {
        super(name, price);
        this.powerConsumption = powerConsumption;
        this.frequencyRangeMin = frequencyMin;
        this.frequencyRangeMax = frequencyMax;
        this.volume = volume;
        this.color = color;
    }

    public int getPowerConsumption() {
        return powerConsumption;
    }

    public void setPowerConsumption(int powerConsumption) {
        this.powerConsumption = powerConsumption;
    }

    public double getFrequencyRangeMin() {
        return frequencyRangeMin;
    }

    public void setFrequencyRangeMin(double frequencyRangeMin) {
        this.frequencyRangeMin = frequencyRangeMin;
    }

    public double getFrequencyRangeMax() {
        return frequencyRangeMax;
    }

    public void setFrequencyRangeMax(double frequencyRangeMax) {
        this.frequencyRangeMax = frequencyRangeMax;
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
                ", waterCapacity=" + volume +
                ", color=" + color + '\'' +
                '}';
    }
}
