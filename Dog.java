public class Dog {
    String breed;
    double dropOffTime;
    String name;
    String ownerName;
    double pickupTime;

    //Create Dog with all fields specified
    public Dog (String breed, double dropOffTime, String name, String ownerName, double pickupTime)
    {
        this.breed=breed;
        this.dropOffTime=dropOffTime;
        this.name=name;
        this.ownerName=ownerName;
        this.pickupTime=pickupTime;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public void setDropOffTime(double dropOffTime) {
        this.dropOffTime = dropOffTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setPickupTime(double pickupTime) {
        this.pickupTime = pickupTime;
    }

    public String getBreed() {
        return breed;
    }

    public double getPickupTime() {
        return pickupTime;
    }

    public String getName() {
        return name;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getDropOffTime() {
        return dropOffTime;
    }

    // Non-trivial

    /*
    Returns true if the dogs are the same, false otherwise
     */
    public boolean compare(Dog d){
        return breed.equals(d.getBreed()) && dropOffTime == d.getDropOffTime() && name.equals(d.getName()) && ownerName.equals(d.getOwnerName()) && pickupTime == d.getPickupTime();
    }

    public void printDog(){
        System.out.println("\t\tName: " + name);
        System.out.println("\t\tBreed: " + breed);
        System.out.println("\t\tOwner name: " + ownerName);
        System.out.println("\t\tDrop off time: " + dropOffTime);
        System.out.println("\t\tPick up time: " + pickupTime);
    }
}
