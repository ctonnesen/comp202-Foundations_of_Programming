public class EmailValidationTest {
  public static void main(String[] args) {
    String input = args [0];
    System.out.println(input);
    char testedCharacter = input.charAt(0);
    System.out.println("isAlphanumeric:" + isAlphanumeric(testedCharacter));
    System.out.println("isValidPrefixChar:" + isValidPrefixChar(testedCharacter));
    System.out.println("isValidDomainChar:" + isValidDomainChar(testedCharacter));
    System.out.println("exactlyOneAt:" + exactlyOneAt(input));
    System.out.println("getPrefix:" + getPrefix(input));
    System.out.println("getDomain:" + getDomain(input));
    
    System.out.println("portionStopper:" + portionStopper(input));
    System.out.println("firstPortionDomain:" + firstPortionDomain(input));
    System.out.println("secondPortionDomain:" + secondPortionDomain(input));


    System.out.println("isAlphabet:" + isAlphabet(input));
    System.out.println("isValidPrefix:" + isValidPrefix(input));
    System.out.println("isValidDomain:" + isValidDomain(input));
    System.out.println("Is " + input + "a valid email address: " + isValidEmail(input));  
  }
  
  /*The main method simply takes the argument and turns it into a string "input"
   * A variable "testedCharacter" is also initialized, being the first character of
   * the input. Finally, a print statement displays whether or not the inputted email is
   * valid
   */
  
  
  public static boolean isAlphanumeric(char testedCharacter) {
    boolean checkerLowerAlpha = (testedCharacter >= 'a' && testedCharacter <= 'z'); 
    if (checkerLowerAlpha) {
      return true; }
    boolean checkerUpperAlpha = (testedCharacter >= 'A' && testedCharacter <= 'Z');
    if (checkerUpperAlpha) {
      return true; }
    boolean checkerNumeric = (testedCharacter >= '0' && testedCharacter <= '9');
    if (checkerNumeric) {
      return true; 
    }
    return false;
  }  
  
  /*The above method checks if the inputted character satisfies the quotas for being alphanumeric through a series of
   * if statements. All it takes is for one of the "if statements" to be true in order for a true boolean value to be
   * returned. Otherwise, a false value is returned. */
  
  public static boolean isValidPrefixChar (char testedCharacter) {
    boolean checkerUnderscore = (testedCharacter == '_'); 
    if (checkerUnderscore) {
      return true; }
    boolean checkerPeriod = (testedCharacter == '.');
    if (checkerPeriod) {
      return true; }
    boolean checkerDash = (testedCharacter == '-');
    if (checkerDash) {
      return true; }
    boolean checkerAlphanumeric = (isAlphanumeric (testedCharacter));
    if (checkerAlphanumeric) {
      return true; }
    else {
      return false;
    }
  }
  
  /* isValidPrefixChar uses booleans to check for the non-Alphanumeric characters for prefixes like underscores,
   * periods, and dashes. It also tests to see if the inputted character is alphanumeric by calling
   * the "isAlphanumeric" method. 
   */
  
  public static boolean isValidDomainChar (char testedCharacter) {
    boolean checkerUnderscore = (testedCharacter == '_'); 
    if (checkerUnderscore) {
      return false; }
    if (isAlphanumeric(testedCharacter)); {
      return true; }
  }
  
  /* isValidDomainChar uses the same process as isValidPrefixChar to check for valid domain characters, but returns a
   * false value if an underscore is used. 
   */
  
  public static boolean exactlyOneAt(String input) {
    int atCounter = 0;
    for (int index = 0; index < (input.length()); index++) {
      if (input.charAt(index) == '@') {
        atCounter = atCounter + 1;
      }
    }
    
    /* atCounter keeps track of how many @ symbols are in the input 
     */
    
    if (atCounter == 1) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /* This method checks for a singular @ in the email through the use of a "for" loop. In the event that there is more
   * than one @ symbol, the atCounter variable will be greater than one and force the method to return a false 
   */
  
  public static String getPrefix(String input) {    
    String prefix = "";
    for (int index = 0; index < input.length(); index++) {
      if (input.charAt(index) == '@') {
        for (int indexStopper = 0; indexStopper < index; indexStopper++) {
          prefix = prefix + input.charAt(indexStopper);
        } 
      }
    } 
    return prefix;
  }
  
  /* getPrefix uses a "for" loop to find the @ symbol and concatenates together a string from the first character value
   * (0) to the character value right before the @ symbol. This concatenation is accomplished through declaring the
   * "prefix" variable before the loop so that it can be returned outside the loop, then adding the character at
   * "indexStopper" from the loop after every run.
   */
  
  public static String getDomain (String input) {
    String domain = "";
    for (int index = 0; index < input.length(); index++) {
      if (input.charAt(index) == '@') {
        for (int indexDomain = index; indexDomain < input.length(); indexDomain++) {
          if (indexDomain == index) {
            continue;
            
            // The continue stops the @ from being in any domains
            
          }
          domain = domain + input.charAt(indexDomain);
        }
      }
    }
    return domain;
  }
  
  /* getDomain does the same process as getPrefix, but instead counts from after the @ symbol to the end of the input.
   * A continue is used to ensure that the @ symbol is not included in the domain string and the remainging string is 
   * returned as "domain"
   */
  
  public static boolean isValidPrefix (String input) {
    String prefix = getPrefix(input);
    if(prefix.length() == 0) 
      return false;
    
    //Checks to ensure that there is at least one character in the prefix
    
    for (int i = 0; i < prefix.length(); i++){
      if(!isValidPrefixChar(prefix.charAt(i))) { 
        return false;
        
        // Checks that all of the prefix characters are valid
        
      } else{
        if(prefix.charAt(i) == '.' || prefix.charAt(i) == '-' || prefix.charAt(i) == '_'){
          if(i >= prefix.length()) 
            return false;
          
          // If the index is outside string range, it returns false
          
          else if(!isAlphanumeric(prefix.charAt(i+1)))
            return false;
          
          // Checks that if the character is not alphanumeric, the following character is
          
        }
      }
    }    
    return true;
  }
  
  public static int portionStopper (String input) {
    int secondPortionStopper = 0;
    String domain = getDomain(input);
    int onePeriod = 0;
    int index = 0;
    for (index = (domain.length()-1); 0 < index; index--) {
      if (domain.charAt(index) == '.') {
        break;
        
        // The loop is exited once the last period has been found
        
      }
    }
    return index;
  }
  
  /* The portionStopper method generates the index value where the final period is in the domain for use in separating the
   * domain portions. It returns the index value of the last period to be used in the following method.
   */
  
  public static String firstPortionDomain (String input) {
    String firstPortionDomain = "";
    String domain = getDomain(input);
    int portionStopper = portionStopper(input);
    for (int indexBeginning = 0 ; indexBeginning < portionStopper; indexBeginning++) {
      firstPortionDomain = firstPortionDomain + domain.charAt(indexBeginning);
    }
    return firstPortionDomain;
  }
  
  /* firstPortionDomain uses the index value from portionStopper to concatenate a string together for the first
   * domain portion by use of a "for" loop. The concatenation technique is the same as for the prefix and domain.
   */
  
  
  public static String secondPortionDomain (String input) {
    String secondPortionDomain = "";
    String domain = getDomain(input);
    int portionStopperInt = portionStopper(input);
    for (int index = portionStopperInt; index < domain.length(); index++) {  
      if (index == portionStopperInt) {
        continue;
      }
      secondPortionDomain = secondPortionDomain + domain.charAt(index);
    }
    return secondPortionDomain;
  }
  
  /* The secondPortionDomain uses the portionStopper from the previous method to mark the start of the second portion
   * of the domain and concatenates a string together from the following characters.
   */ 

  public static boolean isAlphabet(String input) {
    String secondPortion = secondPortionDomain (input);
    for (int index = 0; index < secondPortion.length(); index++) {
      char testedCharacter = secondPortion.charAt(index);
      boolean checkerLowerAlpha = (testedCharacter >= 'a' && testedCharacter <= 'z'); 
      if (checkerLowerAlpha) {
        return true; }
      boolean checkerUpperAlpha = (testedCharacter >= 'A' && testedCharacter <= 'Z');
      if (checkerUpperAlpha) {
        return true; }
    }
    return false;
  }
  
  /* isAlphabet checks that the input character is part of the alphabet, whether capitalized or lowercase.
   * The structure is very similar to isAlphanumeric.
   */ 
  
  public static boolean isValidDomain (String input) {
    String domain = getDomain(input);
    String firstPortion = firstPortionDomain (input);
    String secondPortion = secondPortionDomain (input);
    if (!((domain.length()- firstPortion.length() - secondPortion.length()) == 1)) 
      return false;
    if (0 == firstPortion.length())
      return false;
    if (1 >= secondPortion.length())
      return false;
    for (int index = 0; index < firstPortion.length(); index++){
      if(!isValidDomainChar(firstPortion.charAt(index))) {
        return false;
        
        // Checks that all of the first domain portion characters are valid
        
      } else {
        if(firstPortion.charAt(index) == '.' || firstPortion.charAt(index) == '-') {
          if(index+1 >= firstPortion.length()) 
            return false;
          
          // If the index is outside string range, it returns false
          
          else if(!isAlphanumeric(firstPortion.charAt(index+1)))
            return false;
        }
        if (!(isAlphabet(input))){
          return false;    
          
          // Checks that if the character is not alphanumeric, the following character is
          
        }
      }
    }
    return true;
  }

  public static boolean isValidEmail (String input) {
    if (!exactlyOneAt (input))
      return false;
    if (!isValidPrefix (input))
      return false;
    if (!isValidDomain (input))
      return false;
    return true;
  }
  
  /*isValidEmail calls isValidPrefix and isValidDomain to see if the entire email string is valid and returns a boolean
   * value for the main method to print
   */ 
  
}