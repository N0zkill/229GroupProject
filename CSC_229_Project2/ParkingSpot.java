/*
 * ParkingSpot Summary:
 * 
 * This class is short and is about checking whether a parking spot is occupied or not
 */
public class ParkingSpot {
    
    //Spot number of the vehicle
    private int spotNumber;
    
    //Boolean data type to see if the spot is filled or empty
    private boolean isOccupied;
    
    // Type of vehicle that can park
    private VehicleType type; 

    //Initialize the spot number, the vehicle type, and if the spot is occupied or not
    public ParkingSpot(int spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.type = type;
        this.isOccupied = false;
    }


    // Getter for the type of vehicle
    public VehicleType getType() {
        return type;
    }

    //Retrieve the spot number
    public int getSpotNumber() {
        return spotNumber;
    }

    //Retrieve the boolean isOccpied
    public boolean isOccupied() {
        return isOccupied;
    }

    //Set boolean occupied 
    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }
}