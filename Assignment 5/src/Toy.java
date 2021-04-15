// Name: Christian Tonnesen
// ID: 260847409

import java.util.ArrayList;
import java.util.Random;

public class Toy {
 private static String[] names = {"Bob", "Penny", "Fisher", "Snoopy", "Garfield", "Mary", "Chuchu", "Trooper", "Lovebug", "Bella"};
 private static String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
 private static String[] types = {"car", "doll", "stuffed cat", "train", "ball", "kite", "teddy bear", "trike"};
 private String name;
 private String color;
 private String type;
 private int experience;
 private static Random r = new Random();
 
// The private variables are declared above and are the attributes of the Toy type

 public Toy (String name, String color, String type, int experience) {
  this.name = name;
  this.color = color;
  this.type = type;
  this.experience = experience;
 }

 public Toy () {
  this.name = getRandomName();
  this.color = getRandomColor();
  this.type = getRandomType();
  this.experience = (r.nextInt(15)+10);
 }
 
// Two toy constructors are created, one that creates a toy when supplied with the attributes, and one that creates a random object
 
 public static void main (String[] args) {
 }

 private static String getRandomName() {
  int i = r.nextInt(names.length);
  return names[i];
 }

 private static String getRandomColor() {
  int i = r.nextInt(colors.length);
  return colors[i];
 }

 private static String getRandomType() {
  int i = r.nextInt(types.length);
  return types[i];
 }

// The three above methods retrieve random values of name, color, and type for the second constructor
 
 public String getName() {
  return name;
 }

 public String getColor() {
  return color;
 }

 public String getType() {
  return type;
 }

 public int getXp() {
  return experience;
 }

 public String toString() {
  return (getName() + " the " + getColor() + " " + getType());
 }

 public static Toy createToy (String information) {
  String[] toyStats = information.split("\t");
  for (int index = 0; index < toyStats.length; index++) {
   toyStats[index].trim();
  }
  if (!(toyStats.length == 4)) {
   throw new IllegalArgumentException ("Not enough information");
  }
  Toy newToy = new Toy(toyStats[0], toyStats[1], toyStats[2], Integer.parseInt(toyStats[3]));
  return newToy;
  }
  
//  The create toy method first creates an array of String type that takes in the information String, delimiting with the \t
//  string function to split it up. This uses the first Toy constructor to create a toy
 

 public static Toy findBestToy (ArrayList<Toy> arrayOfToys) {
  if (arrayOfToys.isEmpty()) {
   return null;
  }
  int highestXpIndex = 0;
  int highestXp = (arrayOfToys.get(0)).getXp();
  for (int index = 0; index < arrayOfToys.size(); index++) {
   if (arrayOfToys.get(index).getXp() > highestXp) {
    highestXp = arrayOfToys.get(index).getXp(); 
    highestXpIndex = index;
   }
  }
  return arrayOfToys.get(highestXpIndex);     
 }
 
// This method checks if there are no toys, and if so, returns null. A new variable for the index of the highestXp in the array is 
// created and a for loop iterates through the toy array to see which one has the highest Xp. Wherever said index is, it is saved by the
// int variable and used to return the highestXp toy
 
 
}
