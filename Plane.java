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
    private String id; 
    private int departureDirection;
    public Plane(String id, int departureDirection) { 
        this.id = id; 
        this.departureDirection = departureDirection;
    } 
    public String getId() { 
        return id;
    } 
    public int getDepartureDirection() { 
        return departureDirection;
    }
    @Override
    public String toString() {
        return "Plane ID: " + id;
    }
}
