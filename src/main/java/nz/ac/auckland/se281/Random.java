package nz.ac.auckland.se281;

public class Random implements Strategies {
  private String oddorEven = null;

  @Override
  public int randomNumber() {
    return Utils.getRandomNumberRange(0, 5);
  }

  @Override
  public String oddorEven(int odd, int even, String choice) {
    return oddorEven;
  }
}
