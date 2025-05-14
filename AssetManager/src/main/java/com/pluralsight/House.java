package com.pluralsight;

// The House class extends (inherits from) the Asset class
// This means it will automatically have all properties and methods of Asset
public class House extends Asset {
    // Properties specific to a House

    // The address where the house is located
    private String address;

    // The condition of the house:
    // 1 = Excellent, 2 = Good, 3 = Fair, 4 = Poor
    private int condition;

    // The size of the house in square feet
    private int squareFoot;

    // The size of the lot the house sits on, in square feet
    private int lotSize;

    // Constructor - used to create a new House object
    // It takes in both the parent (Asset) properties and the House-specific ones
    public House(String description, String dateAcquired, double originalCost,
                 String address, int condition, int squareFoot, int lotSize) {

        // Call the constructor from the Asset class using the 'super' keyword
        // This sets up the inherited fields
        super(description, dateAcquired, originalCost);

        // Set the fields specific to House
        this.address = address;
        this.condition = condition;
        this.squareFoot = squareFoot;
        this.lotSize = lotSize;
    }

    // Getters - methods used to access the private fields

    public String getAddress() {
        return address;
    }

    public int getCondition() {
        return condition;
    }

    public int getSquareFoot() {
        return squareFoot;
    }

    public int getLotSize() {
        return lotSize;
    }

    // Setters - methods used to change the values of private fields

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCondition(int condition) {
        this.condition = condition;
    }

    public void setSquareFoot(int squareFoot) {
        this.squareFoot = squareFoot;
    }

    public void setLotSize(int lotSize) {
        this.lotSize = lotSize;
    }

    // Override the getValue method from the Asset class
    // This version calculates the value based on house-specific criteria
    @Override
    public double getValue() {
        double pricePerSquareFoot;

        // Determine the base price per square foot based on condition
        if (condition == 1) {
            pricePerSquareFoot = 180.00; // Excellent
        } else if (condition == 2) {
            pricePerSquareFoot = 130.00; // Good
        } else if (condition == 3) {
            pricePerSquareFoot = 90.00;  // Fair
        } else {
            pricePerSquareFoot = 80.00;  // Poor
        }

        // Calculate base value from square footage
        double baseValue = this.squareFoot * pricePerSquareFoot;

        // Add bonus value based on the size of the lot
        double lotValue = this.lotSize * 0.25;

        // Return the total estimated value of the house
        return baseValue + lotValue;
    }
}
