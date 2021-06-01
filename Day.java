import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;
import java.util.Dictionary;

public class Day {
    String dayOfWeek;
    int dogCount;
    int kennelMax;
    Hashtable<Integer, Kennel> kennels = new Hashtable<>();

    // Constructors
    public Day(String dow, int c, int km, Hashtable<Integer, Kennel> ks){
        dayOfWeek = dow;
        kennelMax = km;
        dogCount = c;
        kennels = ks;
    }

    public Day(String dow, int km, int kcap){
        dayOfWeek = dow;
        dogCount = 0;
        kennelMax = km;

        for(int i = 0; i < km; i++){
            Kennel newKennel = new Kennel(kcap);
            kennels.put(i, newKennel);
        }
    }

    // Setters
    public void setDayOfWeek(String dow){
        dayOfWeek = dow;
    }

    public void setDogCount(int c){
        dogCount = c;
    }

    public boolean addKennel(int id, Kennel k){
        if (kennels.size() < kennelMax){
            kennels.put(id, k);
            return true;
        }
        else{
            return false;
        }
    }

    // Getters
    public String getDayOfWeek(){
        return dayOfWeek;
    }

    public int getDogCount(){
        return dogCount;
    }

    public Hashtable<Integer, Kennel> getKennels(){
        return kennels;
    }

    // Non-trivial methods

    public boolean insertDog(int kennelID, Dog d){
        // Get the kennel as is
        Kennel k = kennels.get(kennelID);
        // Add the new dog
        if (k.addDog(d)){
            // Update in table
            kennels.put(kennelID, k);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean insertDogIncorrect(int kennelID, Dog d){
        // Get the kennel as is
        Kennel k = kennels.get(kennelID);
        // Add the new dog
        if (k.addDogIncorrect(d)){
            // Update in table
            kennels.put(kennelID, k);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean dogExists(Dog d){
        Enumeration<Integer> ks = kennels.keys();

        while(ks.hasMoreElements()) {
            Integer key = ks.nextElement();
            Kennel k = kennels.get(key);
            if (k.dogExists(d)){
                return true;
            }
        }

        return false;
    }

    public void printKennels(){

        Enumeration<Integer> ks = kennels.keys();

        while(ks.hasMoreElements()) {
            Integer key = ks.nextElement();
            System.out.println("Kennel ID : "  + (key + 1));
            Kennel k = kennels.get(key);
            k.printDogs();
        }
    }
}
