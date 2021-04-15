/**
 * Auto Generated Java Class.
 */
public class Multiples {
    
    
    public static void main(String[] args) { 
        printMultTable(5,15);
    }
    
    public static void printMultTable(int rows, int cols) {
        for(int i =1; i<= rows ; i++) {
            printMultiples(i, cols);
        }
    }
    
    public static void printMultiples(int n, int m) {
        for(int i =1; i<=m; i++) {
            System.out.print(n*i + "\t");
        }
        System.out.println();
    }    
}
