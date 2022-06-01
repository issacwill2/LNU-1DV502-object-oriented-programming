package assignment4;

/**
 * sailboat is a of type boat.
 */
public class SailBoat extends Boat {
  private int depth;

  // Constructor
  public SailBoat(String name, int length, int depth) {
    super(name, length); // inherited
    this.depth = depth;
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  @Override
  public String toString() {
    return "SailBoat{Name = " + getName() + ", length = "
      + getLength() + ",  depth = " + depth + '}';
  }
}
// DONE
