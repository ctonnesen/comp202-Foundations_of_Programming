// Name: Christian Tonnesen
// ID: 260847409

import java.io.*;
import java.util.ArrayList;

public class FileIO {
 
 public static void main (String[] args) {
 }
 
 private static ArrayList<Toy> loadToys (String fileName) throws IOException {
  FileReader fr = new FileReader(fileName);
  BufferedReader br = new BufferedReader(fr);
  String currentToy = br.readLine();
  
//  The buffer and FileReader are opened, with a new ArrayList being created below to house the loaded toys
  
  ArrayList<Toy> toys = new ArrayList<Toy>();
  try {
   while (currentToy != null){
    toys.add(Toy.createToy(currentToy));
    currentToy = br.readLine();
   }
   
//   While the current line of the file is not null, the FileReader reads it and sends it to the createToy
//   method in the Toy class
   
  } catch (IllegalArgumentException e){
   System.out.println("The format of the given file is incorrect.");
   br.close();
   fr.close();
   return (toys = new ArrayList<Toy>());
   
//   In the event of a IllegalArgumentException, an empty array is returned
   
  }
  br.close();
  fr.close();
  return toys;
 }
 
 private static boolean saveToys (ArrayList<Toy> toys, String fileName){
  try {
   FileWriter fw = new FileWriter(fileName);
   BufferedWriter bw = new BufferedWriter(fw);
   for (int index = 0; index < toys.size(); index++) {
    if (index != (toys.size()-1)) {
     String currentToy = toys.get(index).getName() + "\t" + toys.get(index).getColor() + 
       "\t" + toys.get(index).getType() + "\t" + toys.get(index).getXp();
     bw.write(currentToy);
     bw.newLine();
     
//     A for loop writes the toys to a line in the same format that the createToys method reads them. The if else conditions ensure that an extra
//     newLine is not written after the final toy
     
    } else {
     String currentToy = toys.get(index).getName() + "\t" + toys.get(index).getColor() + 
       "\t" + toys.get(index).getType() + "\t" + toys.get(index).getXp();
     bw.write(currentToy);
    }
   }
   bw.close();
   fw.close();
  } catch (IOException e) {
   System.out.println("IO Exception found!");
   return false;
   
//   In the event of an IOException, a false value is returned
   
  }
  return true;
 }

 public static Tamagotchi loadTamagotchi (String fileName) throws IOException {
  ArrayList<Toy> toys = new ArrayList<Toy>();
  FileReader fr = new FileReader(fileName);
  BufferedReader br = new BufferedReader(fr);
  String name = br.readLine();
  
//  The FileReader and BufferWriter are opened, then they begin to check the file lines. 
  
  int level = Integer.parseInt(br.readLine());
  double energy = Double.parseDouble(br.readLine());
  int experience = Integer.parseInt(br.readLine());
  int mealsEaten = Integer.parseInt(br.readLine());
  String toyfile =  br.readLine();
 
//  Each line of the file is assigned to a variable in the same order that is specified in the assignment instructions
  
  toys = loadToys(toyfile);
  br.close();
  fr.close();
  Tamagotchi loadedTam = new Tamagotchi (name, level, energy, experience, mealsEaten, toys);
  return loadedTam;
 }
 
// The toys are loaded to a new ListArray and the Tamagotchi is created using the first constructor in the Tamagotchi class

 public static boolean saveTamagotchi (Tamagotchi givenTam, String saveFile, String toyFile) {
  try {
   FileWriter fw = new FileWriter(saveFile);
   BufferedWriter bw = new BufferedWriter(fw);
   bw.write(givenTam.getName());
   bw.newLine();
   bw.write(String.valueOf(givenTam.getLevel()));
   bw.newLine();
   bw.write(String.valueOf(givenTam.getEnergy()));
   bw.newLine();
   bw.write(String.valueOf(givenTam.getXp()));
   bw.newLine();
   bw.write(String.valueOf(givenTam.getNumOfMeals()));
   
//   The values of the provided Tamagotchi are obtained by using the getAttribute methods from Tamagotchi and turned into a String
//   using the String.valueOf method. They are then written to the file.
   
   if (saveToys(givenTam.getToys(), toyFile)) {
    bw.newLine();
    bw.write(toyFile);
    
//    If saveToys returns true, then the toyFile name is written to the file
    
   } else { 
    bw.close();
    fw.close();
    throw new IOException("The toys do not belong to said file");
    
//    If saveToys returns false, then an IOException is thrown and it informs the player that the toys don't belong to the file
    
   }
   bw.close();
   fw.close();
  } catch (IOException e){
   System.out.println("IO Exception found!");
   return false;
  }
  return true;
 }
}

//The buffer is closed and in the event of an IOException, a message is printed and false is returned. If all things run correctly, then
//true is returned