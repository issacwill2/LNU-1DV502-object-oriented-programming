package assignmentone.taskone;

import java.util.Scanner;

/**
 * Print the time from the seconds.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class Time {
  /** 
   * Main method for class about Time.
   */
  public static void main(String[] args) {
    Scanner giveSeconds = new Scanner(System.in, "UTF-8");
    int seconds;

    System.out.print("Give a number of seconds: ");
    seconds = giveSeconds.nextInt();

    int hrs = seconds / 3600;
    int mins = seconds % 3600;
    int minutes = mins / 60;
    int secs = mins % 60;

    System.out.println("This corresponds to: " + hrs + " hrs, "
        + minutes + " mins and " + secs + " seconds");
    giveSeconds.close();
  }
}
// done
