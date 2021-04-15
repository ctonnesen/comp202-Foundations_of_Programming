/**
 * A program to practice doing some char arithmetics
 */
public class CharPractice {
        
    public static void main(String[] args) { 
        System.out.println(charRightShift('a', 354));
    }

    /* a method that takes a char c and an int n as input. 
    * If c is a lower case letter of the alphabet, the method returns
    * the letter n position to the right of c. Otherwise, the method
    * returns c
    * charRightShift('g', 2) --> 'i'
    * charRightShift('$', 8) --> '$'
    */ 
    public static char charRightShift(char letter, int shift) {
        // check the input
        if(!(letter >= 'a' && letter <= 'z')) {
            return letter;
        } else {
            char shifted = (char)(letter + shift);
            return shifted;
        }
        //return '0';
    }
    
}
