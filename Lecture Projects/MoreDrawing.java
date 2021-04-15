public class MoreDrawing {
    
    
    public static void main(String[] args) { 
        drawSquare(5, 2, 4);
    }
    
    // a method that draws a square of the give side made of '+'
    // The point (x,y) is displayed as a 'o'
    public static void drawSquare(int side, int x, int y) {
        
        for(int yAxis = side-1; yAxis >= 0; yAxis--) {
            for(int xAxis = 0; xAxis < side; xAxis ++) {
                if(xAxis == x && yAxis == y) {
                    System.out.print('o');
                } else {
                    System.out.print('+');
                }
            }
            System.out.println();
        }
    }
    
    // a method that diplays an empty square using the given side
    // printEmptySquare(4)
    // ++++
    // +  +
    // +  +
    // ++++
    public static void printEmptySquare(int side) {
        // create a loop that iterates side times
        for(int i=0; i<side; i++) {
            if(i==0 || i==side-1) {
                printLine(side);
            } else {
                printEmptyLine(side);
            }
        }
    }
    
    
    // a method that displays a square made of '+' using the given side
    public static void printSquare(int side) {
        // create a loop that iterates side times
        for(int i=0; i<side; i++) {
            // at each iteration call printLine
            printLine(side);
        }
    }
    
    // a method that take an int n as input and prints an "empty line"
    // a line long n, with '+'s only on the extremities
    // printEmptyLine(5) --> +   +
    public static void printEmptyLine(int n) {
        // loop that iterates n times
        for(int i=0; i<n; i++) {
            if(i==0 || i==n-1) {
                System.out.print('+');
            } else {
                System.out.print(' ');
            }
        }
        System.out.println();
    }
    
    // a method that takes an int n as input and displays n characters
    // alterning between '+' and '-'
    // printAltLine(5) --> +-+-+
    public static void printAltLine(int n) {
        for(int i = 0; i<n; i++) {
            if(i%2== 0) {
                System.out.print('+');
            } else {
                System.out.print('-');
            }
        }
        System.out.println();
    }
    
    
    // a method that takes an int n as input and displays n '+'s
    public static void printLine(int n) {
        for(int i = 0; i<n; i++) {
            System.out.print('+');
        }
        System.out.println();
    }
}
