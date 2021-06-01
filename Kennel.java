import java.util.ArrayList;
import java.util.List;

public class Kennel {
    boolean kennelFull;
    int maxCapacity;
    int dogCount;
    double earliestPickupTime;
    List<Dog> dogs = new ArrayList<Dog>();

    // Constructors
    public Kennel(boolean bool, int cap, int count, double time){
        kennelFull = bool;
        maxCapacity = cap;
        dogCount = count;
        earliestPickupTime = time;
    }

    public Kennel(int cap){
        kennelFull = false;
        maxCapacity = cap;
        dogCount = 0;
        earliestPickupTime = 0.0;
    }

    // Setters
    public void setKennelFull(boolean bool){
        kennelFull = bool;
    }

    public void setMaxCapacity(int cap){
        maxCapacity = cap;
    }

    public void setDogCount(int count){
        dogCount = count;
    }

    public void setPickupTime(double time){
        earliestPickupTime = time;
    }

    // Getters
    public boolean getKennelFull(){
        return kennelFull;
    }

    public int getMaxCapacity(){
        return maxCapacity;
    }

    public int getDogCount() {
        return dogCount;
    }

    // Non-trivial methods
    public boolean addDog(Dog d){
        // Track earliest pickup time
        double ept = earliestPickupTime;
        for (Dog dog : dogs) {
            if (dog.compare(d)) {
                // Dogs are the same, unable to add
                return false;
            }

            if (dog.getPickupTime() < ept) {
                ept = dog.getPickupTime();
            }
        }

        // If kennel is already full, unable to add
        if (kennelFull){
            return false;
        }
        
        dogs.add(d);
        dogCount++;

        // Adjust the kennelFull bool if necessary
        if (dogCount >= maxCapacity){
            kennelFull = true;
        }

        earliestPickupTime = ept;
        return true;
    }

    public boolean addDogIncorrect(Dog d){
        // Track earliest pickup time
        double ept = earliestPickupTime;
        dogs.add(d);
        dogCount++;
        earliestPickupTime = ept;
        return true;
    }

    public boolean dogExists(Dog d){
        for (Dog dog : dogs) {
            if (dog.compare(d)) {
                return true;
            }
        }
        return false;
    }

    public void printDogs(){
        Dog d;
        for(int i = 0; i < dogs.size(); i++){
            d = dogs.get(i);
            System.out.println("\tDog " + (i+1) + " :");
            d.printDog();
        }
    }
}
