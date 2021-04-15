import java.util.Arrays;
public class MultidimArrays {
  public static void main(String [] args) {
    int[][] x = {{1,2,3}, {4,5}};
    int[][] y = new int [2][5];
    int[][] z = new int [4][];
    String [][] w = new String[2][3];
    print2DArray (x);
  }
  
  public static void print2DArray(int[][] a) {
    for (int i = 0; i<a.length; i++) {
      for (int j = 0; j<a[i].length; j++){
        System.out.print(a[i][j]+ " ");
      }
      System.out.println();
    }
  }
}
    