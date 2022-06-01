package assignment4;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * this method handles the file to read and write data.
 */

public class FileHandling {
  private ArrayList<Member> members = new ArrayList<>();

  public FileHandling() {
    readTheRegisteryFile();
  }

  // READING FILE HANDLER
  private void readTheRegisteryFile() {
    try {
      FileInputStream fileInputStream = new FileInputStream("registry.data"); // MAKE A FILE
      InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,
          StandardCharsets.UTF_8);
      BufferedReader bufferReader = new BufferedReader(inputStreamReader);
      Scanner scanReader = new Scanner(bufferReader);
      while (scanReader.hasNextLine()) {
        String data = scanReader.nextLine();
        String[] elementValues = data.split(":"); // CREAT AN ARRAY TO HOLD THE ELEMENT VALUES

        if (elementValues[0].equalsIgnoreCase("MEMBER")) { // MEMBER
          boolean hasEmail = !elementValues[2].isEmpty();
          if (hasEmail) {
            this.members.add(new Member(elementValues[1], elementValues[3],
                elementValues[2])); // THE ARRAY INCLUDING EMAIL
          } else {
            this.members.add(new Member(elementValues[1], elementValues[3])); // NO EMAIL
          }
        } else {
          Member newAddedMember = this.members.get(this.members.size() - 1);
          String boatName = elementValues[1];

          if (elementValues[2].equalsIgnoreCase("sailBoat")) { // sailBoat
            SailBoat sailBoat = new SailBoat(boatName, Integer.parseInt(elementValues[3]),
                Integer.parseInt(elementValues[4]));
            newAddedMember.addBoat(sailBoat);
          } else if (elementValues[2].equalsIgnoreCase("motorBoat")) { // motorBoat
            MotorBoat motorboat = new MotorBoat(boatName, Integer.parseInt(elementValues[3]),
                Integer.parseInt(elementValues[4]));
            newAddedMember.addBoat(motorboat);
          } else if (elementValues[2].equalsIgnoreCase("canoe")) { // canoe
            Canoe canoe = new Canoe(boatName, Integer.parseInt(elementValues[3]));
            newAddedMember.addBoat(canoe);
          } else { // motorsailer
            MotorSailer motorsailer = new MotorSailer(boatName, Integer.parseInt(elementValues[3]),
                Integer.parseInt(elementValues[4]), Integer.parseInt(elementValues[5]));
            newAddedMember.addBoat(motorsailer);
          }
        }
      }
      scanReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("SOMETHING IS WRONG");
      e.printStackTrace();
    }
  }

  /**
   * This method does input data into the file.

   * @param members are the those who are kept in arrayList so their data to be save in the file.
   * @throws IOException this handles error.
   */

  // WRITING FILE HANDLER
  public void writeInTheRegisteryFile(ArrayList<Member> members) throws IOException {
    FileOutputStream fileOutputStream = new FileOutputStream("registry.data");
    OutputStreamWriter scanWriter = new OutputStreamWriter(fileOutputStream, "UTF-8");

    for (Member member : members) { // MEMBER:Member Name:optional email adress:member id
      scanWriter.write(String.format("MEMBER:%s:%s:%s%n", member.getName(),
          member.getEmail() == null ? "" : member.getEmail(), member.getId()));
      if (!member.getBoats().isEmpty()) { // IF A MEMBER OWNS A BOAT
        for (Boat boat : member.getBoats()) {
          if (boat instanceof SailBoat) {
            SailBoat sailBoat = (SailBoat) boat; // SailBoat
            scanWriter.write(String.format("BOAT:%s:%s:%s:%s%n", sailBoat.getName(),
                "sailBoat", sailBoat.getLength(), sailBoat.getDepth()));
          } else if (boat instanceof MotorSailer) {
            MotorSailer motorsailer = (MotorSailer) boat; // MotorSailer
            scanWriter.write(String.format("BOAT:%s:%s:%s:%s:%s%n", motorsailer.getName(),
                "motorsailer", motorsailer.getLength(), motorsailer.getDepth(),
                motorsailer.getEnginePower()));
          } else if (boat instanceof MotorBoat) {
            MotorBoat motorboat = (MotorBoat) boat; // MotorBoat
            scanWriter.write(String.format("BOAT:%s:%s:%s:%s%n", motorboat.getName(),
                "motorboat", motorboat.getLength(), motorboat.getEnginePower()));
          } else {
            Canoe canoe = (Canoe) boat; // Canoe
            scanWriter.write(String.format("BOAT:%s:%s:%s%n",
                canoe.getName(), "canoe", canoe.getLength()));
          }
        }
      }
    }
    scanWriter.close();
  }

  public ArrayList<Member> getMembers() {
    return this.members;
  }
}
//done
