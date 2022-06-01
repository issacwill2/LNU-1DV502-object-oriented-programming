package assignmentone.taskfour;

import java.util.Scanner;

/**
 * Print diamond.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class Diamonds {
  /**
   * Main method for class to make diamond pattern using while loop.
   */
  public static void main(String[] args) {
    Scanner given = new Scanner(System.in, "UTF-8");
    System.out.print("Give a positive number: ");
    int number = given.nextInt();

    char star = '*';
    int i = 1;
    int j;

    if (number < 0) {
      System.out.println("Please Give a positive number!");
    } else { // unless it is not less than zero 
      do {
        j = 1;
        do {
          System.out.print(" ");
        } while (++j <= number - i + 1);
        j = 1;
        do {
          System.out.print(star);
        } while (++j <= i * 2 - 1);
        System.out.println();
      } while (++i <= number);
      i = number - 1;
      do {
        j = 1;
        do {
          System.out.print(" ");
        } while (++j <= number - i + 1);
        j = 1;
        do {
          System.out.print(star);
        } while (++j <= i * 2 - 1);
        System.out.println();
      } while (--i > 0);
      given.close();
    }
  }
}
// done
