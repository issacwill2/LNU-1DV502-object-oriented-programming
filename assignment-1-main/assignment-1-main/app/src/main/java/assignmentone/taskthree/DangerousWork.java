package assignmentone.taskthree;

import java.util.Scanner;

/**
 * Print dangerous.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class DangerousWork {
  /**
   * Main method for class about dangeroous work.
   */
  public static void main(String[] args) {
    int day = 1;
    Scanner scan = new Scanner(System.in, "UTF-8");
    System.out.print("How much would you like to earn? ");
    float money = scan.nextFloat();
    
    if (money % 2 == 0) {
      day -= 1;
    }

    while (money > 0.01) { // the least amount should be 0.01
      money = money / 2;
      day++;
    }
    System.out.printf("You will have your money in " + day + " days.");
    scan.close();
  }
}
// done
