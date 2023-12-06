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
public class Departure {
    
    //List to store avalible runways
    private List<Runway> runways;
    
    //Initialize the departure system
    public Departure(int numRunways) {
        
        //Initialize the list of runways
        this.runways = new ArrayList<>();
        
        //Add objects to the list
        for (int i = 0; i < numRunways; i++) {
            runways.add(new Runway());
        }
    }
    
    //Method that assigns plain to runway
    public void assignPlaneToRunway(Plane plane) {
        
        //Check if there are available runways
        if (!runways.isEmpty()) {
            Random random = new Random();
            
            //Selects a random runway and adds the plane to it
            Runway selectedRunway = runways.get(random.nextInt(runways.size()));
            selectedRunway.addPlane(plane);
        } else {
            System.out.println("No runways available for plane assignment.");
        }
    }
    
    //Method to retrieve runway
    public List<Runway> getRunways() {
        
        //Returns the runway list
        return runways;
    }
}
