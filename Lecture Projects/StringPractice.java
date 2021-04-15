/**
 * Auto Generated Java Class.
 */
public class StringPractice {
    
    
    public static void main(String[] args) { 
        //checkPassword("PrettyPlease");
        System.out.println(checkVowel("Orange", 0));
    }
    
    // a method that takes a String and and int i as input
    // it returns true if the character at index i is a vowel, false otherwise
    // checkVowel("Orange", 2) --> true
    // checkVowel("Orange", 1) --> false
    public static boolean checkVowel(String s, int i) {
        String t = s.toLowerCase();
        char letter = t.charAt(i);
        if(letter == 'a' || letter == 'e' || letter == 'i' || letter == 'o' 
               || letter == 'u') {
            return true;
        } else {
            return false;
        }
    }
    
    // a method that takes a String as input and checks if it is
    // equal to the password "PrettyPlease"
    public static void checkPassword(String pwd) {
        if(pwd.equals("PrettyPlease")) {
            System.out.println("Well done!");
        } else {
            System.out.println("Try again!");
        }
    }
    
    
}
