package by.tc.task01.entity;

/**
 * Appliance common class
 */
public class Appliance {
    protected double price;
    protected String name;

    public Appliance() {
    }

    public Appliance(String name, double price) {
        this.price = price;
        this.name = name;
    }

    /**
     * @return price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price - new appliance price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name - new appliance name
     */
    public void setName(String name) {
        this.name = name;
    }
}
