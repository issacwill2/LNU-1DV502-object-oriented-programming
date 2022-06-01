package assignmentone.tasknine;

import java.util.Scanner;

/**
 * Print calendar.
 *
 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class PrintCalendar {
  /**
   * main method creat calendar.
   */
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in, "UTF-8");
    System.out.print("Enter a year after 1800: ");
    int year = scan.nextInt();

    System.out.print("Enter a month (1-12): ");
    int month = scan.nextInt();
    scan.close();
    calendar(year, month);
  }

  public static void calendar(int year, int month) {
    calendarHead(year, month);
    mainCalendar(year, month);
  }
  
  /**
   * method creats the head of the calendar.
   * 
   * @param year the user enter the year
   * @param month and the month
   */

  public static void calendarHead(int year, int month) {
    System.out.println(nameofMonths(month) + " " + year);
    System.out.println("-----------------------------");
    System.out.println(" Mon Tue Wed Thu Fri Sat Sun");
  }
  
  /**
   * mathod which list the months in a year.
   * 
   * @param month name of the months to get listed.
   * @return the parametare.
   */

  public static String nameofMonths(int month) {
    String nameofMonths = "";
    switch (month) {
      case 1:
        nameofMonths = "January";
        break;
      case 2:
        nameofMonths = "February";
        break;
      case 3:
        nameofMonths = "March";
        break;
      case 4:
        nameofMonths = "April";
        break;
      case 5:
        nameofMonths = "May";
        break;
      case 6:
        nameofMonths = "June";
        break;
      case 7:
        nameofMonths = "July";
        break;
      case 8:
        nameofMonths = "August";
        break;
      case 9:
        nameofMonths = "September";
        break;
      case 10:
        nameofMonths = "October";
        break;
      case 11:
        nameofMonths = "November";
        break;
      case 12:
        nameofMonths = "December";
        break;
      default:
        System.out.println("error");
    }
    return nameofMonths;
  }
  /**
   * method which have two parameter to hold the first and all days in the month.
   */

  public static void mainCalendar(int year, int month) {
    int dayOne = firstDayofWeek(year, month); // first day of the month
    int daysofMonth = daysofMonth(year, month); // all days of the month

    int i = 0;
    for (i = 0; i < dayOne; i++) {
      System.out.print("    ");
    }

    for (i = 1; i <= daysofMonth; i++) {
      System.out.printf("%4d", i);
      if ((i + dayOne) % 7 == 0) {
        System.out.println();
      }
    }
    System.out.println();
  }
  
  /**
   * method which keeps the first day of jan in 1800.
   * 
   * @param year 1800.
   * @param month january.
   * @return the parameter.
   */

  public static int firstDayofWeek(int year, int month) {
    final int firstDayJan1800 = 2;
    int days = totalDays(year, month);
    return (days + firstDayJan1800) % 7;
  }
  /**
   * method total days from 1800 - the day you enter.
   */

  public static int totalDays(int year, int month) {
    int total = 0;

    // Iterating to get the total days from 1800(Jan 1) to the given year(Jan 1)
    for (int i = 1800; i < year; i++) {
      if (leapYear(i)) {
        total = total + 366;
      } else {
        total = total + 365;
      }
    }

    for (int i = 1; i < month; i++) { // Add days from Jan - the given month
      total = total + daysofMonth(year, i);
    }
    return total;
  }
  /**
   * method Days in the month.
   */

  public static int daysofMonth(int year, int month) { // Days in a month
    if (month == 4 || month == 6 || month == 9 || month == 11) {
      return 30;
    }
    
    if (month == 1 || month == 3 || month == 5 || month == 7 // moths which have 31 days
         || month == 8 || month == 10 || month == 12) {
      return 31;
    }
    
    if (month == 2) {  // February
      return leapYear(year) ? 29 : 28;
    }
    return 0;
  }

  public static boolean leapYear(int year) {
    return year % 400 == 0 || (year % 4 == 0 && year % 100 != 0); // Leap year
  }
}
// done
