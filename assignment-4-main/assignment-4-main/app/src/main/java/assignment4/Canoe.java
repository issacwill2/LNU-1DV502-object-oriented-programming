package assignment4;

/**
 * Canoe is a type of boat.
 */

public class Canoe extends Boat {
  public Canoe(String name, int length) {
    super(name, length);  // inherited
  }

  @Override
  public String toString() {
    return "Canoe { name = " + getName() + "" + ", length = " + getLength() + '}';
  }
}
// DONE
