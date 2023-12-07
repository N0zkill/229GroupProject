import java.time.LocalDateTime;

/*
 * ParkingTicket Summary:
 * 
 * This class is about creating a ticketId, entry time, and license plate to vehicles.
 * 
 * This class also uses LocalDateTime to track the current real world time.
 * 
 * Somewhat short class with methods
 */

public class ParkingTicket {
    
    //Identifier for parking ticket
    private String ticketId;
    
    //Time field for vehicle
    private LocalDateTime entryTime;
    
    //License plate for the vehicle
    private String licensePlate;
    
    //Parking spot number of the vehicle 
    private int parkingSpotNumber;

    //Initialize ticked id, entry time, license plate, and parking spot number
    public ParkingTicket(String ticketId, String licensePlate, int parkingSpotNumber) {
        this.ticketId = ticketId;
        this.entryTime = LocalDateTime.now();
        this.licensePlate = licensePlate;
        this.parkingSpotNumber = parkingSpotNumber;
    }

    //Retrieves the parking spot number
    public int getParkingSpotNumber() {
        return parkingSpotNumber;
    }


    // Getters and setters for ticketId, entryTime, and licensePlate
    // Getter for ticketId
    public String getTicketId() {
        return ticketId;
    }
    
    


    // Getter for entryTime
    public LocalDateTime getEntryTime() {
        return entryTime;
    }


    // Getter for licensePlate
    public String getLicensePlate() {
        return licensePlate;
    }


}
