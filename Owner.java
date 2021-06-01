import java.util.ArrayList;
import java.util.List;

public class Owner {
    double bill;
    List<Dog> dogs = new ArrayList<Dog>();
    String email;
    String name;
    int phoneNumber;

    // Constructors
    public Owner(double b, List<Dog> ds, String e, String n, int phone){
        bill = b;
        dogs = ds;
        email = e;
        name = n;
        phoneNumber = phone;
    }

    public Owner(String e, String n, int phone){
        bill = 0;
        email = e;
        name = n;
        phoneNumber = phone;
    }

    public Owner(String n){
        bill = 0;
        email = "unknown";
        name = n;
        phoneNumber = 0000000;
    }

    // Setters
    public void setBill(double b){
        bill = b;
    }

    public void addDog(Dog d){
        dogs.add(d);
    }

    public void setEmail(String e){
        email = e;
    }

    public void setName(String n){
        name = n;
    }

    public void setPhoneNumber(int phone){
        phoneNumber = phone;
    }

    // Getters
    public double getBill(){
        return bill;
    }

    public List<Dog> getDogs(){
        return dogs;
    }

    public String getEmail(){
        return email;
    }

    public String getName(){
        return name;
    }

    public int getPhoneNumber(){
        return phoneNumber;
    }

    // Non-trivial methods
    public double addCharge(double amount){
        bill += amount;
        return bill;
    }

    public double payment(double amount){
        bill -= amount;
        return bill;
    }

    public boolean compare(Owner o){
        return email.equals(o.getEmail()) && name.equals(o.getName()) && phoneNumber==o.getPhoneNumber();
    }

    public void printOwner(){
        System.out.println("Name: " + name);
        System.out.print("Dogs: ");


        if (dogs.size() != 0){
            for (Dog dog : dogs) {
                dog.printDog();
            }
            System.out.print("\n");
        }

        else{
            System.out.print("None.\n");
        }

        System.out.println("Email: " + email);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Bill: " + bill);

    }
}
