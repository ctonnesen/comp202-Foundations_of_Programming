public class Greetings
{
   private static final String defaultGreet = "hey!";
    
   public static void greet( String name )
   {
      System.out.println( "Hello " + name );
   }
   
   public void bye( String name )
   {
      System.out.println( "Bye " + name );
   }
}