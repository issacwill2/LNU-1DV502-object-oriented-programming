package assignmentone.tasksex;

import java.util.Scanner;

/**
 * Print day of weeks.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class DayOfWeek {
  /**
   * it turns DayOfWeek.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "UTF-8");

    System.out.print("Enter year: ");
    int year = scan.nextInt();

    System.out.print("Enter month (1-12): ");
    int month = scan.nextInt();

    System.out.print("Enter day of the month (1-31): ");
    int date = scan.nextInt();

    if (month == 1 || month == 2) {
      month = month + 12;
      year = year - 1;
    }

    int j = year / 100;
    int k = year % 100;
    int h = (date + ((26 * (month + 1)) / 10) + k + (k / 4) + (j / 4) + (5 * j)) % 7;
    String days = "";

    switch (h) {

      case 0:
        days = "Saturday";
        break;
      case 1:
        days = "Sunday";
        break;
      case 2:
        days = "Monday";
        break;
      case 3:
        days = "Tuesday";
        break;
      case 4:
        days = "Wednesday";
        break;
      case 5:
        days = "Thursday";
        break;
      case 6:
        days = "Friday";
        break;
      default:
        System.out.println("error");
    }
    System.out.println("Day of week is " + days);
    scan.close();
  }
}
// done
