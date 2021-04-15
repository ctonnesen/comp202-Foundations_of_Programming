// Christian Tonnesen
// ID#: 260847409

import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

public class BullsAndCows {
  public static void main (String args[]) {
    int inputNumber = (int) (Math.random()*1000);
    playBullsAndCows (inputNumber);
  }
  
//  The above method generates a random 4 digit number and passes it to the playsBullsAndCows method
//  as a seed number to generate the secret digits
  
  public static boolean contains(int[] testedIntArray, int testedNumber) {
    for (int index = 0; index < testedIntArray.length; index++){
      if (testedIntArray[index] == testedNumber) {
        return true;
      }
    }
    return false;
  }
  
//  A for loop is used to go through the array and find if the input number matches any elements in the array
  
  public static int[] generateSecretDigits(int seedNumber) {
    Random randomGenerator = new Random(seedNumber);
    int [] secretDigits = {10,10,10,10};
    
    // The array is initialized with numbers outside of the bounds of the possible secret digits
    
    for (int index = 0; index < 4; index++) {
      int randomNumber = randomGenerator.nextInt(10);
      if (contains(secretDigits, randomNumber)){
        index--;
        continue;
        
        // In the event that the digit is already in the array, the index is reset and the attempt skipped
        
      }
      else {
        secretDigits[index] = randomNumber;
      }
    }
    return secretDigits;
  }
  
  public static int[] extractDigits(int inputNumber) {
    inputNumber = Math.abs(inputNumber);
    String digitString = "" + inputNumber;
    int digits = digitString.length();
    int [] digitArray;
    if (digits <= 4) {
      digitArray = new int[4];
    } else {
      digitArray = new int[digits];
    }
    
    // A default array is initializd at 4 digits if the input number is less than 4 digits, and is otherwise
    // initialized at the length of the digits obtained by converting the array to a string
    
    digits--;
    for (int index = digitArray.length-1; -1 < index; index--) {
      if (digits>=0){
        digitArray[index] =(Character.getNumericValue(digitString.charAt(digits--)));
      }
      
      // The for loop fills the array backwards so long as the digit is greater than or equal to zero, taking the
      // character at the int digit variable in the String digitString. This character is then converted to its
      // numeric value from the ASCII table.
      
    }
    return digitArray; 
  }
  
  public static int getNumOfBulls(int [] secretDigits, int[] playerGuess) {
    String secretDigitsString = Arrays.toString(secretDigits);
    String playerGuessString = Arrays.toString(playerGuess);
    int numOfBulls = 0;
    if (!(secretDigits.length == playerGuess.length)) {
      throw new IllegalArgumentException ("Player guess is not the correct amount of digits");
    }
    
    // The two arrays are checked to make sure they are the same length
    
    for (int index = 0; index < secretDigits.length; index++) {
      if (secretDigits[index] == playerGuess[index]) {
        numOfBulls++;
      } 
    } 
    return numOfBulls;
  }
  
  public static int getNumOfCows(int [] secretDigits, int[] playerGuess) {
    int numOfCows = 0;
    int i = 0;
    int numOfBulls = getNumOfBulls (secretDigits, playerGuess);   
    int [] bullNumbers = new int [numOfBulls];   
    for (int index = 0; index < secretDigits.length; index++) {
      if (contains(secretDigits, playerGuess[index])) {
        numOfCows++;
        
        // As a maximum, the number of cows is calculated from the contains method, to which it only decreases from
        // there
        
      }
      if (secretDigits[index] == playerGuess[index]) {
        bullNumbers[i] = secretDigits[index];
        i++;
        numOfCows--;
      }
      
      // If the specified digit of the player guess matches he secret digits, i.e. a bull, a cow is deducted and said
      // number is added to the array of "bull numbers"
      
    }
    for (int index = 0; index < secretDigits.length; index++) {
      if (contains(bullNumbers, playerGuess[index]) && secretDigits[index] != playerGuess[index]) {
        numOfCows--;
      }
      
      // If contains() is true and the number is also within the bull number array, then another cow is minused since it
      // is double counted
        
    }
    if (!(secretDigits.length == playerGuess.length)) {
      throw new IllegalArgumentException ("Player guess is not the correct amount of digits");  
    }  
    return numOfCows;
  }
  
  public static void playBullsAndCows (int seed) {
    Scanner playerGuessInput = new Scanner(System.in);
    int playerGuessInteger;
    int [] playerGuess = new int [4];
    int [] secretDigits = generateSecretDigits(seed);
    int guessNumber = 1;
    System.out.println ("Hi there! Want to play a game?");
    System.out.println ("Can you crack the code?");
    System.out.println();
    
    // The above lines prepare the opening statements and intialized the round/guess number at 1
    
    while (getNumOfBulls (secretDigits, playerGuess) != 4) {
      System.out.println("Guess #" + guessNumber + ". Enter a four digit number: ");
      playerGuessInteger = playerGuessInput.nextInt();
      if ((playerGuessInteger < 0) || (playerGuessInteger > 9999)) {
        
        // Stops the number from being negative or more than 5 digits
        
        System.out.println("You wasted your guess! Please enter a positive integer with at most 4 digits.");
        if(guessNumber >= 5) {
          System.out.println();
          System.out.println("Might be time for you to take a break. Do you want to quit? (y/n)");
          Scanner yesOrNo = new Scanner(System.in);
          String yOrN = yesOrNo.nextLine();
          if (yOrN.equalsIgnoreCase("y")) {
            System.out.println();
            System.out.println ("You gave up after " + guessNumber + " guesses.");
            return;
          } else {
            guessNumber++;
            System.out.println();
            continue;
          }
        }
        
//        Checks for a wasted guess, and then also checks if the wasted guess was 5 or more, executing the quit statement
//        if so
        
        System.out.println();
        guessNumber++;
        continue;
      }
      playerGuess = extractDigits(playerGuessInteger);
      if (getNumOfBulls (secretDigits, playerGuess) == 4) {
        break;
      }
      
      // If 4 bulls, then the loop is exited and proceeds to the win statement
      
      System.out.print("Bulls: " + getNumOfBulls(secretDigits, playerGuess) + ","); 
      System.out.print(" Cows: " + getNumOfCows(secretDigits, playerGuess));
      System.out.println();
      System.out.println();
      
      // Shows the score at the end of the guess
      
      if (guessNumber >= 5) {
        System.out.println("Might be time for you to take a break. Do you want to quit? (y/n)");
        Scanner yesOrNo = new Scanner(System.in);
        String yOrN = yesOrNo.nextLine();
        if (yOrN.equalsIgnoreCase("y")) {
          System.out.println();
          System.out.println ("You gave up after " + guessNumber + " guesses.");
          return;
        } else {
          System.out.println();
        }
      }
      guessNumber++;
    }
    
    // Checks if the guess is 5 or more and asks if the player wants to quit. If so, a print statement is executed and
    // the following return statement ends the method
    
    System.out.println();
    System.out.println("Congratulations! You guessed the secret number in only " + guessNumber + " guesses.");  
  }
}





