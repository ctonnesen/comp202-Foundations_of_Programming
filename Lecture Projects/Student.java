public class Student
{
   private String name;
   private int ID;
   
   public static void greet()
   {
      System.out.println( "Hello." );
      int a;
   }
   
   public Student( String aName,int aID ){
      name = aName;
      ID = aID;
   }
   public String getName(){
      return name;
   }
   public int getID(){
      return ID;
   }
   
}