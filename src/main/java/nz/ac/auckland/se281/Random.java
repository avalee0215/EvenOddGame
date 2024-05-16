package nz.ac.auckland.se281;

public class Random implements Strategies {
  @Override
  public int randomNumber() {
    return Utils.getRandomNumberRange(0, 5);
  }
}
