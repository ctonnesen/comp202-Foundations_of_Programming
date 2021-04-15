// Christian Tonnesen
// ID#: 260847409

public class PolynomialCurves {
  public static void main (String args[]) {
    double [] constant = {21};
    double [] lineOne = {1.0, 2};
    double [] lineTwo = {-2.0, 12};
    double [] parabola = {0.1, -1, -8};
    double [] cubic = {1.0/25, 0, 0.1, -1.5};
    drawCurve (parabola, 1, 'o');
  }
  
  public static boolean onCurve (int[] coordinates, double[] coefficients, double thickness) {
    int xcoord = coordinates [0];
    int ycoord = coordinates [1];
    int numOfCoefficients = coefficients.length;
    double equation = 0;
    for (int index = 0; index < numOfCoefficients; index++) {
      double placehold = coefficients[index] * Math.pow(xcoord, (numOfCoefficients-index-1));
      
      // The placehold variable holds a double value for each "term" of a coefficient and x value to the specified
      // based off of the equation in the Assignment. The equation's value for a given coordinate is then calculated
      // and assigned to the equation variable
      
      equation += placehold;
    }
    if (((ycoord - thickness) < equation) && (equation < (ycoord + thickness))) {
      return true;
    }
    
    // If the above expression holds true per the Assignment instructions, the point that was input is therefore on
    // the curve
    
    return false;
  }
  
  public static void verifyInput (double [] coefficients, double thickness) {
    if (coefficients[0] == 0) {
      throw new IllegalArgumentException ("Please input at least one coefficient in the array");
    }
    if (thickness < 0) {
      throw new IllegalArgumentException ("The thickness of the line must be a positive number");
    }
  }
  
  // The above method checks that there is at least one coefficient and that the thickness is positive
  
  public static void drawCurve(double [] coefficients, double thickness, char curveSymbol) {
    verifyInput(coefficients, thickness);
    double yIntercept = coefficients[coefficients.length-1];
    int gridPositiveExtension = 0;
    int gridNegativeExtension = 0;
    if (!((10-yIntercept)>=5)) {
      gridPositiveExtension = (int) (yIntercept-10+5);
    }
    
    // In the event that the y intercept doesn't have 5 spaces above it, then a variable of gridPositiveExtension
    // is given the value needed to put the y intercept on the graph and then give it a buffer of 5 spaces 
    
    else if(!(((yIntercept-1)+10) >= 5)) {
      gridNegativeExtension = (int) (10 + yIntercept -5);
    }
    
    // The same is done in this if conditional, except for if the y intercept is too close to the negative y bounds.
    // If so, gridNegativeExtension is assigned the negative value of how many more negative y-axis spaces are needed.
    
    char [][] grid = new char [21] [21+gridPositiveExtension + Math.abs(gridNegativeExtension)];
    
    // A multidimensional char array grid [][] is made to hold the x and y values of each point of the Cartesian plane
    // 21 is the default, but the y array length is adjusted based on how much extension is needed 
    
    for (int y = 10 + gridPositiveExtension; y > (-11 + gridNegativeExtension); y--) {
      
      // As with the grid, the for loop creates the grid as a collection of empty spaces, with the upper bound of the
      // array dictated by 10 plus whatever extension is needed, and the lower bound is calculated by adding the
      // the negative gridNegativeExtension. The default is 21 elements (10 -- 11 = 21)
      
      for (int x = -10; x < 11; x++) {
        
        // The second for loop initialized the x coordinates across the plane
        
        grid [x+10][y+10+ Math.abs(gridNegativeExtension)] = ' ';
        if (x != 0) {
          grid [x+10][y+10+ Math.abs(gridNegativeExtension)] = ' ';
        }
        
        // x and y must be boosted by 10 since we cannot index an array at a negative number
        
        if ((x == 0) && (y == 10 + gridPositiveExtension)) {
          grid [x+10][y+10+ Math.abs(gridNegativeExtension)] = '^';
        } 
        
       // The carrot top to the y-axis is made 
       
        else if ((x == 0) && (y != 10+gridPositiveExtension)) {
          grid [x+10][y+10+ Math.abs(gridNegativeExtension)] = '|';
        }
        
        // The vertical lines of the y axis are made so long as the x == 0 and its not the carrot top position
        
        if (y == 0) {
          grid [x+10][y+10+ Math.abs(gridNegativeExtension)] = '-';
          if (x == 10) {
            grid [x+10][y+10+ Math.abs(gridNegativeExtension)] = '>';
          }
          
          // The x axis is made, with the > sign showing up when the x coordinate is at its maximum
          
          if (x == 0) {
            grid [x+10][y + 10 + Math.abs(gridNegativeExtension)] = '+';
          }
          
          // The creation of the origin where x and y equal zero
          
        }
        int [] coordinates = {x, y};
        if (onCurve(coordinates, coefficients, thickness)) {
         grid [x+10][y+10+ Math.abs(gridNegativeExtension)] = curveSymbol;       
        }
        
        // The x and y values are initialzed to the coordinates array and passed to the onCurve method. If true, then
        // that coordinate character becomes the chosen curve character
        
        System.out.print(grid [x+10][y+10+ Math.abs(gridNegativeExtension)]); 
        
        // The method prints symbol at the coordinate position
        
      }
      System.out.println();
    }  
  }
}

