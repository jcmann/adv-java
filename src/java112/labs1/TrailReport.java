package java112.labs1;

import java.util.ArrayList;

/**
 * This class holds a list of trails in the system and displays a report of all trail data.
 *
 * @author pawaite
 * @see Trail
 */
public class TrailReport {
    /**
     * List of all trails.
     */
    private ArrayList<Trail> trails;

    /**
     * Instantiates a new Trail report into the instance variable trails
     */
    public TrailReport() {
        trails = new ArrayList<>();
    }

    /**
     * Gets the list of trails.
     *
     * @return trails all trails in the system, instance var
     */
    public ArrayList<Trail> getTrails() {
        return trails;
    }

    /**
     * Sets the list of trails.
     *
     * @param trails all trails in the system
     */
    public void setTrails(ArrayList<Trail> trails) {
        this.trails = trails;
    }

    /**
     * Print a report displaying the details of each trail in the system.
     */
    public void printTrailReport() {
        for (Trail trail: trails) {
            System.out.println(trail);
        }
    }
}
