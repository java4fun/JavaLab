
package generics.wildcards;

import java.util.ArrayList;
import java.util.List;

public class Main {
    
    
    public static void main(String[] args) {
        
        // List of buildings
        List<Building> buildings = new ArrayList();
        buildings.add(new Building());
        buildings.add(new Building());
        printBuildings(buildings);
        
        // List of offices
        List<Office> offices = new ArrayList();
        offices.add(new Office());
        offices.add(new Office());
        printBuildings(offices);

        // List of houses
        List<House> houses = new ArrayList();
        houses.add(new House());
        houses.add(new House());
        printBuildings(houses);
        
        addHouseToList(houses);
        addHouseToList(buildings);        
        
    }

    /*
    //
    static void printBuildings(List<Building> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(i + 1 + ": " + buildings.get(i).toString());
        }
    }
    */

    // In variable: extends
    static void printBuildings(List<? extends Building> buildings) {
        for(int i = 0; i < buildings.size(); i++) {
            System.out.println(buildings.get(i).toString() + " " + (i + 1));
        }
        System.out.println();
    }
    
    // Out variable: super
    static void addHouseToList(List<? super House> buildings) {
        buildings.add(new House());  // House or its sub-class (child class)
        buildings.add((House) new Building()); // NOT super(parent)-class of House
        
        System.out.println();
    }
    
    
}
