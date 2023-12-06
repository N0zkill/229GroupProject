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
public class Runway { 
    
    //List "planes" stores the planes on the runway
    private List<Plane> planes;
    
    //Initialize an empty list of planes
    public Runway() { 
        this.planes = new ArrayList<>();
    }
    
    //Method to add planes to the list "planes"
    public void addPlane(Plane plane) {
        planes.add(plane);
    }
    
    //Method to retrieve the list of planes by returning "planes"
    public List<Plane> getPlanes() {
        
        //Returns the plane list
        return planes;
    }

    
}
 
