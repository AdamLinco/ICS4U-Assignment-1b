//Import Libraries
import java.io.IOException;
import java.io.StringReader;
import java.util.Scanner;

/**
 * This program tells a user the longest run
 * of their inputted sting.
 * 
 * @author Adam Linco
 * @version 1.0
 * @since 2020-02-13
 */
 
//This fourm at 
//https://codereview.stackexchange.com/questions/75441/finding-the-length-of-the-largest-run.
//helped me a lot with this program.


public class LongestRun {
  /**
   * The class that holds all of the variables and methods.
   *  @para args arguments that can return
   */
  public static void main(String[] args) {
    //Allows user to input their string into the console
    Scanner userScanner = new Scanner(System.in);
    //Prompts user to input their string
    System.out.println("Input your string : ");
    String userInput = userScanner.next();
    if (userInput != null) {
      //Ouputs user string, using calculations 
      // below

      
      String strOut = longestRun(userInput);
    } else {
      //gives user an error if input is invalid
      System.out.println("Error");
      userScanner.close();
    }
  }
    
  //Create Variables for calculations
    
  //Integer Variables 
  static int Position = 0;
 
  static int count = 1;
 
  static int max = 0;

  //Character Variable (didnt really understand character variables.
  //However,Using this explanation guide https://www.tutorialspoint.com/java/java_characters.htm
  //I saw it useful to use this as we are using strings)

  static char thisElem;
 
  static char lastElem;
  //String Variables
  static String string = "";
  
  static String strOut = "";
  
  
  
  /**
   * The class that holds all of the variables and methods.
   *  @para args arguments that can return
   */

  public static String longestRun(String userInput) {
    //https://www.tutorialspoint.com/java/java_strings.htm guide
    // helped with .length and how it relates to it displaying the legnth of the sting
    int maxPosition = userInput.length();
    lastElem = userInput.charAt(Position);
    //charAt is what returns at the given index number so in this case,user input
    //had a hard time figuring how to use charAt so this tutorial helped 
    //https://beginnersbook.com/2013/12/java-string-charat-method-example
  
    for (Position = 1; Position < maxPosition; Position++) {
      thisElem = userInput.charAt(Position);
 
     
      if (lastElem == thisElem) {
        count++;
        string = string + lastElem;
      } else {
        if (count > max) {
          max = count;
          string = "";
          strOut = string + lastElem; 
        }
        count = 1;
      }
      lastElem = thisElem;
    }
    if (count > max) {
      max = count;
      strOut = string + lastElem;
    }
      
    if (maxPosition == 1) {
      strOut = userInput;
    }  
    // Displays the users string along with the longest run
    System.out.println("The longest run of " + strOut + " is " + max);
    return strOut;
  }
  
}
