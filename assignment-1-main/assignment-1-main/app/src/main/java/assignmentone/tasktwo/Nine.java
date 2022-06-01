package assignmentone.tasktwo;

import java.util.Random;
import java.util.Scanner;

/**
 * Print user and computer game "nine".
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class Nine {
  /**
   * Main method for class about dice game.
   */
  public static void main(String[] args) {
    Random rndComputer = new Random();
    Random rndUser = new Random();

    Scanner given = new Scanner(System.in, "UTF-8");
    String user;

    int rnUser1 = rndUser.nextInt(7);
    int rnUser2 = rndUser.nextInt(7);
    int totalUser = rnUser1 + rnUser2;

    int rnComputer1 = rndComputer.nextInt(7);
    int rnComputer2 = rndComputer.nextInt(7);
    int totalComputer = rnComputer1 + rnComputer2;

    System.out.print("Ready to play? (Y/N): ");
    user = given.nextLine();
    user = user.toUpperCase();

    String yes = "Y";
    String no = "N";

    if (user.equals(no)) {
      System.out.println("Don't you want to play?");
    } else if (user.equals(yes)) { // if the user want to play first time  
      System.out.println("You rolled: " + rnUser1);
      System.out.print("Would you like to roll again? (Y/N): ");
      user = given.nextLine();
      user = user.toUpperCase();

      if (user.equals(no)) {  // if the user does not need 2nd chance
        System.out.println("The computer rolled: " + rnComputer1);
        if (rnComputer1 > 4) {
          if (rnUser1 > rnComputer1) {
            System.out.println("You won!");
          } else if (rnUser1 < rnComputer1) {
            System.out.println("The computer won!");
          } else if (rnUser1 == rnComputer1) {
            System.out.println("You and the Computer have equal");
          }
        } else if (rnComputer1 <= 4) {
          System.out.println("The computer rolls again and gets " + rnComputer2
              + " in total " + totalComputer);
          if (rnUser1 > totalComputer) {
            System.out.println("You won!");
          } else if (rnUser1 < totalComputer) {
            System.out.println("The computer won!");
          } else if (rnUser1 == totalComputer) {
            System.out.println("You and the Computer have equal");
          }
        }  
      } else if (user.equals(yes)) { // if the user want to keep play the 2nd chance
        System.out.println("You rolled " + rnUser2 + " and in total you have " + totalUser);
        System.out.println("The computer rolled: " + rnComputer1);
        System.out.println("The computer rolls again and gets " + rnComputer2
            + " in total " + totalComputer);
        if (totalUser > 9 || totalComputer > 9) {
          System.out.println("Fat");
        } else if (totalUser > totalComputer) {
          System.out.println("You won!");
        } else if (totalUser < totalComputer) {
          System.out.println("The computer won!");
        } else if (totalUser == totalComputer) {
          System.out.println("You and the Computer have equal");
        } 
        given.close();
      }
    }
  }
}
// done
