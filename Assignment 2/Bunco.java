/* Christian Tonnesen
 * 260847409
 */

public class Bunco {
  public static void main(String[] args) { 
    String player1 = args [0];
    String player2 = args [1];
    playBunco(player1, player2); 
  }
  
  /* The main method takes in both the names of the players and simulates
   * a game of Bunco, taking their names as inputs 
   */
  
  public static int diceRoll () {
    int diceR = (int)(Math.random()*6)+1;
    return diceR;
  }
  
  /* The method generates a random number between 0 and 1, multiplies it by six,
   * then adds 1 to the value in order to create a random number between 1 and 6 
   */
  
  public static int getScore (int diceR1, int diceR2, int diceR3, int roundNumber) { 
    int scoreRunning = 0;
    boolean scoreBunco = (diceR1==diceR2&&diceR2==diceR3&&diceR3==roundNumber);
    boolean scoreMiniBunco = (diceR1==diceR2&&diceR2==diceR3);
    if (scoreBunco == true) {
      return 21;
    }
    if (scoreMiniBunco == true) {
      return 5;
    }
    
    /* The above conditions account for the possibility that a Bunco or miniBunco
     * could be rolled, and, since rolling either will end mean all the dice must match,
     * the value is returned. This is evaulated through booleans.
     */
    
    if (diceR1 == roundNumber) {
      scoreRunning = scoreRunning + 1;
    }
    if (diceR2 == roundNumber) {
      scoreRunning = scoreRunning + 1;
    }
    if (diceR3 == roundNumber) {
      scoreRunning = scoreRunning + 1;
    }
    return scoreRunning;
  }
  
  /* The rest of the above method simply accounts for if any of the dice rolls match
   * the round number, then points are added to running score, which are returned
   * at the end. 
   */
  
  public static int playOneRound(String player, int roundNumber) {
    boolean roundChecker = (roundNumber>=1 && roundNumber<=6);
    if (roundChecker == true) {
      int diceR1 = diceRoll ();
      int diceR2 = diceRoll ();
      int diceR3 = diceRoll ();
      int roundPoints = getScore (diceR1, diceR2, diceR3, roundNumber);
      System.out.println (player + " rolled " + diceR1 + " " + diceR2 + " " + diceR3 + " and scored " + roundPoints + " points"); 
      return roundPoints; 
    }
    
    /* The portion of the above method (playOneRound) first checks that the round number
     * is between 1 and 6, or else a -1 is returned. Then, it calls the diceRoll method
      and assigns the three dice rolls to variables. Finally, the getScore method is called
      in order to calculate the points for the round and a print statement is made.
      The method returns the round points for tallying later on
      */
    
    else {
      System.out.println ("The input was not valid.");
      return -1;
    }   
  }
  
  public static void playBunco(String player1, String player2) {
    int roundNumber = 1;
    int player1TotalScore = 0;
    int player2TotalScore= 0;
    
    /* The round number and player score are initialized in the beginning so
     * they can be recognized outside of the loop they are about to enter
     * */
    
    while (roundNumber <= 6) {
      System.out.println ("ROUND #:" + roundNumber);
      System.out.println();
      int roundPoints1 = playOneRound (player1, roundNumber);
      player1TotalScore = roundPoints1 + player1TotalScore;
      
      /* A while loop ensures the round number never goes over 6, and the next two lines
       * print out the round number and a line space. The variable "roundOnePoints" is
       * initialized to count up the points of each round. The player1TotalScore then takes the
       * points of said round and adds them to the previous rounds
       */
      
      int roundPoints2 = playOneRound (player2, roundNumber);
      player2TotalScore = roundPoints2 + player2TotalScore;
      
      /* The same process as before is used to calculate the points for player 2
       * */
      
      System.out.println();
      System.out.println (player1 + "'s score after round " + roundNumber + " is " + player1TotalScore);
      System.out.println (player2 + "'s score after round " + roundNumber + " is " + player2TotalScore);
      System.out.println ("-----------------------------------------------");
      roundNumber++;
    }
    
    /* The rest of the loop prints out the points for each round and the overall
     * points per player, plus a printed line of dashes to seperate round declaration.
     * The final line of the rest of the loop increases the round number by one.
     */
    
    System.out.println();
    if (player1TotalScore > player2TotalScore) {
      System.out.println (player1 + " wins!");
    }
    if (player1TotalScore < player2TotalScore) {
      System.out.println (player2 + " wins!");
    }
    if (player1TotalScore == player2TotalScore) {
      System.out.println ("Everyone's a winner! It's a tie!");
    } 
  }
  
  /* The rest of the method uses if statements to decide who won the game, comparing the 
   * total points of each player after 6 rounds. It prints out a statement declaring the winner
   * and will declare a tie in the event of such.
   */
}
