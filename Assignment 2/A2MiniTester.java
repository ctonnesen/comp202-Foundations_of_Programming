import java.lang.reflect.Method;
import java.util.*;

public class A2MiniTester
{
   public static void main( String[] args )
   {      
      Method[] methodsBunco = Bunco.class.getDeclaredMethods(); //gather all the methods
      Method[] methodsEmail = EmailValidation.class.getDeclaredMethods();
      
      ArrayList< String > studentAnswersBunco = new ArrayList< String >();
      ArrayList< String > correctAnswersBunco = new ArrayList< String >( Arrays.asList(
      //"private static void Bunco.displayRolls(java.lang.String,int,int,int)",
      //"private static void Bunco.displayScore(int)",
      "public static int Bunco.diceRoll()",
      "public static int Bunco.getScore(int,int,int,int)",
      "public static int Bunco.playOneRound(java.lang.String,int)",
      //"public static void Bunco.main(java.lang.String[])",
      "public static void Bunco.playBunco(java.lang.String,java.lang.String)" ) );
      
      ArrayList< String > studentAnswersEmail = new ArrayList< String >();
      ArrayList< String > correctAnswersEmail = new ArrayList< String >( Arrays.asList(
      //"public static void EmailValidation.main(java.lang.String[])",
      "public static boolean EmailValidation.isAlphanumeric(char)",
      "public static boolean EmailValidation.isValidPrefixChar(char)",
      "public static boolean EmailValidation.isValidDomainChar(char)",
      "public static boolean EmailValidation.exactlyOneAt(java.lang.String)",
      "public static java.lang.String EmailValidation.getPrefix(java.lang.String)",
      "public static java.lang.String EmailValidation.getDomain(java.lang.String)",
      "public static boolean EmailValidation.isValidPrefix(java.lang.String)",
      "public static boolean EmailValidation.isValidDomain(java.lang.String)",
      "public static boolean EmailValidation.isValidEmail(java.lang.String)" ) );
      
      
      for( Method method : methodsBunco ) //convert Method objects to string
            studentAnswersBunco.add ( method.toString() );
      
      for( Method method : methodsEmail )
            studentAnswersEmail.add ( method.toString() ); 
            
      //for( String s : studentAnswersEmail ) System.out.println( s );
      
      System.out.println( "TESTING BUNCO CLASS..." );
      evaluate( correctAnswersBunco,studentAnswersBunco );
      
      System.out.println();
      
      System.out.println( "TESTING EMAIL VALIDATION CLASS..." );
      evaluate( correctAnswersEmail,studentAnswersEmail );
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