// Christian Tonnesen
// 260847409

public class PizzaCalc {
  public static void main(String[] args) {
    int modeSelect = Integer.parseInt(args[0]);
    
    // This int is the first input to the system and decides whether or not the program will execute the Quantity or Price mode later on.
    
    boolean validMode = ((modeSelect == 1)||(modeSelect == 2));
    
    // Since we must account for if someone doesnt use 1 or 2 as inputs, a boolean variable of validMode was created to ensure that if the previous modeSelect variable wasn't explicitly 1 or 2,
    // the conditional would skip the rest of the calculator and just execute the "else" print statement
    
    if (validMode == true) {
      if (modeSelect == 1 ) {
        int qmSizeLarge = Integer.parseInt(args[1]);
        int qmSizeSmall = Integer.parseInt(args[2]);
        quantityModeMethod (qmSizeLarge, qmSizeSmall);}
      
      // Assuming 1 has been passed as the first input, the next two inputs for the size of the large and small pizzas
      // are initialized as integer variables qmSizeLarge and qmSizeSmall, respectively. We end it by calling the quantityModeMethod.
      
      if (modeSelect == 2) {
        int pmSizeLarge = Integer.parseInt(args[1]);
        double pmPriceLarge = Double.parseDouble(args[2]);
        int pmSizeSmall = Integer.parseInt(args[3]);
        int pmSmallOrders = Integer.parseInt(args[4]);
        priceModeMethod (pmSizeLarge, pmPriceLarge, pmSizeSmall, pmSmallOrders);
      
      // Assuming 2 has been passed as the first input, the next four inputs for the size of the large pizza, price of the large pizza, size of the small pizza, and 
      // amount of small pizzas ordered. We end it by calling the priceModeMethod.
      
      }} 
    else {
      System.out.println("The given mode is not supported");
    
      // The above statement is what the program print when neither 1 or 2 has been provided as a first input
    
    }
  }
  
  // This first method accounts for the all of the functions in the quantity mode
  
  public static void quantityModeMethod (int qmSizeLarge, int qmSizeSmall){
    System.out.println ("You selected \"Quantity Mode\".");
    System.out.println ("The diameter of the large pizza is " + qmSizeLarge + " inches.");
    System.out.println ("The diameter of the small pizza is " + qmSizeSmall + " inches.");
    
    // The three above statements print out the second and third inputs when in Quantity Mode. The next lines are responsible for calculating the
    // how many small pizzas should be ordered to match the same area as the large pizza.
    
    double sqLargeSize = Math.pow((qmSizeLarge/2),2);
    double areaLargeSize = (3.14*sqLargeSize);
    
    // The two above lines take the diameter of the large pizza, turn it into the radius, and then square it, assigning the new r^2
    // the variable name of sqLargeSize. This variable is then multiplied by pi in order to calculate the total square inches of pizza
    // for the large version
    
    double sqSmallSize = Math.pow((qmSizeSmall/2),2);
    double areaSmallSize = (3.14*sqSmallSize);
    
    // The above two lines repeat the same process from before, but with the small pizza
    
    double orderSmallPizza = (areaLargeSize/areaSmallSize);
    
    // The area of the large pizza is divided by the area of the small pizza to obtain how many small pizzas are needed to
    // be equivalent to the large area. The amont of pizzas is assigned the variable orderSmallPizza
    
    System.out.println ();
    System.out.println ("You should order " + orderSmallPizza + " small pizzas."); 
  
    // The system prints out amount of small pizzas need, completing the Quantity Mode statements
  
  }
  
  // The second method handles the price mode statements and functions
  
  public static void priceModeMethod (int pmSizeLarge, double pmPriceLarge, int pmSizeSmall, int pmSmallOrders){
    System.out.println ("You selected \"Price Mode\".");
    System.out.println ("The diameter of the large pizza is " + pmSizeLarge + " inches.");
    System.out.println ("The price of one large pizza is " +pmPriceLarge + " dollars.");
    System.out.println ("The diameter of the small pizza is " + pmSizeSmall + " inches.");
    System.out.println ("You want to buy " + pmSmallOrders + " small pizzas.");
    
    // The above println's print out all of the inputs of 1 - 4 in their repsective statements
    
    double sqLargeSize = Math.pow((pmSizeLarge/2),2);
    double areaLargeSize = (3.14*sqLargeSize);
    double sqSmallSize = Math.pow((pmSizeSmall/2),2);
    double areaSmallSize = (3.14*sqSmallSize);
    
    // The four above functions are copies of the previous set used in the quantity mode. They find the area of the large and small pizzas.
    
    double areaPrice = (pmPriceLarge/areaLargeSize);
    
    // This function above finds the square inches of area per cent of cost
    
    double fairPrice = (areaPrice*areaSmallSize*pmSmallOrders);
    
    // Finally, the square inches per cent is multiplied by the area of the small pizza and then the amount of small pizzas oredered.
    // This finds the fair price for small pizzas of similar areas to the large pizza
    
    System.out.println ();
    System.out.println ("The fair price to pay for " + pmSmallOrders + " small pizzas is " + fairPrice + " dollars.");
    
    // The method ends by printing out the final required statement of the Assignment
  
  }
}