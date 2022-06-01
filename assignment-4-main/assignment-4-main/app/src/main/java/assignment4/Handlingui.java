package assignment4;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * this handles the user interface.
 */

public class Handlingui {
  private ArrayList<Member> members = new ArrayList<>();

  public Handlingui(ArrayList<Member> members) {
    this.members = members;

  }

  private boolean isTheEmailUnique(String email) { // CHECK IF EMAIL IS UNIQUE
    for (Member member : this.members) {
      if (member.getEmail() == null) {
        continue;
      }
      if (member.getEmail().equals(email)) {
        return false;
      }
    }
    return true;
  }

  private boolean isIdUnique(String id) { // CHECK IF ID IS UNIQUE
    for (Member member : this.members) {
      if (member.getId().equalsIgnoreCase(id)) {
        return false;
      }
    }
    return true;
  }

  /**
   * get the users by their id.

   * @param id is the attribute of the user.
   * @return member.
   */

  public Member getMemberById(String id) { // SHOW A SELECTED MEMBERS DETAIL
    for (Member member : this.members) {
      if (member.getId().equalsIgnoreCase(id)) {
        return member;
      }
    }
    return null;
  }

  /**
   * get the boat by its name.

   * @param boats is an attribute of a member.
   * @param name  is the name of the boat.
   * @return null.
   */

  public Boat getBoatByName(ArrayList<Boat> boats, String name) {
    for (Boat boat : boats) {
      if (boat.getName().equalsIgnoreCase(name)) {
        return boat;
      }
    }
    return null;
  }

  /**
   * this lists all the members and their boats if they have.
   */

  // Show All Members (IF CASE 1 IS SELECTED)
  public void showAllMembers() {
    for (Member member : members) {
      System.out.println(member);

      if (!member.getBoats().isEmpty()) {
        System.out.println(member.getBoats());
      } else {
        System.out.println("Has NO Boat");
      }
    }
  }

  /**
   * Set New Members (IF CASE 2 IS SELECTED).
   */

