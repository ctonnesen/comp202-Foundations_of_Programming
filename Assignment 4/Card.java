// Christian Tonnesen
// 260847409


public class Card {
  private int value;
  private String suit;
  
  public static void main (String args[]) {
  }
    
  public Card (int value, String suit) { 
    if (value < 1 || 13 < value) {
      throw new IllegalArgumentException ("Please enter a valid card number");
    }
    
    // An exception is thrown is the value of the card is not valid
    
    if (!(suit.equalsIgnoreCase("spades") || suit.equalsIgnoreCase("hearts") || suit.equalsIgnoreCase("diamonds") || suit.equalsIgnoreCase("clubs"))) {
      throw new IllegalArgumentException ("Please enter a valid card suit");
    }
    
    // Another exception is thrown if the suit is not equal to any of the four valid ones
    
  this.value = value;
  this.suit = suit;
  }
  
  // The local values of the method are assigned to the private attributes
  
  public int getValue() {
    return value;
  }
  
  public String getSuit () {
    return suit;
  }
  
 // Using the attributes, the value and suit of the card are returned
  
}




