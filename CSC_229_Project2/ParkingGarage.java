import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

/**
 * The ParkingGarage Summary:
 * 
 * This class reads parking garage's functionalities
 * Assigns a parking ticket to know if a spot is taken or not
 * 
 * Has a method that checks if the vehicle is parked, assigns ticket, and increments car count
 * Has a method if a car leaves, it checks ticket, makes an occupied spot availabe, and decrements car count
 * Has methods to display vehicle and parking spot lists.
 * Has methods to sort vehicles based on occupancy and license plates.
 * 
 * And a set of methods at the bottom such as generateTicketId() and isSpotAvailable()
 * 
 */

public class ParkingGarage {
    //Creating Intializations for Parking Spot, Parking Ticket and Vehicles.
    private ParkingLot<ParkingSpot> parkingLot = new ParkingLot<>();
    private List<ParkingTicket> issuedTickets = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>(); // List to hold vehicles
    
    
    //This will keep track of vehicles that have entered or exited the parking lot
    private int currentVehicleCount;

    //peak hour threshold will determine how packed the parking lot is. If it 5 or more,
    private final int peakHourThreshold;
    private double standardRate; //standard rate is the regular rate being charged after peak hours
    private double peakHourRate; // peak hour rate is double the standard rate




    //Constructor for creating a parking garage containing the following:
    //capacity, peak hour threshold, standard rate, peak hour rate
    public ParkingGarage(int capacity, int peakHourThreshold, double standardRate, double peakHourRate) {
        //initializing standard rate and peak hour rate
        this.standardRate = standardRate;
        this.peakHourRate = peakHourRate;

        //Intitalizing peakHourThreshold that would increase the rate being
        //charged if a lot of cars are occupied
        this.peakHourThreshold = peakHourThreshold;

        //This will increment or decrement depending on how many cars enter or leave the parking lot
        //This one is important to keep track
        this.currentVehicleCount = 0;

        //This function will add the vehicle type to each vehicle and determines if it's a truck or car or motorcycle
        for (int i = 0; i <= capacity; i++) {
            VehicleType type = (i % 3 == 0) ? VehicleType.TRUCK : VehicleType.CAR;
            parkingLot.addSpot(new ParkingSpot(i, type));
        }

    }



    
    //This function will park vehicles to the parking lot
    public ParkingTicket parkVehicle(Vehicle vehicle) {
        //Checking if a spot is available
        ParkingSpot spot = parkingLot.getAvailableSpot();
        //if the spot is not empty, we'll create a ticketID, grab license plate and assign their spot number
        if (spot != null) {
            spot.setOccupied(true);
            ParkingTicket ticket = new ParkingTicket(generateTicketId(), vehicle.getLicensePlate(), spot.getSpotNumber());
            
            //Once ticket is created, we'll issue it to the vehicle and add the vehicle to the parking lot
            issuedTickets.add(ticket);
            vehicles.add(vehicle);
            //we'll increment the vehicle count that keeps track of how many are in the parking lot
            currentVehicleCount++; 
            return ticket;
        } else {
            //If the garage is full, a "Parking failed message" will be thrown.
            System.out.println("Parking failed. Garage full.");
            return null;
        }
    }


    
    //This method will serve to remove vehicles from the parking lot and
    //is responsible for handling the process of removing them.
    public void unparkVehicle(ParkingTicket ticket) {
        //Here we're checking if the ticket given was valid and provided. If the ticket is null,
        //a message will print saying that no ticket was provided while leaving the parking lot.
        if (ticket == null) {
            System.out.println("No ticket provided for unparking.");
            return;
        }

        //This line extracts and returns the parking spot number associated with the ticket.
        Integer spotNumber = extractSpotNumberFromTicket(ticket);

        //This for loop will iterate through the parking spots, filter and return a list of parking spots.
        //whose spot numbers match the spot number extracted from the ticket.
        for (ParkingSpot spot : parkingLot.findSpots(s -> s.getSpotNumber() == spotNumber)) {
            //this function will then check if the spot isn't empty and occupied
            if (spot != null && spot.isOccupied()) {
                //We'll change the parking spot to false to indicate that the parking spot is available
                spot.setOccupied(false); 
                currentVehicleCount--; // Decrement count after successful unparking
                break; //this will exit the loop after the first matching and occupipied spot is found.
            }
        }

        //This line reads vehicle list, and removes a vehicle if the license plate matches the license plate on the Parking ticket.
        vehicles.removeIf(v -> v.getLicensePlate().equals(ticket.getLicensePlate()));
    }





    //This method will display a list of all the vehicles in the parking lot along with their vehicle information.
    public void displayVehicles() {
        int counter = 0; //This will number how many vehicles are in the list and increment as the list goes on.
        System.out.println("Vehicles in Parking Lot:");
        for (Vehicle vehicle : vehicles) {
            counter++; 
            System.out.println("\n" + counter + ". " + vehicle.getVehicleModel() + 
            ": \nVehicle License Plate: " + vehicle.getLicensePlate() + ", Type of vehicle: " + vehicle.getType());
        }
    }



    //This method will display the available and occupied parking spots.
    public void displayParkingSpots() {
        System.out.println("\nParking Spots Status:");
        for (ParkingSpot spot : parkingLot.getSpots()) {
            String status = spot.isOccupied() ? "Occupied (x)" : "Available";
            System.out.println("Spot " + spot.getSpotNumber() + ": " + status);
        }
    }


    
    //This method will serve to sort the vehicles in order based on license plate.
    //Its purpose is to give a report of vehicles license plates in order to keep track of who is parked.
    public void sortVehiclesByLicensePlate() {
        Collections.sort(vehicles, new Comparator<Vehicle>() {
            @Override
            public int compare(Vehicle v1, Vehicle v2) {
                return v1.getLicensePlate().compareTo(v2.getLicensePlate());
            }
        });
    }




    //Creating Methods

    //Method to get standard rate.
    public double getStandardRate(){
        return standardRate;
    }


    //Method to get peak hour rate.
    public double getPeakHourRate(){
        return peakHourRate;
    }

    //Calls the sorting method in ParkingLot class.
    public void sortSpotsByOccupancy() {
        parkingLot.sortByOccupancy(); 
    }

    //check peak hour by how many vehicles are in the parking lot.
    public boolean isCurrentlyPeakHour() {
        return currentVehicleCount >= peakHourThreshold;
    }

    //This generates a reandom string of values that serves as a ticket id
    private String generateTicketId() {
        return UUID.randomUUID().toString();
    }

    //This is a method that basically extracts spot number from ticket
    //and returns the parking spot based on the spot the ticket is placed.
    private int extractSpotNumberFromTicket(ParkingTicket ticket) {
        return ticket.getParkingSpotNumber();
    }

    //Getter method that returns the current vehicle count in the parking lot.
    public int getCurrentVehicleCount() {
        return currentVehicleCount;
    }
    
    //Boolean method that checks if a spot is available.
    public boolean isSpotAvailable() {
        return parkingLot.countAvailableSpots() > 0;
    }

}

