/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Question_8;

/**
 *
 * @author mohas
 */
public class Plane {
    
    //Identifier for plane
    private String id; 
    
    //Departutre direction of the plane
    private int departureDirection;
    
    //Default constructor for initializing the id and departure direction
    public Plane(String id, int departureDirection) { 
        
        //Set plane id
        this.id = id; 
        
        //Set plane departutre direction
        this.departureDirection = departureDirection;
    } 
    
    //Retrieves the ID
    public String getId() { 
        
        //Returns ID
        return id;
    } 
    
    //Retrieves departure direction
    public int getDepartureDirection() { 
        
        //Returns departure direction
        return departureDirection;
    }
    
    //Override the orgional toString method
    @Override
    public String toString() {
        
        //Formats the plane id 
        return "Plane ID: " + id;
    }
}
