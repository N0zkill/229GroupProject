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
    private List<Runway> runways;

    public Departure(int numRunways) {
        this.runways = new ArrayList<>();
        for (int i = 0; i < numRunways; i++) {
            runways.add(new Runway());
        }
    }

    public void assignPlaneToRunway(Plane plane) {
        if (!runways.isEmpty()) {
            Random random = new Random();
            Runway selectedRunway = runways.get(random.nextInt(runways.size()));
            selectedRunway.addPlane(plane);
        } else {
            System.out.println("No runways available for plane assignment.");
        }
    }

    public List<Runway> getRunways() {
        return runways;
    }
}
