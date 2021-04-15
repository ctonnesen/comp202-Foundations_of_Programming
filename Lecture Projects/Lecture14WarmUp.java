import java.util.Arrays; 
public class Lecture14WarmUp {
  public static void main(String args[]) {
    int [] x = {1,2,3,4};
    int [] y = shiftUp(x);
    
    System.out.println (Arrays.toString(x));
    System.out.println (Arrays.toString(y));
  }
  public static int[] shiftUp (int[] a) {
    int [] output = new int[a.length];
    for (int i = 0; i<a.length; i++) {
      if (i == a.length-1) {
        a[i] = output[0];
      } else 
         output [1+1] = a[i];    
  }
     return output; 
}
  }