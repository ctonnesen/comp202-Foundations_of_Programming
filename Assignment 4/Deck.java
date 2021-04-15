// Christian Tonnesen
// 260847409

import java.util.Arrays;
import java.util.Random;

public class Deck {
  private Card [] cardDeck;
  private int cardsLeft = 52;
  private static Random numberGenerator = new Random(123);
  
  // The private attributes are initialized above, including the seeded Random object
  
  public Deck () {
    int arrayPlace = 51;
    cardDeck = new Card [52];
    String [] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
    for (int index = 0; index < suits.length; index++) {
      for (int i = 1; i < 14; i++) {
        cardDeck [arrayPlace] = new Card (i, suits[index]);
        arrayPlace--;
      }
    }
  }
  
  // The constructor initializes the cardDeck at a size of 52 and populates it backwards (or from the top of the deck 
  // down) with all of the cards
  
  public static void main(String args[]) {   
 }
  
  public int getNumOfCards () {
    return this.cardsLeft;
  }
  
  // getNumOfCards simply returns the number of cards
  
  public Card [] getCards() {
    Card [] cardDeckCopy = new Card [this.cardsLeft];
    
    // A copy of the cardDeck is made of the size of the remaining cards so that the private attribute is not directly
    // affected
    
    for (int index = 0; index < this.cardsLeft; index++) {
      cardDeckCopy [index] = cardDeck [index];
    }
    return cardDeckCopy;
  }
  
  public void showCards () { 
    for (int index =  this.cardsLeft-1; -1 < index; index--) {
      if (index == 0) {
        System.out.print(this.cardDeck [index].getValue() + " of " + this.cardDeck [index].getSuit() + ".");
        
//        A for loop prints out the card's value and suit. In the event of the final number in the index (0 aka the 
//        bottom of the deck), a different print statement is used with a period
        
      } else {
        System.out.print(this.cardDeck [index].getValue() + " of " + this.cardDeck [index].getSuit()+ ", ");  
      }
    } 
  }
  
  public void shuffle() {
    for (int index = 0; index < 1000; index++) {
      Card [] temp = new Card [1];
      int indice1Num = numberGenerator.nextInt(this.cardsLeft);
      int indice2Num = numberGenerator.nextInt(this.cardsLeft);
      
//      Two indices are created from the Random attribute
      
      temp[0] = cardDeck [indice1Num];
      cardDeck [indice1Num] = cardDeck [indice2Num];
      cardDeck [indice2Num] = temp[0];
    }
  }
  
  // The values of the array are swapped around using a temp value
  
  public Card deal() {
    if (this.cardsLeft == 0) {
      return null;
    }
    
//    In the event that there are no cards left, a null value is returned
    
    Card topOfDeck = cardDeck[this.cardsLeft-1];  
    this.cardsLeft--;
    return topOfDeck;
    
//    The card off of the top of the deck is returned and the amount of cards remaining is deincremented
    
  }
  
  public Card pickACard(int chosenCardNumber) {
    int arrayChosen = this.cardsLeft - 1 - chosenCardNumber;
    if ((this.cardsLeft - chosenCardNumber - 1) < 0) {
      return null;
    }
    
    // The above if statement checks that the value of cardsLeft is not 0, and that if the player chooses
    // a position not in the remaining cards, it returns null
    
    Card chosenCard = cardDeck [arrayChosen];
    this.cardsLeft--;
    
    // The chosen card is indexed from the array and the amount of cardsLeft is deincremented
    
    Card [] copyDeck = new Card [52];
    int index;
    boolean cardOut = false;
    int arrayCounter = 0;
    
    // A copy deck is created to clone the cardDeck and a boolean is made to see whether or not the picked card has
    // been removed
    
    for (index = 0; index < 52; index++) {
          boolean cardChecker =(cardDeck [arrayChosen] == cardDeck[index]);
          
          // A second boolean checks if the indexed card is the picked one or not
          
      if (cardChecker == true) {
        cardOut = true;
        copyDeck[51] = cardDeck[index];
      }
      
      // The above if statement checks if the indexed card is the picked one, and, if so, cardOut is set to true
      // and the picked card is sent to the back of the copied deck
      
      if (cardChecker == false && cardOut == true) {
        copyDeck[arrayCounter] = cardDeck[index];  
        arrayCounter++;
      }
      
      // The above if statement sees if the card has been moved and if so, the copyDeck is populated with the regular
      // deck's values. The first if statement ensures that the picked card is overwritten
      
      if (cardChecker == false && cardOut == false) {
        copyDeck[arrayCounter] = cardDeck[index];   
        arrayCounter++;
      }
      
      // The above if populates the copyDeck with all cards before the picked card
      
    }
    cardDeck = copyDeck;
    return chosenCard;
    
    // The cardDeck is set equal to the completed copyDeck, which is nearly an exact copy of cardDeck, except with the
    // picked card at the bottom of the deck
    
  } 
  
  public void restockDeck() {
    Deck newDeck = new Deck();
    cardDeck = newDeck.getCards();
    cardsLeft = 52;
  } 
  
  // A new object of type Deck is created, and the cardDeck attrbute is set equal to it, The cardsLeft is also reset to 
  // 52 in order to fully restock the deck
  
}
