import java.util.Scanner;
public class GuessIt {
  public static void main(String[] args) {
  int secret = (int) (Math.random()*100+1);
  System.out.println(secret);
  Scanner read = new Scanner(System.in);
  int guess = 0;
  int count = 0;
  while (guess != secret) {
  System.out.print("Enter your guess");
  guess = read.nextInt();
  count++;
  if (guess<secret) {
    System.out.println ("Too low!");
  } else if (guess>secret) {
    System.out.println("Too high!");
  } else System.out.println("Yay!");
}
    System.out.println("Number of Guesses: " + count);
  }
}