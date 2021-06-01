import java.util.ArrayList;
import java.util.List;

public class Week {
    List<Day> days = new ArrayList<Day>();
    List<Owner> ownerList = new ArrayList<Owner>();
    int kennelMax = 5;
    int kennelCount = 5;
    String[] dayNames = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};

    // Constructor
    public Week(){
        // Make and add the days
        Day sun = new Day("Sunday", kennelCount, kennelMax);
        days.add(sun);
        Day mon = new Day("Monday", kennelCount, kennelMax);
        days.add(mon);
        Day tues = new Day("Tuesday", kennelCount, kennelMax);
        days.add(tues);
        Day weds = new Day("Wednesday", kennelCount, kennelMax);
        days.add(weds);
        Day thurs = new Day("Thursday", kennelCount, kennelMax);
        days.add(thurs);
        Day fri = new Day("Friday", kennelCount, kennelMax);
        days.add(fri);
        Day sat = new Day("Saturday", kennelCount, kennelMax);
        days.add(sat);
    }

    public List<Owner> getOwners(){
        return ownerList;
    }

    public Day getDay(int dayIndex){
        return days.get(dayIndex);
    }

    public boolean changeDay(int dayIndex, Day newDay){
        if (dayIndex > 0 && dayIndex < 7){
            days.set(dayIndex, newDay);
            return true;
        }
        else{
            return false;
        }
    }

    public boolean addDog(int dayIndex, int kennelID, Dog d){
        Day newDay = days.get(dayIndex);
        return newDay.insertDog(kennelID, d);
    }

    public boolean addOwner(Owner o){
        for (Owner owner : ownerList) {
            if (owner.compare(o)) {
                // Owners are the same, unable to add
                return false;
            }
        }

        ownerList.add(o);
        return true;
    }

    public Owner findOwner(String name){
        for (Owner owner : ownerList){
            if (owner.getName().equals(name)){
                return owner;
            }
        }
        return new Owner(name);
    }

    public boolean ownerExists(Owner o){
        for (Owner owner : ownerList){
            if (owner.compare(o)){
                return true;
            }
        }
        return false;
    }

    public void printDay(int dayIndex){
        System.out.println("For " + dayNames[dayIndex] + " we have the following line-up: " );
        Day d = days.get(dayIndex);
        d.printKennels();
    }

    public void printWeek(){
        for(int i = 0; i < days.size(); i++) {
            printDay(i);
        }
    }
}
