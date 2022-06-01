package assignment4;

/**
 * MotorBoat is a type of boat.
 */

public class MotorBoat extends Boat {

  // Attribute
  private int enginePower;

  // Constructor
  public MotorBoat(String name, int length, int enginePower) {
    super(name, length);  // inherited
    this.enginePower = enginePower;
  }

  public int getEnginePower() {
    return enginePower;
  }

  public void setEnginePower(int enginePower) {
    this.enginePower = enginePower;
  }

  @Override
  public String toString() {
    return "MotorBoat{ name = " + getName() + ", length = " + getLength()
      + ", engine_power = " + enginePower + '}';
  }
}
// DONE
