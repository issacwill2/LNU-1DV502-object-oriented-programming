package assignment4;

import java.util.ArrayList;

/**
 * MEMBER CLASS WITH ATTRIBUTES.
 */

public class Member {
  // Attributes
  private String name;
  private String email;
  private String id;
  private ArrayList<Boat> myBoats = new ArrayList<>();

  public Member() {  // empty Constructor
  }

  // Constructor
  public Member(String name, String id) {
    this.name = name;
    this.id = id;
  }

  /**
   * Constructor with optional email as an attribute.

   * @param name .
   * @param id .
   * @param email .
   */

  public Member(String name, String id, String email) {
    this.name = name;
    this.id = id;
    this.email = email;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  // Add boats in the ArrayList "myBoats" above
  public void addBoat(Boat newBoat) { 
    myBoats.add(newBoat);
  }

  protected ArrayList<Boat> getBoats() {
    return myBoats;
  }

  @Override
  public String toString() {
    return "Member { " + " Member Name = ' " + name + '\'' + ", email = ' "
      + email + '\'' + ", id = ' " + id + '\'' + '}';
  }
}
// DONE
