// a program that performs simple calculations on integers: +, -, *
public class SimpleCalculator {
    public static void main(String[] args) {
        // retrieve the three inputs
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[2]);
        String op = args[1];
        
        // check the operator received and perform the computation
        // display the result
        if(op.equals("+")) {
            System.out.println(x + " + " + y + " is equal to " + (x+y));
        } else if(op.equals("-")) {
            System.out.println(x + " - " + y + " is equal to " + (x-y));
        } else if (op.equals("*")) {
            System.out.println(x + " * " + y + " is equal to " + x*y);
        } else {
            System.out.println("Operator not supported.");
        }
        
        
    }
}