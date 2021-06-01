import org.junit.Assert;
//simport static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Test;
//import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matcher.*;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class WeekTest {
    private static Week week;

    private static Dog mabel;
    private static Dog willow;
    private static Day wednesday;
    private static Owner laura;
    private static Owner sean;


    @BeforeClass
    public static void setUp(){
        week = new Week();

        laura= new Owner("laura@email.com","Laura Banaszewski", 1234567);
        sean= new Owner("sean@email.com","Sean Applegate", 4425161);

        mabel = new Dog("Corgi", 9.00, "Mabel", "Laura Banaszewski", 14.00);
        willow = new Dog("Chihuahua Mix", 7.00, "Willow", "Luca Kolba", 15.00);

        wednesday = new Day("Wednesday", 5, 1);
    }

    @After
    public void tearDown(){
        week.printWeek();
    }

    @Test
    public void testCompareOwner(){
        // Test comparison of Owners
        boolean compareLauras = laura.compare(laura);
        boolean compareOwners = sean.compare(laura);

        // laura and laura2 should be equal
        Assert.assertTrue(compareLauras);

        // sean and laura should not be equal
        Assert.assertFalse(compareOwners);
    }

    @Test
    public void testCompareDog(){
        // Test comparison of Dogs
        boolean compareMabels = mabel.compare(mabel);
        boolean compareDogs = willow.compare(mabel);

        // mabel and mabel2 should be equal
        Assert.assertTrue(compareMabels);

        // mabel and willow should not be equal
        Assert.assertFalse(compareDogs);
    }


    @Test
    public void testDogInsertion(){
        // Wednesday is an index of 3, kennels have a cap of 1 dog per kennel

        // Insert one dog into kennel 1
        boolean insertMabel = wednesday.insertDog(1, mabel);
        // Check if return true
        Assert.assertTrue(insertMabel);
        // Check to see if dog can now be found
        boolean findMabel = wednesday.dogExists(mabel);
        Assert.assertTrue(findMabel);

        // Attempt to insert the same dog again
        boolean insertMabel2 = wednesday.insertDog(2, mabel);
        // Make sure insertion return false
        Assert.assertFalse(insertMabel2);

        // Attempt to insert a second dog into kennel 1
        boolean insertWillow = wednesday.insertDog(1, willow);
        // Make sure insertion return false
        Assert.assertFalse(insertWillow);
        // Make sure willow cannot be found
        boolean findWillow = wednesday.dogExists(willow);
        Assert.assertFalse(findWillow);

        // Attempt to insert willow into a different kennel
        boolean insertWillow2 = wednesday.insertDog(3, willow);
        // Make sure insert was successful
        Assert.assertTrue(insertWillow2);
        findWillow = wednesday.dogExists(willow);
        Assert.assertTrue(findWillow);

        week.changeDay(3, wednesday);
    }

    @Test
    public void testIncorrectDogInsertion(){
        // Wednesday is an index of 3, kennels have a cap of 1 dog per kennel

        // Insert one dog into kennel 1
        boolean insertMabel = wednesday.insertDogIncorrect(0, mabel);
        // Check if insertion was successful
        Assert.assertTrue(insertMabel);

        // Attempt to insert the same dog again
        boolean insertMabel2 = wednesday.insertDogIncorrect(2, mabel);
        // Make sure insertion was unsuccessful
        Assert.assertFalse(insertMabel2);

        // Attempt to insert a second dog into kennel 1
        boolean insertWillow = wednesday.insertDogIncorrect(0, willow);
        // Make sure insertion was unsuccessful
        Assert.assertFalse(insertWillow);

        // Attempt to insert willow into a different kennel
        boolean insertWillow2 = wednesday.insertDogIncorrect(1, willow);
        // Make sure insert was successful
        Assert.assertTrue(insertWillow2);

        // Change day for printing purposes
        week.changeDay(3, wednesday);
    }

    @Test
    public void testAddOwner(){

        // Insert an owner into the list of owners for the week
        boolean addLaura = week.addOwner(laura);
        Assert.assertTrue(addLaura);

        // Check if insertion was successful
        Owner findOwner = week.findOwner(laura.getName());
        boolean inserted = laura.compare(findOwner);
        Assert.assertTrue(inserted);

        // Attempt to add the same owner again
        boolean addLaura2 = week.addOwner(laura);
        // Make sure insertion was unsuccessful
        Assert.assertFalse(addLaura2);

        // Add sean as an owner
        boolean addSean = week.addOwner(sean);
        // Make sure addition is successful
        Assert.assertTrue(addSean);

        // Check if insertion was successful
        Owner findOwner2 = week.findOwner(sean.getName());
        boolean inserted2 = sean.compare(findOwner2);
        Assert.assertTrue(inserted2);
    }

    @Test
    public void testBilling(){

        // Charge sean 35.00
        sean.addCharge(35.00);

        // Check that sean's bill is now 35.00
        Assert.assertEquals(sean.getBill(),35.00, 0.00);

        // Add a payment of 35.00 for sean
        sean.payment(35.00);

        // Check sean's bill is now 0
        Assert.assertEquals(sean.getBill(),0.00, 0.00);
    }

}
