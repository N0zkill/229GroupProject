/*
 * Vehicle Class Summary
 * 
 * This class is about creating methods and constructors to give vehicles a license plate
 * and give a vehicle type.
 * 
 * For Example: the vehicle types are either: a Car, Truck or Motorcycle.
 * 
 * The other java file named "VehicleType.java" shows what I am talking about.
 * 
 * This class also has setters and getters methods.
 */
public class Vehicle {
    //Private fields to store license plate and vehicle type
    private String licensePlate;
    private String vehicleModel;
    private VehicleType type;

    //Initialize a Vehicle with vehicle model (ex: ford or honda), license plate and vehicle type (ex: car or truck)
    public Vehicle(String vehicleModel, String licensePlate, VehicleType type) {
        this.licensePlate = licensePlate;
        this.type = type;
        this.vehicleModel = vehicleModel;
    }

    //Retrieve the license plate
    public String getLicensePlate() {
        return licensePlate;
    }


    //retrieve the type of vehicle
    public VehicleType getType() {
        return type;
    }

    //retrieving vehicle model of a vehicle
    public String getVehicleModel(){
        return vehicleModel;
    }
    
}