  public void setNewMembers() {
    System.out.println("\n****  SETTING NEW MEMBER  ****");
    Scanner scanAddNewMember = new Scanner(System.in, StandardCharsets.UTF_8);
    System.out.print("ENTER NAME MEMBER:  ");
    String userName = scanAddNewMember.nextLine();

    // MAKES SURE TO DO NOT CONTAIN SYMBOLS
    Pattern patterMemberName = Pattern.compile(
        "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
    Matcher match = patterMemberName.matcher(userName);
    boolean result = match.find();
    if (result) {
      System.out.println("PLEASE ENTER ONLY ALPHANUMERIC FOR THE NAME MEMBER");

    } else {

      System.out.print("OPTIONAL: ENTER EMAIL OR Y TO CONTINUE: ");
      String emailAddress = scanAddNewMember.nextLine();

      // MAKES SURE TO DO NOT CONTAIN SYMBOLS
      Pattern patternEmail = Pattern.compile(
          "[^a-z0-9@._ ]", Pattern.CASE_INSENSITIVE);
      Matcher matc = patternEmail.matcher(emailAddress);
      boolean resul = matc.find();
      if (resul) {
        System.out.println("PLEASE ENTER ONLY ALPHANUMERIC OR (@ . _) FOR EMAIL");

      } else {
        String setNewId = BoatClubMain.makeRandomId();
        while (!this.isIdUnique(setNewId)) {
          System.out.println("loop");
          setNewId = BoatClubMain.makeRandomId();
        }
        if (emailAddress.isEmpty()) { // IF THE EMAIL IS EMPTY
          members.add(new Member(userName, setNewId)); // ADD ONLY NAME AND ID
          System.out.println("\n****  " + userName + "  IS ADDED AS A NEW MEMBER  **** ");
          System.out.println("MEMBER NAME: " + userName);
          System.out.println("MEMBER ID: " + setNewId);
        } else {
          if (this.isTheEmailUnique(emailAddress)) { // IF THE EMAIL IS UNIQUE
            members.add(new Member(userName, setNewId, emailAddress)); // INCLUDE THE EMAIL
            System.out.println("\n****  " + userName + " IS ADDED AS A NEW MEMBER **** ");
            System.out.println("MEMBER NAME: " + userName);
            System.out.println("MEMBER ID: " + setNewId);
            System.out.println("EMAIL ADDRESS: " + emailAddress);

          } else {
            System.out.println("MAKE THE EMAIL ADDRESS UNIQUE");
          }
        }
      }
    }
  }

  /**
   * Select Member By Id (IF CASE 3 IS SELECTED).
   */

  public void selectMemberById() {
    Scanner scanId = new Scanner(System.in, StandardCharsets.UTF_8);
    System.out.println("ENTER MEMBER'S ID: ");
    String givenId = scanId.nextLine();
    Member member = this.getMemberById(givenId);

    if (member != null) { // IF THE ID IS NOT NULL OR CORRECT
      System.out.println(member); // SHOW THE MEMBER'S DETAIL
      System.out.println("{1} DELETE A MEMBER");
      System.out.println("{2} ADD A BOAT BELONGS TO THE SELECTED MEMBER");
      System.out.println("{3} SELECT A BOAT");

      Scanner scanThreeCases = new Scanner(System.in, StandardCharsets.UTF_8);
      switch (scanThreeCases.nextInt()) {
        case 1:
          members.remove(member); // remove member
          System.out.println("****  THE MEMBER IS DELETED  ****");
          break;
        case 2:
          Scanner boatAdd = new Scanner(System.in, StandardCharsets.UTF_8); // ADD NEW BOATS
          System.out.println("****  ENTER TYPE OF BOATS FROM THE FOLLOWING  ****");
          System.out.println("MotorBoat, canoe, SailBoat  or MotorSailer):");
          String boat = boatAdd.nextLine();

          if (boat.equalsIgnoreCase("Motorboat")) { // Motorboat
            Scanner scanMotorBoatName = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("ENTER BOAT NAME:  ");
            String boatsName = scanMotorBoatName.nextLine();

            // MAKES SURE TO DO NOT CONTAIN SYMBOLS 1
            Pattern patterBoatName = Pattern.compile(
                "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher match = patterBoatName.matcher(boatsName);
            boolean resu = match.find();
            if (resu) {
              System.out.println("PLEASE ENTER ONLY ALPHANUMERIC FOR BOAT NAME");

            } else {
              Scanner scanMotorBoatLenght = new Scanner(System.in, StandardCharsets.UTF_8);
              System.out.print("ENTER BOAT LENGTH IN METER: ");
              int lenghtMeter = scanMotorBoatLenght.nextInt();
              Scanner scanMotorBoatPower = new Scanner(System.in, StandardCharsets.UTF_8);
              System.out.print("ENTER BOAT ENGINE POWER IN HP:  ");
              int enginePower = scanMotorBoatPower.nextInt();
              member.addBoat(new MotorBoat(boatsName, lenghtMeter, enginePower));
              System.out.println("****  A MOTORBOAT IS ADDED  ****");
              System.out.println(member);
              System.out.println(member.getBoats());
            }

          } else if (boat.equalsIgnoreCase("canoe")) { // canoe
            Scanner scanCanoeName = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("ENTER BOAT NAME:  ");
            String boatsName = scanCanoeName.nextLine();

            // MAKES SURE TO DO NOT CONTAIN SYMBOLS 2
            Pattern patterBoatName = Pattern.compile(
                "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher match = patterBoatName.matcher(boatsName);
            boolean resu = match.find();
            if (resu) {
              System.out.println("PLEASE ENTER ONLY ALPHANUMERIC FOR BOAT NAME");

            } else {
              Scanner scanCanoeLenght = new Scanner(System.in, StandardCharsets.UTF_8);
              System.out.print("ENTER BOAT LENGTH IN METER: ");
              int lenghtMeter = scanCanoeLenght.nextInt();
              member.addBoat(new Canoe(boatsName, lenghtMeter));
              System.out.println("****  A CANOE BOAT IS ADDED  ****");
              System.out.println(member);
              System.out.println(member.getBoats());
            }

          } else if (boat.equalsIgnoreCase("SailBoat")) { // SailBoat
            Scanner scanSailBoatName = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("ENTER BOAT NAME:  ");
            String boatsName = scanSailBoatName.nextLine();

            // MAKES SURE TO DO NOT CONTAIN SYMBOLS 3
            Pattern patterBoatName = Pattern.compile(
                "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher match = patterBoatName.matcher(boatsName);
            boolean resu = match.find();
            if (resu) {
              System.out.println("PLEASE ENTER ONLY ALPHANUMERIC FOR BOAT NAME");

            } else {
              Scanner scanSailBoatLenght = new Scanner(System.in, StandardCharsets.UTF_8);
              System.out.print("ENTER BOAT LENGTH IN METER: ");
              int lenghtMeter = scanSailBoatLenght.nextInt();
              Scanner scanSailBoatDepth = new Scanner(System.in, StandardCharsets.UTF_8);
              System.out.print("ENTER BOAT DEPTH IN METER:  ");
              int depthMeter = scanSailBoatDepth.nextInt();
              member.addBoat(new SailBoat(boatsName, lenghtMeter, depthMeter));
              System.out.println("****  A SAILBOAT IS ADDED  ****");
              System.out.println(member);
              System.out.println(member.getBoats());
            }

          } else if (boat.equalsIgnoreCase("Motorsailer")) { // Motorsailer
            Scanner scanMotorsailerName = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("ENTER BOAT NAME:  ");
            Scanner scanMotorsailerLenght = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("ENTER BOAT LENGTH IN METER: ");
            int lenghtMeter = scanMotorsailerLenght.nextInt();
            String boatsName = scanMotorsailerName.nextLine(); // boatsName

            // MAKES SURE TO DO NOT CONTAIN SYMBOLS 4
            Pattern patterBoatName = Pattern.compile(
                "[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
            Matcher match = patterBoatName.matcher(boatsName);
            boolean resu = match.find();
            if (resu) {
              System.out.println("PLEASE ENTER ONLY ALPHANUMERIC FOR BOAT NAME");

            } else {
              Scanner scanMotorsailerDepth = new Scanner(System.in, StandardCharsets.UTF_8);
              System.out.print("ENTER BOAT DEPTH IN METER:  ");
              int depthMeter = scanMotorsailerDepth.nextInt();
              Scanner scanMotorsailerPower = new Scanner(System.in, StandardCharsets.UTF_8);
              System.out.print("ENTER BOAT ENGINE POWER IN HP: ");
              int enginePower = scanMotorsailerPower.nextInt();
              member.addBoat(new MotorSailer(boatsName, lenghtMeter, depthMeter, enginePower));
              System.out.println("****  A MOTORSAILER BOAT IS ADDED  ****");
              System.out.println(member);
              System.out.println(member.getBoats());
            }
          }
          break;

        case 3:
          if (!member.getBoats().isEmpty()) { // SELECT A BOAT
            System.out.println(member.getBoats());

            Scanner scanSelectBoatName = new Scanner(System.in, StandardCharsets.UTF_8);
            System.out.print("ENTER BOAT NAME: ");
            String enteredName = scanSelectBoatName.nextLine();
            Boat chosenBoat = this.getBoatByName(member.getBoats(), enteredName);

            if (chosenBoat != null) {
              System.out.println("ENTER: 1 TO DELETE THE BOAT ");

              Scanner scanDeleteBoat = new Scanner(System.in, StandardCharsets.UTF_8);
              if (scanDeleteBoat.nextInt() == 1) {
                member.getBoats().remove(chosenBoat); // DELETE BOAT
                System.out.println(member);
                System.out.println(member.getBoats());
                System.out.println("****  THE SELECTED BOAT IS DELETED  ****");
              }
            } else {
              System.out.println("THE BOAT IS NOT FOUND");
            }
          } else {
            System.out.println("Has No Boat");
          }
          break;
        default:
      }
    } else {
      System.out.println("THE ID IS NOT VALID");
    }
  }

  public ArrayList<Member> getMembers() {
    return this.members;
  }
}

// done
