package nz.ac.auckland.se281;

/**
 * Represents a Random mode of Strategies. It will produce a number between 0 and 5 (inclusive).
 *
 * @author Chaeeun Lee
 */
public class Random implements Strategies {
  private String oddorEven = null;

  /** Produce a number between 0 and 5 and return the integer value. */
  @Override
  public int randomNumber() {
    return Utils.getRandomNumberRange(0, 5);
  }

  /** return the null String value. This class is useful for the TopStrategy. */
  @Override
  public String oddorEven(int odd, int even, String choice) {
    return oddorEven;
  }
}
