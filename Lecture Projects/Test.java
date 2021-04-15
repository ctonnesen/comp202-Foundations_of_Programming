public class Test 
{
   public static void main( String[] args )
   {   
      Student s1 = new Student( "Marek",123 );
      Student s2 = new Student( "Rose",234 );
      
      System.out.println( s1.getName() + s1.getID() );
      System.out.println( s2.getName() + s2.getID() );
      Student.greet();
   }  
      
}