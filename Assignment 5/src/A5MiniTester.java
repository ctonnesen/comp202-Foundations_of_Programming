import java.lang.reflect.*;
import java.util.*;

public class A5MiniTester
{
   public static void main (String[] args )
   {      
      Method[] methodsQ1 = Toy.class.getDeclaredMethods(); //gather all the methods
      Method[] methodsQ2 = Tamagotchi.class.getDeclaredMethods();
      Method[] methodsQ3 = FileIO.class.getDeclaredMethods();
      
      Constructor[] constrQ1 = Toy.class.getConstructors(); //gather all the constructors if overloaded, usually just 1
      Constructor[] constrQ2 = Tamagotchi.class.getConstructors();
      
      ArrayList< String > studentMethodsQ1 = new ArrayList< String >();
      ArrayList< String > correctMethodsQ1 = new ArrayList< String >( Arrays.asList(
      "public java.lang.String Toy.toString()",
      "public java.lang.String Toy.getName()",
      "public java.lang.String Toy.getType()",
      "public int Toy.getXp()",
      "public java.lang.String Toy.getColor()",
      "public Toy Toy.createToy(java.lang.String)",
      "public Toy Toy.findBestToy(java.util.ArrayList)" ) );
      
      
      ArrayList< String > studentConstrQ1 = new ArrayList< String >();
      ArrayList< String > correctConstrQ1 = new ArrayList< String >( Arrays.asList( 
      "public Toy()",
      "public Toy(java.lang.String,java.lang.String,java.lang.String,int)" ) );
      
      ArrayList< String > studentMethodsQ2 = new ArrayList< String >();
      ArrayList< String > correctMethodsQ2 = new ArrayList< String >( Arrays.asList(
      "public java.lang.String Tamagotchi.toString()",
      "public java.lang.String Tamagotchi.getName()",
      "public void Tamagotchi.sleep()",
      "public int Tamagotchi.getXp()",
      "public int Tamagotchi.getLevel()",
      "public double Tamagotchi.getEnergy()",
      "public int Tamagotchi.getNumOfMeals()",
      "public java.util.ArrayList Tamagotchi.getToys()",
      "public void Tamagotchi.play(int)",
      "public void Tamagotchi.feed()",
      "private void Tamagotchi.levelUp()" ) );
     
      ArrayList< String > studentConstrQ2 = new ArrayList< String >();
      ArrayList< String > correctConstrQ2 = new ArrayList< String >( Arrays.asList( 
      "public Tamagotchi(java.lang.String,int,double,int,int,java.util.ArrayList)",
      "public Tamagotchi(java.lang.String)" ) );
      
      ArrayList< String > studentMethodsQ3 = new ArrayList< String >();
      ArrayList< String > correctMethodsQ3 = new ArrayList< String >( Arrays.asList(
      "private java.util.ArrayList FileIO.loadToys(java.lang.String) throws java.io.IOException",
      "private boolean FileIO.saveToys(java.util.ArrayList,java.lang.String)",
      "public Tamagotchi FileIO.loadTamagotchi(java.lang.String) throws java.io.IOException",
      "public boolean FileIO.saveTamagotchi(Tamagotchi,java.lang.String,java.lang.String)" ) );
      

      //convert Method objects to String
      for( Method method : methodsQ1 ) studentMethodsQ1.add ( method.toString() ); 
      for( Method method : methodsQ2 ){ method.setAccessible(true); studentMethodsQ2.add ( method.toString() ); }
      for( Method method : methodsQ3 ){ method.setAccessible(true); studentMethodsQ3.add ( method.toString() ); }
      
      //convert Constructor objects to String
      for( Constructor constr : constrQ1 ) studentConstrQ1.add ( constr.toString() );
      for( Constructor constr : constrQ2 ) studentConstrQ2.add ( constr.toString() );

      //for( String s : studentMethodsQ3 ) System.out.println( s );
      
      removeStaticKeyword( studentMethodsQ1 );
      removeStaticKeyword( studentMethodsQ2 );
      removeStaticKeyword( studentMethodsQ3 );
      
      System.out.println( "TESTING TOY CLASS..." );
      evaluate( correctConstrQ1,studentConstrQ1,true );
      evaluate( correctMethodsQ1,studentMethodsQ1,false );
      
      System.out.println();
      
      System.out.println( "TESTING TAMAGOTCHI CLASS..." );
      evaluate( correctConstrQ2,studentConstrQ2,true );
      evaluate( correctMethodsQ2,studentMethodsQ2,false );
      
      System.out.println();
      
      System.out.println( "TESTING FILEIO CLASS..." );
      
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