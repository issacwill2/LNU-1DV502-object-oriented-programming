package assignment4;

// list members & add member --> 
// search a member using id --> remove, add or select boat (delete) if excited

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * BOAT CLUB CLASS WITH MEMBER ArrayList & SECURE RANDOM AS.
 */

public class BoatClubMain {
  private static SecureRandom secureRnd = new SecureRandom();

  /**
   * MAIN METHOD.

   * @param args .
   * @throws IOException .
   */

  public static void main(String[] args) throws IOException {

    FileHandling filehandle = new FileHandling(); // FileHandling Constructor

    Handlingui ui = new Handlingui(filehandle.getMembers()); // HandlingUi Constructor

    boolean keepRunCode = true;
    do {
      System.out.println("\n==================================");
      System.out.println("||  ***   THE BOAT CLUB   ***   ||");
      System.out.println("==================================");
      System.out.println("\nSELECT 1 - 3 ");
      System.out.println("{1} LIST ALL MEMBERS");
      System.out.println("{2} ADD NEW MEMBER");
      System.out.println("{3} ENTER ID TO SELECT A MEMBER");

      Scanner scan = new Scanner(System.in, StandardCharsets.UTF_8);

      try {
        int threeChoices = scan.nextInt();
        switch (threeChoices) {
          case 1:
            ui.showAllMembers();
            break;
          case 2:
            ui.setNewMembers();
            break;
          case 3:
            ui.selectMemberById();
            break;
          default:
            System.out.println("SELECT 1 - 3");
        }

      } catch (InputMismatchException exception) {
        System.out.println("MAKE SURE YOU ENTERED AN INTEGER!"); // IF THE USER ENTERS NOT INTEGER
      }

      System.out.print("ENTER: Y to Continue or N to Quit:  ");
      Scanner scanContinueorQuit = new Scanner(System.in, StandardCharsets.UTF_8);
      String continueOrQuit = scanContinueorQuit.nextLine();
      if (continueOrQuit.equalsIgnoreCase("N")) {
        keepRunCode = false;
      }

    } while (keepRunCode);
    filehandle.writeInTheRegisteryFile(ui.getMembers()); // it saves in the file while done
  }

  /**
   * GENERATE 6 UNIPUE & ALPHANUMERIC ID.

   * @return secureRandom.
   */

  public static String makeRandomId() {
    int putLeft = 48;
    int putRight = 122;
    int lengthId = 6;
    return secureRnd.ints(
        putLeft, putRight + 1).filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(lengthId).collect(StringBuilder::new, StringBuilder::appendCodePoint,
            StringBuilder::append)
        .toString();
  }
}

// Done
