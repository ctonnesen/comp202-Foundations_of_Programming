import java.lang.reflect.*;
import java.util.*;

public class A4MiniTester
{
   public static void main( String[] args )
   {      
      Method[] methodsQ1 = GameOfLife.class.getDeclaredMethods(); //gather all the methods
      Method[] methodsQ2 = Card.class.getDeclaredMethods();
      Method[] methodsQ3 = Deck.class.getDeclaredMethods();
      
      Constructor[] constrQ2 = Card.class.getConstructors(); //gather all the contructors if overloaded, usually just 1
      Constructor[] constrQ3 = Deck.class.getConstructors();
      
      ArrayList< String > studentMethodsQ1 = new ArrayList< String >();
      ArrayList< String > correctMethodsQ1 = new ArrayList< String >( Arrays.asList(
      //"public static void GameOfLife.main(java.lang.String[])",
      "public boolean GameOfLife.isValidUniverse(int[][])",
      "public void GameOfLife.displayUniverse(int[][])",
      "public int GameOfLife.getNextGenCell(int[][],int,int)",
      "public int[][] GameOfLife.getNextGenUniverse(int[][])",
      "public void GameOfLife.simulateNGenerations(int[][],int)" ) );
      
      
      ArrayList< String > studentConstrQ2 = new ArrayList< String >();
      ArrayList< String > correctConstrQ2 = new ArrayList< String >( Arrays.asList( "public Card(int,java.lang.String)" ) );
      
      ArrayList< String > studentMethodsQ2 = new ArrayList< String >();
      ArrayList< String > correctMethodsQ2 = new ArrayList< String >( Arrays.asList(
      "public int Card.getValue()",
      "public java.lang.String Card.getSuit()" ) );
     
      ArrayList< String > studentConstrQ3 = new ArrayList< String >();
      ArrayList< String > correctConstrQ3 = new ArrayList< String >( Arrays.asList( "public Deck()" ) );
      
      ArrayList< String > studentMethodsQ3 = new ArrayList< String >();
      ArrayList< String > correctMethodsQ3 = new ArrayList< String >( Arrays.asList(
      "public int Deck.getNumOfCards()",
      "public Card[] Deck.getCards()",
      "public void Deck.showCards()",
      "public Card Deck.deal()",
      "public Card Deck.pickACard(int)",
      "public void Deck.restockDeck()",
      "public void Deck.shuffle()" ) );
      

      //convert Method objects to String
      for( Method method : methodsQ1 ) studentMethodsQ1.add ( method.toString() ); 
      for( Method method : methodsQ2 ) studentMethodsQ2.add ( method.toString() ); 
      for( Method method : methodsQ3 ) studentMethodsQ3.add ( method.toString() );
      
      //convert Constructor objects to String
      for( Constructor constr : constrQ2 ) studentConstrQ2.add ( constr.toString() );
      for( Constructor constr : constrQ3 ) studentConstrQ3.add ( constr.toString() );

      //for( String s : studentMethodsQ3 ) System.out.println( s );
      removeStaticKeyword( studentMethodsQ1 );
      removeStaticKeyword( studentMethodsQ2 );
      removeStaticKeyword( studentMethodsQ3 );
      
      System.out.println( "TESTING GAME OF LIFE CLASS..." );
      evaluate( correctMethodsQ1,studentMethodsQ1,false );
      
      System.out.println();
      
      System.out.println( "TESTING CARD CLASS..." );
      evaluate( correctConstrQ2,studentConstrQ2,true );
      evaluate( correctMethodsQ2,studentMethodsQ2,false );
      
      System.out.println();
      
      System.out.println( "TESTING DECK CLASS..." );
      evaluate( correctConstrQ3,studentConstrQ3,true );
      evaluate( correctMethodsQ3,studentMethodsQ3,false );
   }
   
   public static void evaluate( ArrayList< String > correct,ArrayList< String > student,boolean constr )
   {
      boolean match = true; //if everything passes
      
      for( int i = 0; i < correct.size(); i++ ) //we only care about testable methods
      {
         if( !student.contains( correct.get( i ) ) ) //signature cannot be found
         {
            if( constr )
            {
               System.out.println( "Error with constructor: " + correct.get( i ) );
               System.out.println( "Constructor cannot be found or has wrong signature.\n" );
            }
            else
            {
               System.out.println( "Error with method: " + correct.get( i ) );
               System.out.println( "Method cannot be found or has wrong signature.\n" );
            }
            match = false;
         }
      }
      
      if( match )
      { 
         if( constr ) System.out.println( "Constructor has been found!" ); 
         else System.out.println( "All methods have been found!" );
      }
   }
   
   public static void removeStaticKeyword( ArrayList< String > arr )
   {
      for( int i = 0; i < arr.size(); i++ )
      {
         String[] tokens = arr.get( i ).split( " " ); //tokenize based on space delimiter
         
         String answer = ""; //build the answer from empty string
         
         for( int j = 0; j < tokens.length; j++ )
         {
            if( !tokens[ j ].equals( "static" ) ) answer += ( tokens[ j ] + ( j == tokens.length - 1 ? "" : " " ) ); //also add spaces
         }
         arr.remove( i ); //replace the string in place
         arr.add( i,answer );
         //System.out.println( Arrays.toString( tokens ) );
      }
   }
}