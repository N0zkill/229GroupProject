import java.util.*;
import java.util.function.Predicate;

/*
 * ParkingLot Summary:
 * 
 * This class uses Generics, Predicate, Comparators, and Collections.
 * 
 * This class is about adding vehicles to a parking spot
 * Checking if a spot is available
 * Count available spots
 * Sorts by spot number
 */

 //Creating a parking lot using Generics.
public class ParkingLot<T> {
    private List<T> spots;

    //The arrayList List<T> will keep track of parking spots.
    public ParkingLot() {
        this.spots = new ArrayList<>();
    }


    //A method that adds vehicles to a spot.
    public void addSpot(T spot) {
        spots.add(spot);
    }


    //A getter that can return a spot location.
    public List<T> getSpots() {
        return spots;
    }



    // This method is a generic filter for parking spots in the parking lot. 
    // It returns a list of spots that satisfy a given condition, specified by the 'filter' parameter.
    // Which in our case is used to find available spots and figuring out which spots are occupied.
    public List<T> findSpots(Predicate<T> filter) {
        List<T> filteredSpots = new ArrayList<>();
        for (T spot : spots) {
            if (filter.test(spot)) {
                filteredSpots.add(spot);
            }
        }
        return filteredSpots;
    }


    
    //Methods for sorting and other operations

    //This method checks if a spot is available while iterating through the generic list.
    public ParkingSpot getAvailableSpot() {
        for (T spot : spots) {
            //Here we're checking if a spot is available or not.
            if (spot instanceof ParkingSpot && !((ParkingSpot) spot).isOccupied()) {
                return (ParkingSpot) spot;
            }
        }
        //If there are not available spots, then it returns null.
        return null;
    }


    //This method counts how many spots are available 
    public int countAvailableSpots() {
        int count = 0;
        for (T spot : spots) {
            //Here we're checking if a spot is available and will increment for each available spot.
            if (spot instanceof ParkingSpot && !((ParkingSpot) spot).isOccupied()) {
                count++;
            }
        }
        return count;
    }



    //This method serves to sort the parking spots by checking which spots are occupied.
    public void sortByOccupancy() {
        Collections.sort(spots, new Comparator<T>() {
            @Override
            public int compare(T o1, T o2) {
                if (o1 instanceof ParkingSpot && o2 instanceof ParkingSpot) {
                    ParkingSpot spot1 = (ParkingSpot) o1;
                    ParkingSpot spot2 = (ParkingSpot) o2;
                    return Boolean.compare(spot1.isOccupied(), spot2.isOccupied());
                }
                return 0;
            }
        });
    }



    
    
    

}


