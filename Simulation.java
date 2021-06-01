import java.util.List;

public class Simulation {
    public Simulation(Week week){
        System.out.println("EMPTY WEEK: \n");
        week.printWeek();
        System.out.println();
        System.out.println();

        System.out.println("ADD TWO DOGS: \n");
        week.addDog(0, 1, new Dog("Pug", 8.00, "Pig", "John Smith", 14.00));
        week.addDog(0, 1, new Dog("Corgi", 10.00, "Mabel", "Laura Banaszewski", 14.00));
        week.printWeek();
        System.out.println();
        System.out.println();

        System.out.println("ADD TWO OWNERS: \n");
        Owner laura= new Owner("laura@email.com","Laura Banaszewski", 1234567);
        Owner sean= new Owner("sean@email.com","Sean Applegate", 4425161);
        week.addOwner(laura);
        week.addOwner(sean);
        List<Owner> owners = week.getOwners();
        for (Owner o: owners){
            o.printOwner();
            System.out.println();
        }
    }
}
