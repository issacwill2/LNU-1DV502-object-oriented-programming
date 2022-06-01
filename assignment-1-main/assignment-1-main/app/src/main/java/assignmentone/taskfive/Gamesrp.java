package assignmentone.taskfive;

import java.util.Random;
import java.util.Scanner;

/**
 * Print srp.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class Gamesrp {
  /**
   * main method with 3 switch statment and the include 3 more nested "switch"
   * as the user will enter 1-3 and the computer genarate random to play with.
   */
  public static void main(String[] args) {
    Random rnd = new Random();
    Scanner scan = new Scanner(System.in, "UTF-8");

    int manEnter = 1;
    int man = 0;
    int computer = 0;
    int draw = 0;

    while (manEnter != 0) {  // as long as the user not entering zero
      int rndComputer = rnd.nextInt(3) + 1;
      System.out.print("Scissor (1), rock (2), paper (3) or 0 to quit: ");
      manEnter = scan.nextInt();
      switch (rndComputer) {
        case 1: // if enter number one
          switch (manEnter) {
            case 0:
              break;
            case 1:
              System.out.println("It's a draw!");
              draw++;
              break;
            case 2:
              System.out.println("You won, computer had scissor");
              man++;
              break;
            case 3:
              System.out.println("You lost, computer had scissor!");
              computer++;
              break;
            default:
              break;
          }
          break;
        case 2: // if enter number two
          switch (manEnter) {
            case 1:
              System.out.println("You lost, computer had rock!");
              computer++;
              break;
            case 2:
              System.out.println("It's a draw!");
              draw++;
              break;
            case 3:
              System.out.println("You won, computer had rock!");
              man++;
              break;
            default:
              break;
          }
          break;
        case 3:  // // if enter number one
          switch (manEnter) {
            case 1:
              System.out.println("You won, computer had paper!");
              man++;
              break;
            case 2:
              System.out.println("You lost, computer had paper!");
              computer++;
              break;
            case 3:
              System.out.println("It's a draw!");
              draw++;
              break;
            default:
              break;
          }
          break;
        default:
          break;
      }
    }
    System.out.println("Score: " + man + " (you) " + computer
        + " (computer) " + draw + " (draw).");
    scan.close();
  }
}
// done
