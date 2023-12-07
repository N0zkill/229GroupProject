/**
 * Summary of Main Class:
 * 
 * Main class will be testing 8 objects and performing its roles.
 * 
 * The roles are cars entering and leaving the parking lot.
 * PeakHour, standard rate, license plate, reserved spots etc...
 * 
 * This program will work by displaying reports of vehicles entering and leaving at 9am and 5pm.
 * Peak hour rate and standard rate will be reported and how much each paid.
 * 
 */

public class Main {
    public static void main(String[] args) {
        // Create a parking garage with capacity, peak hour threshold, and rates
        ParkingGarage garage = new ParkingGarage(10, 5, 0.50, 1.00);


        // Create various vehicles
        // Creating a list of vehicles to be parked and are entering the parking lot
        Vehicle Toyota = new Vehicle("Toyota", "CAR123", VehicleType.CAR);
        Vehicle Honda = new Vehicle("Honda", "RZ1832", VehicleType.CAR);
        Vehicle DodgeRam = new Vehicle("DodgeRam", "TRK789", VehicleType.TRUCK);
        Vehicle Suzuki = new Vehicle("Suzuki", "MTR321", VehicleType.MOTORCYCLE);

        Vehicle Lamborghini = new Vehicle("Lamborghini", "AZ2371", VehicleType.CAR);
        Vehicle Ferrari = new Vehicle("Ferrari", "CAR456", VehicleType.CAR);
        Vehicle Ford = new Vehicle("Ford", "CU7392", VehicleType.TRUCK);
        Vehicle Aprilia = new Vehicle("Aprilia", "XWME93", VehicleType.MOTORCYCLE);

        //Each vehicle will have a ticket and they will help determine which cars have left the parking lot.
        ParkingTicket ticket1 = garage.parkVehicle(Toyota);
        ParkingTicket ticket2 = garage.parkVehicle(Honda);
        ParkingTicket ticket3 = garage.parkVehicle(DodgeRam);
        ParkingTicket ticket4 = garage.parkVehicle(Suzuki);

        ParkingTicket ticket5 = garage.parkVehicle(Lamborghini);
        ParkingTicket ticket6 = garage.parkVehicle(Ferrari);
        ParkingTicket ticket7 = garage.parkVehicle(Ford);
        ParkingTicket ticket8 = garage.parkVehicle(Aprilia);

        
        
        //First Scenario: Cars are being entered to the parking garage
        System.out.println("\nIt's currently 9am and " + garage.getCurrentVehicleCount() +  " vehicles have parked into the parking lot.");

        System.out.println("Is it peak hour? " + garage.isCurrentlyPeakHour());
        System.out.println("The peak hour rate being charged is: $" + garage.getPeakHourRate() + " dollar per hour.");
        
        //1st report of cars in the parking garage based on vehicle model, license plate and vehicle type
        System.out.println("\nHere's the 1st report of the parking garage based on vehicle model, license plate and vehicle type:");
        garage.displayVehicles(); //shows a whole list of cars that are parked
        garage.displayParkingSpots(); //shows what parking spots are occupied or not.
        
        // System.out.println("In the corner of the parking lot, a few license plates are visible and its car types are as follow:");
        

        //1st sorting function based on what spots are available
        System.out.println("\n\n\nSorting cars based on what spots are available...");
        garage.sortSpotsByOccupancy(); //this method sorts the spots that are taken or not.


        //2nd report of the parking lot after sorting based on spot availability.
        System.out.println("2nd Report of parking lot after sorting based on spot availability.");
        garage.displayParkingSpots();


        //2nd sorting function based on license plates.
        System.out.println("\n\n\nGathering all license plates for accurate reports by sorting the vehicles in order...");
        garage.sortVehiclesByLicensePlate();


        //3rd report after sorting based on license plates.
        System.out.println("\n3rd Report of vehicles after being sorted:");
        garage.displayVehicles();




        //2nd Scenario: 4 cars are leaving the parking lot

        System.out.println("\n\n\n\nIt's currently 5pm and 4 cars have left the parking lot");


        //These will serve as an example of vehicles leaving the parking lot.
        //These tickets will help remove cars as if they are leaving the parking lot.
        if (ticket2 != null) {
            garage.unparkVehicle(ticket2);
        }
        if (ticket5 != null) {
            garage.unparkVehicle(ticket5);
        }
        if (ticket6 != null) {
            garage.unparkVehicle(ticket6);
        }
        if (ticket8 != null) {
            garage.unparkVehicle(ticket8);
        }

        //4th report of cars that left the parking lot.
        System.out.println("4th Report of cars that have left the parking lot along " +
        "\nwith their TicketID, License Plate, Vehicle Type, Entry Time, and Parking Spot.");

        System.out.println("\n\n1. " + Honda.getVehicleModel() + ", TicketID: " + ticket2.getTicketId() + "," +
        "\nLicense Plate: "  + ticket2.getLicensePlate() + ", " + "Type of Vehicle: " + Honda.getType() + 
        "\nEntry Time: " + ticket2.getEntryTime() + ", Parking Spot: " + ticket2.getParkingSpotNumber());
        
        
        System.out.println("\n2. " + Lamborghini.getVehicleModel() + ", TicketID: " + ticket5.getTicketId() + "," +
        "\nLicense Plate: "  + ticket5.getLicensePlate() + ", " + "Type of Vehicle: " + Lamborghini.getType() + 
        "\nEntry Time: " + ticket5.getEntryTime() + ", Parking Spot: " + ticket5.getParkingSpotNumber());
        
        
        System.out.println("\n3. " + Ferrari.getVehicleModel() + ", TicketID: " + ticket6.getTicketId() + "," +
        "\nLicense Plate: "  + ticket6.getLicensePlate() + ", " + "Type of Vehicle: " + Ferrari.getType() + 
        "\nEntry Time: " + ticket6.getEntryTime() + ", Parking Spot: " + ticket6.getParkingSpotNumber());
        
        
        System.out.println("\n4. " + Aprilia.getVehicleModel() + ", TicketID: " + ticket8.getTicketId() + "," +
        "\nLicense Plate: "  + ticket8.getLicensePlate() + ", " + "Type of Vehicle: " + Aprilia.getType() + 
        "\nEntry Time: " + ticket8.getEntryTime() + ", Parking Spot: " + ticket8.getParkingSpotNumber());


        double amount = garage.getPeakHourRate() * 8;
        System.out.println("\nEach of them paid: $" + amount + " for their parking time.");
        
        
        



        //Display current vehicle count, sorting the new spots that are available and changing peak hour
        //to standard rate after 4 cars left the parking lot.
        System.out.println("\n\n\nCurrent Vehicle Count: " + garage.getCurrentVehicleCount());
        System.out.println("These are the vehicles that are still parked and new spots that are available: ");
        garage.displayVehicles();
        garage.sortSpotsByOccupancy();
        garage.displayParkingSpots();


        System.out.println("Is it peak hour? " + garage.isCurrentlyPeakHour());

        System.out.println("\nPeak hour rate is disabled since there are less than 5 cars." +
        "\nThe standard rate is now ¢" + garage.getStandardRate() + " cents per hour.");

        System.out.println("\nThe remaining vehicles were charged $" + amount +
        "\nand will now be charged the standard rate of ¢" + garage.getStandardRate() + " cents per hour.");

    }
}
