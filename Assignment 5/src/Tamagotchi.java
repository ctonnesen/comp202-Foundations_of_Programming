// Name: Christian Tonnesen
// ID: 260847409

import java.util.ArrayList;
import java.util.Random;

public class Tamagotchi {
 private static final double MAX_ENERGY = 10.0;
 private static Random r = new Random();
 private String name;
 private int level;
 private double energy;
 private int experience;
 private int mealsEaten;
 private ArrayList<Toy> ownedToys;
 
// The private attributes are declared, including a random object and the max energy final attribute to be used during the sleep command

 public Tamagotchi(String name, int level, double energy, int experience, int mealsEaten, ArrayList<Toy> ownedToys) {
  this.name = name;
  this.level = level;
  this.energy = energy;
  this.experience = experience;
  this.mealsEaten = mealsEaten;
  this.ownedToys = ownedToys;
 }
 
// The first constructor creates a Tamagotchi using information of a pre-existing one

 public Tamagotchi(String name) {
  this.name = name;
  this.level = 1;
  this.energy = MAX_ENERGY;
  this.experience = 0;
  this.mealsEaten = 0;
  ArrayList<Toy> ownedToys = new ArrayList<Toy>();
  this.ownedToys = ownedToys;
  this.ownedToys.add(new Toy());
 }
 
// The second constructor creates a random Tamagotchi with a random new toy
 
  public static void main (String[] args) {
  }

 public String getName() {
  return name;
 }

 public int getLevel() {
  return level;
 }

 public double getEnergy() {
  return energy;
 }

 public int getXp() {
  return experience;
 }

 public int getNumOfMeals() {
  return mealsEaten;
 }

 public ArrayList<Toy> getToys() {
  ArrayList<Toy> copyOwnedToys = new ArrayList<Toy>();
  for (int index = 0; index < ownedToys.size(); index++) {
   copyOwnedToys.add(ownedToys.get(index));
  }
  return copyOwnedToys;
 }
 
// A copy of the toys array is created to stop anyone from changing the original private attributes

 private void levelUp() {
  if (getXp() >= (50 * level * (level + 1) / 2)) {
   level++;
   mealsEaten = 0;
   Toy newToy = new Toy();
   ownedToys.add(newToy);
   System.out.println();
   System.out.println("!!! It's level up time !!!");
   System.out.println(getName() + " is now level " + getLevel());
   System.out.println("Your new toy is " + newToy.toString());
  }
 }

// levelUp raises the level, resets the meals, and gives the Tamagotchi a new toy
 
 public void play (int playingMode) {
  if (ownedToys.size() == 0 || energy < 2) {
   throw new IllegalStateException("The tamagotchi is not able to play");
  }
  Toy chosenToy = new Toy();
  int x;
  if (playingMode == 1) {
   chosenToy = Toy.findBestToy(ownedToys);
   x = chosenToy.getXp();
   experience += x;
   energy -= r.nextDouble() * x / 20 + ((x / 20.0 + 0.5) - x / 20);
   System.out.println();
   System.out.println(name + " played with " + chosenToy.toString() + " and earned " + x + " xp.");
   System.out.println(name + " has now " + experience + " xp and " + energy + " energy.");
  }
  if (playingMode == 2) {
   chosenToy = ownedToys.get(r.nextInt(ownedToys.size()));
   x = chosenToy.getXp();
   experience += x;
   energy -= r.nextDouble() * x / 20 + ((x / 20.0 + 0.5) - x / 20);
   System.out.println();
   System.out.println(name + " played with " + chosenToy.toString() + " and earned " + x + " xp.");
   System.out.println(name + " has now " + experience + " xp and " + energy + " energy.");
  }
  levelUp();
 }
 
// The play method takes in an int representing the play mode and uses two if statements to decide which toy to use. Play mode 1 uses the
// the findBestToy method from the Toy class while play method 2 grabs a random toy from the ArrayList

 public void feed() {
  if (energy < 1 || mealsEaten >= (2 * level)) {
   throw new IllegalStateException("The tamagotchi is not able to eat");
  }
  energy += r.nextDouble() * 0.5;
  experience += r.nextInt(4);
  mealsEaten++;
  System.out.println("Yum!");
  System.out.println(name + " has now " + experience + " xp and " + energy + " energy.");
  levelUp();
 }
 
// The feed method checks to make sure that the Tamagotchi has enough energy to eat and has not eaten too many meals. If not, then
// it adds experience to the private experience attribute and energy to the energy attribute

 public void sleep () {
  System.out.println(name + " is now going to sleep. (- . -) Zzzz...");
  energy = MAX_ENERGY;
 }
 
 // The sleep method simply uses the MAX_ENERGY attribute to reset the energy level

 public String toString() {
  return ("Name: " + "\t" + name + "\n" + "Level: " + "\t" + level + "\n" + "Energy: " + energy + "\n" + 
    "Xp: " + "\t" + experience + "\n" + "Meals: " + "\t" + mealsEaten + "\n" +  "Toys: " + "\t" + toysString(getToys()));
 }

// The toString method prints the private attributes, calling the toysString method to write out the ArrayList of toys
 
 private String toysString (ArrayList<Toy> arrayOfToys) {
  String toys = "";
  for (int index = 0; index < arrayOfToys.size(); index++) {
   if (index == (arrayOfToys.size()-1)) {
    toys = toys + arrayOfToys.get(index).getName() + " the " + arrayOfToys.get(index).getColor() + 
      " " + arrayOfToys.get(index).getType();
   } else {
    toys = toys + arrayOfToys.get(index).getName() + " the " + arrayOfToys.get(index).getColor() + " " 
      + arrayOfToys.get(index).getType() + ", ";
   }
  }
  return toys;
 }
}

//The toysString method uses a for loop to iterate through the ArrayList and print out all the toys, with an if statement deciding whether
//or not a comma should be utilized after the toy has been printed (comma used if not the last toy)