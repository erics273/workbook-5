package com.pluralsight;

import java.time.LocalDate;

// The Vehicle class represents a car, truck, or other vehicle
// It extends the Asset class, inheriting description, dateAcquired, and originalCost
public class Vehicle extends Asset {
    // Properties specific to a Vehicle

    // The make and model of the vehicle (e.g., "Toyota Camry", "Ford F-150")
    private String makeModel;

    // The year the vehicle was manufactured
    private int year;

    // The number of miles the vehicle has been driven
    private int odometer;

    // Constructor - used to create a new Vehicle object
    public Vehicle(String description, String dateAcquired, double originalCost, String makeModel, int year, int odometer) {

        // Call the parent class (Asset) constructor to set inherited fields
        super(description, dateAcquired, originalCost);

        // Use 'this' to refer to the instance variables of this object
        this.makeModel = makeModel;
        this.year = year;
        this.odometer = odometer;
    }

    // Getters - used to access the private fields
    public String getMakeModel() {
        return this.makeModel;
    }

    public int getYear() {
        return this.year;
    }

    public int getOdometer() {
        return this.odometer;
    }

    // Setters - used to modify the private fields
    public void setMakeModel(String makeModel) {
        this.makeModel = makeModel;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setOdometer(int odometer) {
        this.odometer = odometer;
    }

    // Override the getValue method from Asset
    // This version calculates the vehicle's current value based on its age and mileage
    @Override
    public double getValue() {
        // Get the current year
        int currentYear = LocalDate.now().getYear();

        // Calculate the vehicle's age
        int age = currentYear - this.year;

        // Start with the original cost (inherited from Asset)
        double value = this.getOriginalCost();

        // Apply depreciation based on age
        if (age >= 0 && age <= 3) {
            // Reduce value by 3% per year for 0-3 years
            value -= value * (0.03 * age);
        } else if (age >= 4 && age <= 6) {
            // Reduce value by 6% per year for 4-6 years
            value -= value * (0.06 * age);
        } else if (age >= 7 && age <= 10) {
            // Reduce value by 8% per year for 7-10 years
            value -= value * (0.08 * age);
        } else if (age > 10) {
            // Flat value for vehicles older than 10 years
            value = 1000.00;
        }

        // Check mileage penalty
        // If over 100,000 miles AND not a Honda or Toyota, reduce final value by 25%
        boolean isReliableBrand = this.makeModel.toLowerCase().contains("honda") || this.makeModel.toLowerCase().contains("toyota");

        if (this.odometer > 100000 && !isReliableBrand) {
            value -= value * 0.25;
        }

        // Return the calculated value
        return value;
    }
}
