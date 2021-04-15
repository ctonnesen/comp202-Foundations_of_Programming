// a program to practice working with value methods

public class ValueMethods {
    public static void main(String[] args) {
        // test getCube()
        //System.out.println(getCube(2.0));
        double vol = getVolume(2.0);
        System.out.println(vol);
    }
    
    // a method that takes a double as input and returns the value of the
    // input cubed
    public static double getCube(double x) {
        return x*x*x;
    }
    
    // a method that takes the radius of a sphere as input
    // and returns the value of the volume of such sphere
    public static double getVolume(double radius) {
        // compute the volume of the sphere 4/3pi*r^3
        double volume = 4.0/3.0*Math.PI*getCube(radius);
        return volume;
    }
   
    public static void testReturn () {
      
      
}
}