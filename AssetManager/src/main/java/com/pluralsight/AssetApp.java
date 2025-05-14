package com.pluralsight;

import java.util.ArrayList;

public class AssetApp {
    public static void main(String[] args) {

        // Create an ArrayList to hold Asset objects (can be Houses or Vehicles)
        ArrayList<Asset> assets = new ArrayList<Asset>();

        // Add two House objects
        assets.add(new House("My House", "2020-06-01", 250000, "123 Main St", 1, 1800, 6000));
        assets.add(new House("Vacation Home", "2018-08-15", 325000, "456 Lakeview Dr", 2, 2200, 8000));

        // Add two Vehicle objects
        assets.add(new Vehicle("Tom's Truck", "2022-03-10", 45000, "Ford F-150", 2021, 32000));
        assets.add(new Vehicle("My Car", "2016-11-05", 32000, "Honda Civic", 2015, 105000));

        // Loop through the Asset list
        for (Asset asset : assets) {
            // Print common Asset details
            System.out.println("Description: " + asset.getDescription());
            System.out.println("Date Acquired: " + asset.getDateAcquired());
            System.out.printf("Original Cost: $%.2f\n", asset.getOriginalCost());
            System.out.printf("Current Value: $%.2f\n", asset.getValue());

            // Use instanceof to detect the real type of the object
            if (asset instanceof House) {
                // Downcast to House so we can access House-specific methods
                House house = (House) asset;
                System.out.println("Address: " + house.getAddress());
            } else if (asset instanceof Vehicle) {
                // Downcast to Vehicle so we can access Vehicle-specific methods
                Vehicle vehicle = (Vehicle) asset;
                System.out.println("Vehicle Info: " + vehicle.getYear() + " " + vehicle.getMakeModel());
            }

            System.out.println("----------------------------------");
        }
    }
}
