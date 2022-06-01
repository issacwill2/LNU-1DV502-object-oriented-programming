package planetwithmoons;

/**
 * Print planet with moon.

 * @author William
 * @since   2014-02-06
 * @version 1.0
*/

public class PlanetWithMoonMain {

  /**
   * Planet With Moon.

   * @param args .
   * @throws Exception .
   */

  public static void main(String[] args) throws Exception {
    Planetwithmoon planetOneWithMoon = new Planetwithmoon("Mars", 3, 2, 152097701, 147098074);
    planetOneWithMoon.addMoon(new Moon("Phobos", 22));
    planetOneWithMoon.addMoon(new Moon("Deimos", 12));

    System.out.println();
    int count = 1;
    System.out.println("The planet is called " + planetOneWithMoon.getName()
        + " and has the following moons:");

    for (Moon moon : planetOneWithMoon.getMoons()) {
      System.out.println("  Moon " + count + " is called "
          + moon.getName() + " (" + moon.getSize() + "km)");
      count++;
    }

    Planetwithmoon planetTwoWithMoon = new Planetwithmoon("Earth", 4, 4, 249209300, 206669000);
    planetTwoWithMoon.addMoon(new Moon("The moon", 3474));

    System.out.println();
    count = 1;
    System.out.println("The planet is called " + planetTwoWithMoon.getName()
        + " and has the following moons:");

    for (Moon moon : planetTwoWithMoon.getMoons()) {
      System.out.println("  Moon " + count + " is called "
          + moon.getName() + " (" + moon.getSize() + "km)");
      count++;
    }
    System.out.println();
  }
}

// DONE
