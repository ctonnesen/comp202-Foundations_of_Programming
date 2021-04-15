
public class IsEven {
 public static void main(String[] args) {
 int x = Integer.parseInt(args[0]);
 boolean isEven = (x%2 == 0);
 if (isEven == true) {
  System.out.println(x + " is an even number");
 }
 else {
  if (x%3 == 0) {
  System.out.println(x + " is an odd number and a multiple of 3");
  } else {
  System.out.println(x + " is an odd number and not multiple of 3");
 }

}}}
