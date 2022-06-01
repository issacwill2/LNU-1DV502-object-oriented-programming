package assignment4;

/**
 * This is superclass of the four type of boats.
 */
public class Boat {

  // Attributes
  private String name;
  private int length;

  // Cobstructor
  public Boat(String name, int length) {
    this.name = name;
    this.length = length;
  }

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public String getName() {
    return name;
  }

  @Override
  public String toString() {
    return "Boat {  " + " length = " + length
            + ", name = ' " + name + '\'' + '}';
  }
}

// DONE
