package assignment4;

/**
 * Motorsailer is a of type boat.
 */
public class MotorSailer extends Boat {

  // Atributes
  private int enginePower;
  private int depth;

  /**
   * Constructor.

   * @param name .
   * @param length .
   * @param depth .
   * @param enginePower .
   */

  public MotorSailer(String name, int length, int depth, int enginePower) {
    super(name, length);  // inherited
    this.enginePower = enginePower;
    this.depth = depth;
  }

  public int getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(int enginePower) {
    this.enginePower = enginePower;
  }

  public int getDepth() {
    return depth;
  }

  public void setDepth(int depth) {
    this.depth = depth;
  }

  @Override
  public String toString() {
    return "MotorSailer { name = " + getName() + " length = " + getLength()
      + ", depth = " + depth + " engine_power = " + enginePower + '}';
  }
}
// DONE
