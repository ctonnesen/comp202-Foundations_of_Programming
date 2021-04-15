public class PracticeLoops {
  public static void main(String[] args) {
    printLine('$', 8); 
    isPrime (5);
  }
  public static void printLine (char symbol, int n) {
    // int x = 0;
    // while (x < n) {
    // System.out.println(symbol);
    // x++;
    
    for (int count = 0; count < n; count++){
      System.out.println(symbol);
    }
    System.out.println();
  }
  public static boolean isPrime (int n) {
    int div = 2;
    while (div < n) {
      if (int%div==0) {
        return false;
        div++;
      }
    }
  }
}