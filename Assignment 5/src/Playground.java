// Name: Christian Tonnesen
// ID: 260847409

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Playground {
 public static void main (String[] args) {
  play();
 }

 public static void play () {
  Scanner input = new Scanner(System.in);
  System.out.println("Welcome to the game!");
  System.out.println("Please enter the name of the Tamagotchi you'd like to play with:");
  String name = input.nextLine();
  String fileName = (name.toLowerCase() + ".txt");
  String toyFile = (name.toLowerCase() + "Toys");
  Tamagotchi tama = new Tamagotchi(name);
  
//  A Scanner object is created and accepts the name of the Tamagotchi. This is used to create the fileName and toyFile, as well as created the Tamagotchi
  
  try {
   tama = FileIO.loadTamagotchi(fileName);
  } catch (IOException e){
   System.out.println("File has not been found");
   tama = new Tamagotchi(name);
   System.out.println("Your Tamagotchi has been created");
  }
  
//  The method attempts to load the file of said Tamagotchi and in the event that it doesn't exist, the IOException is caught and a new
//  Tamagotchi is created with its name
  
  System.out.println();
  System.out.println("Tamagotchi Card");
  System.out.println(tama.toString());
  System.out.println();
  System.out.println("Enter a command (play, feed, or sleep):");
  String command = input.nextLine();
  
//  The first command is taken in using the scanner
  
  while (!(command.equalsIgnoreCase("sleep"))) {
   commandCenter(tama, command, name, input);
   System.out.println("Enter the next command:");
   command = input.nextLine();
  }
  
//  A while loop sends the Tamagotchi, command, name of the Tamagotchi, and Scanner to the commandCenter method to decide what Tamagotchi method
//  should be called. Once the command is executed, the loop asks for the next command, takes another input, and sets that input equal to the command
//  variable for the next iteration of the loop
  
  System.out.println();
  tama.sleep();
  FileIO.saveTamagotchi(tama, fileName, toyFile);
  input.close();
 }
 
// If "sleep" is passed into the Scanner, then the loop is exitied, the sleep method is called, and the Tamagotchi is saved
 

 private static void commandCenter (Tamagotchi tama, String command, String name, Scanner input) {
  try {
   if (command.equalsIgnoreCase("play")) {
    System.out.println();
    playPlayground(tama, name, input);
    System.out.println();
   
//   If the command String equals "play", then then the Tamagotchi, name, and Scanner is sent to the playPlayground method
   
   } else {
    if (command.equalsIgnoreCase("feed")){
     System.out.println();
     tama.feed();
     System.out.println();
     
//     If the command is not "play", then the else statement checks if the command is equal to "feed". If so, then the feed method is called.
     
    } else {
     System.out.println();
     System.out.println("The command was not recognized");
     System.out.println();
     
//     If the command is neither play nor feed, then the console prints that the command was not recognized
     
    }
   }
  } catch (IllegalStateException e) {
   System.out.println();
   
   System.out.println(e.getMessage());
   System.out.println();
  } catch (NumberFormatException e) {
   System.out.println();
   System.out.println("Please enter an integer");
   System.out.println();
  } catch (InputMismatchException e) {
   System.out.println();
   System.out.println("Please enter an integer");
   System.out.println();
  }
 }
 
// The last few lines of the method check for any exceptions and print the corresponding information

 private static void playPlayground (Tamagotchi tama, String name, Scanner playInput){
  System.out.println("Choose one of the following options:");
  System.out.println("1) " + name + " plays with their best toy");
  System.out.println("2) " + name + " plays with a random toy");
  int playType = Integer.parseInt(playInput.nextLine());
  tama.play(playType);
 } 
}

//The system prints out messages prompting the player to choose between option 1 or 2. The Scanner object is called again and 
//takes the input of the line. This input is turned into an int and passed to the play method in the Tamagotchi class.