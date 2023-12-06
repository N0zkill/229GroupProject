/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_8;

/**
 *
 * @author mohas
 */
import java.util.*;
public class AirportSimulation {
    public static void main(String[] args) {
        
        //Promt for user to enter the number of runways
        System.out.println("How many runways?");
                
        //Initializes int x to the number of runways the user enters
        Scanner scnr = new Scanner(System.in); 
        int x = scnr.nextInt();
        
        //Initialize the departure system with x runways
        Departure departureSystem = new Departure(x);
        
        //Promts the user to enter the number or planes and assigns it to y
        System.out.println("How many planes?");
        int y = scnr.nextInt();
        
        //Generates y planes with random departure directions
        Random random = new Random();
        
        //Loop to assign y planes in random directions
        for (int i = 0; i < y; i++) {
            int departureDirection = random.nextInt(x); 
            Plane plane = new Plane("Plane" + i, departureDirection);

            //Assign the plane to a runway in the departure system
            departureSystem.assignPlaneToRunway(plane);
        }

        //Display the planes on each runway
        List<Runway> allRunways = departureSystem.getRunways();
        for (int i = 0; i < allRunways.size(); i++) {
            System.out.println("Runway " + i + ": " + allRunways.get(i).getPlanes());
        }
    }
}
