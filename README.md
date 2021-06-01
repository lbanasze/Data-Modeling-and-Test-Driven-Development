
# NOTE: Originally uploaded to GitLab 
Sean Applegate and Laura Banaszewski

# Overview:
	
Java was our programming language of choice for this project. We created a week management system for a Doggy Daycare. This management system will allow the center to keep track of what dogs are in the facility on what days, what kennel they occupy, the name of the owner they go home with, owner information, and more. By choosing Day, Dog, Kennel, and Owner for our classes, we are able to effectively display relationships.

# Class Variables:

Day
 String dayOfWeek
 int dogCount
 int kennelMax
 List<Dog> dogs
 Hashtable<Integer, Kennel> kennels 

Dog
String breed
double dropOffTime
String name
String ownerName
double pickupTime

Kennel
boolean kennelFull
    	int maxCapacity
    	int dogCount
    	double earliestPickupTime
    	List<Dog> dogs

Owner
   	double bill
    	List<Dog> dogs
    	String email
    	String name
int phoneNumber

 
	Week
		List<Day> days
		List<Owner> ownerList
    		int kennelMax



Class Methods:

	Day
		constructor
		getters, setters
		boolean insertDog(int kennelID, Dog d)
boolean insertDogIncorrect(int kennelID, Dog d)
boolean dogExists(Dog d)
void printKennels()
	
Dog
	constructor
		getters, setters
		boolean compare(Dog d)
		void printDog()

	Kennel
		constructor
		getters, setters
		boolean addDog(Dog d)
		boolean addDogIncorrect(Dog d)
		boolean dogExists(Dog d)
		void printDogs()

	Owner
		constructor
		getters, setters
		Double addCharge(Double amount)
		Double payment(Double amount)
		boolean compare(Owner o)
		void printOwner()

	Week
		constructor
		boolean changeDay(int, Day)
		boolean addDog(int dayIndex, int kennelID, Dog d)
		boolean addOwner(Owner o)
		Owner findOwner(String name)
		boolean ownerExists(Owner o)
		void printDay(int dayIndex)
		void printWeek()







Class relationships:

# One-to-many:
A kennel can have multiple dogs, but dogs cannot be in multiple kennels at once. 
A week has many days.
A day has many kennels.

# Many-to-many:
A dog can attend on multiple days, and a day can have multiple dogs attending. 
An owner can have multiple dogs, and a dog can have multiple owners on file. For example, a neighbor can be on file as an owner for approved pick-up. 


It is important to note that while Dogs do not contain Owner objects, they do contain Owner names that can then be used to access Owner records. 


# Unit testing:

testCompareOwner()
The function being tested is used to compare two owners objects and return whether they are the same
Two owner objects are determined to be the same owner when they have the same name, email, and phone number
A successful test is one where when two owners with the same name and contact information returns true and false otherwise

testCompareDog()
The function being tested is used to compare whether or not two dog objects are the same
Two dog objects are determined to be the same dog when they have the same name, breed, drop-off time, pick up time, and owner name
A successful test is one where when two dogs with the same information returns true and false otherwise

testIncorrectDogInsertion()
The function being tested inserts a dog object into a kennel given a kennel id and dog object
Similar to dog insertion function, but does not check whether or not the kennel is already at max capacity or if the dog is already in the kennel
This test should fail, as it allows for duplicate entries 

testDogInsertion()
The function being tested inserts a dog object into a kennel given a kennel id and dog object
Function should not be able to add a dog if the kennel is at max capacity or if the dog being added is already in the kennel
The test should be successful if inserting the dog Mabel returns true the first time and false when trying to insert it again
The kennel’s max capacity was set to 1 so inserting Willow into the same kennel should return false but inserting into a different kennel should return true

testAddOwner()
The function being tested adds an owner to a list of Owner objects
Successful test will return true for adding an Owner but false when trying to insert the same owner again to avoid duplicates. Owner must be saved to Week’s owner list to be successful

testBilling()
The function addCharge(double) allows for the adding of a double to the owners bill
Successful test will make the bill equal to the added charge
Function payment(double) allows the owner to make a payment and decrease the bill
Successful test means that the bill should be equal to the bill - payment ( in this case the bill was 35.00 and the payment was 35.00 so the bill should equal 0

