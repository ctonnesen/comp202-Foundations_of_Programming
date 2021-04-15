// Christian Tonnesen
// ID: 260847409


// A program to analyze three different inputs and evaluate them based upon specific properties, including negativity, eveness, and decreasing order.

public class InputAnalyzer {
  public static void main(String[] args){
    double firstInput = Double.parseDouble(args[0]);
    double secondInput = Double.parseDouble(args[1]);
    double thirdInput = Double.parseDouble(args[2]);
    
    //All three inputs are initialized as doubles and named accordingly
    
    //The main method in this program is a shell for 5 other methods listed below this comment line. The compiler will execute them in the order as listed, with the three inputs present in each one.
    
    nonNegativeMethod (firstInput, secondInput, thirdInput);
    evenNumberMethod (firstInput, secondInput, thirdInput);
    descendingOrderMethod (firstInput, secondInput, thirdInput);
    nonNegativeAndDescendingMethod (firstInput, secondInput, thirdInput);
    nonNegativeAndOddNumberMethod (firstInput, secondInput, thirdInput);
  }
  
  // This first method is responsible for detecting if any of the inputs are negative numbers, hence "nonNegativeMethod"
  
  public static void nonNegativeMethod(double firstInput, double secondInput, double thirdInput){
    boolean nonNegative = (firstInput>0)&&(secondInput>0)&&(thirdInput>0);
    
    // The boolean above checks to see if all of the inputs are greater than zero, linking them with && so that all must be true in order to render the boolean true 
    
    if (nonNegative == true) {
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are all non-negative: true" );
    } else {
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are all non-negative: false" );
    
      // If the boolean is true, the method prints that all three inputs are non-negative, while if the boolean is false, then the conditional dictates that the program print that inputs are not
      // non-negative.
      // This "boolean, conditional, then print statement" is essentially the format of all the methods and I will therefore only comment on what is different in the booleans' functionalities. 
    
    }
  }
  
  // This second method is responsible for finding out if at least one of the inputs is even
  
  public static void evenNumberMethod (double firstInput, double secondInput, double thirdInput){
    boolean evenNumber = (firstInput%2==0)||(secondInput%2==0)||(thirdInput%2==0);
    
    // The format of this method is the same as the one above, except checking this time for if the inputs are divisble by 2 with no remainder. However, only one number must be even to satisfy the 
    // Assignment directions, meaning I used || as only one must be true to render the entire boolean true.
    
    if (evenNumber == true) {
      System.out.println("At least one between " + firstInput + ", " + secondInput + ", and " + thirdInput + " is even: true" );
    } else {
      System.out.println("At least one between " + firstInput + ", " + secondInput + ", and " + thirdInput + " is even: false" );
    }
  } 
  
  
  // The third method checks if the inputs are entered in a strictly descending order 
  
  public static void descendingOrderMethod (double firstInput, double secondInput, double thirdInput){
    boolean descendingOrder = (firstInput>secondInput)&&(secondInput>thirdInput);
    
    // The boolean for this method is pretty straightforward, as, for it to be true, the first input must be larger than the second, with the second being simultaneously larger than the third.
    // This was achieved through the ">" relational operator. Since it is strictly descenfing, && was used to ensure that Input 1 > Input 2 AND Input 2 > Input 3.
    
    if (descendingOrder == true) {
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are in a strictly descending order: true" );
    } else {
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are in a strictly descending order: false" );
    }
  } 
  
  // The fourth method checks if the inputs are all non-negative or in a strictly decreasing order
  
  public static void nonNegativeAndDescendingMethod (double firstInput, double secondInput, double thirdInput){
    boolean nonNegative = (firstInput>0)&&(secondInput>0)&&(thirdInput>0);
    boolean descendingOrder = (firstInput>secondInput)&&(secondInput>thirdInput);
    
    // Two booleans are used here and are exact copies of the ones found in nonNegativeMethod and descendingOrderMethod as both conditions must be evaluated
    
    if ((nonNegative || descendingOrder) == true) {
      
      // Since this set of properties is an OR statement, we can use || to denote that only one of the booleans must be true to display as such
      
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are either all non-negative or in a strictly decreasing order: true");
    } else {
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are either all non-negative or in a strictly decreasing order: false");
    }
  } 
  
 // The final method checks that all of the inputs are non-negative and that none of them are even numbers
  
  public static void nonNegativeAndOddNumberMethod (double firstInput, double secondInput, double thirdInput){
    boolean nonNegative = (firstInput>0)&&(secondInput>0)&&(thirdInput>0);
    boolean oddNumber = (firstInput%2>0)&&(secondInput%2>0)&&(thirdInput%2>0);
    
    // Again, like nonNegativeAndDescendingMethod before, we have to conditions to evluate and therefore two booleans. The first one is a copy of the one present in nonNegativeMethod, while the second
    // is a modified version of the one in evenNumberMethod. This time, it seeks to ensure that all the inputs have a remainder when divided by two. If both booleans are true, then the condition 
    // evluates as true.
    
    if (nonNegative && oddNumber == true){
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are all non-negative numbers and none of them is even: true");
    } else {
      System.out.println("The numbers " + firstInput + ", " + secondInput + ", and " + thirdInput + " are all non-negative numbers and none of them is even: false");
    }
  }
}
