import java.lang.reflect.Method;
import java.util.*;

public class A3MiniTester
{
   public static void main( String[] args )
   {      
      Method[] methodsBulls = BullsAndCows.class.getDeclaredMethods(); //gather all the methods
      Method[] methodsCurves = PolynomialCurves.class.getDeclaredMethods();
      
      ArrayList< String > studentAnswersBulls = new ArrayList< String >();
      ArrayList< String > correctAnswersBulls = new ArrayList< String >( Arrays.asList(
      //"public static void BullsAndCows.main(java.lang.String[])",
      "public static boolean BullsAndCows.contains(int[],int)",
      "public static int[] BullsAndCows.generateSecretDigits(int)",
      "public static int[] BullsAndCows.extractDigits(int)",
      "public static int BullsAndCows.getNumOfBulls(int[],int[])",
      "public static int BullsAndCows.getNumOfCows(int[],int[])",
      "public static void BullsAndCows.playBullsAndCows(int)" ) );
      
      ArrayList< String > studentAnswersCurves = new ArrayList< String >();
      ArrayList< String > correctAnswersCurves = new ArrayList< String >( Arrays.asList(
      //"public static void PolynomialCurves.main(java.lang.String[])",
      "public static boolean PolynomialCurves.onCurve(int[],double[],double)",
      "public static void PolynomialCurves.verifyInput(double[],double)",
      "public static void PolynomialCurves.drawCurve(double[],double,char)" ) );
      
      
      for( Method method : methodsBulls ) //convert Method objects to string
            studentAnswersBulls.add ( method.toString() );
      
      for( Method method : methodsCurves )
            studentAnswersCurves.add ( method.toString() ); 
            
      //for( String s : studentAnswersBulls ) System.out.println( s );
      
      System.out.println( "TESTING BULLS AND COWS CLASS..." );
      evaluate( correctAnswersBulls,studentAnswersBulls );
      
      System.out.println();
      
      System.out.println( "TESTING POLYNOMIAL CURVES CLASS..." );
      evaluate( correctAnswersCurves,studentAnswersCurves );
   }
   
   public static void evaluate( ArrayList< String > correct,ArrayList< String > student )
   {
      boolean match = true; //if everything passes
      
      for( int i = 0; i < correct.size(); i++ ) //we only care about testable methods
      {
         if( !student.contains( correct.get( i ) ) ) //signature cannot be found
         {
            System.out.println( "Error with method: " + correct.get( i ) );
            System.out.println( "Method cannot be found or has wrong signature.\n" );
            match = false;
         }
      }
      
      if( match ) System.out.println( "Everything found!" );
   }
}