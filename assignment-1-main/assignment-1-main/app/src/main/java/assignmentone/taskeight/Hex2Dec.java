package assignmentone.taskeight;

import java.util.Scanner;

/**
 * Print hex.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class Hex2Dec {
  /**
   *method convert to decimal.
   */
  public static int converToDecimal(String hex) {
    String hexDigits = "0123456789ABCDEF";
    hex = hex.toUpperCase();
    int num = 0;
    for (int i = 0; i < hex.length(); i++) {
      char charcter = hex.charAt(i);
      int digit = hexDigits.indexOf(charcter);
      num = 16 * num + digit;
    }
    return num;
  }
  
  /**
   * Main method for class convert hex.
   */
  
  public static void main(String[] args) {
    Scanner given = new Scanner(System.in, "UTF-8");
    System.out.print("Enter a hex number: ");
    String user = given.nextLine();
    System.out.println("The decimal value for " + user + " " + converToDecimal(user));
    given.close();
  }
}
// done
