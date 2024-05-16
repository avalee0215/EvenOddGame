package nz.ac.auckland.se281;

public class Easy implements GameLevel {
  @Override
  public String play() {
    int randomNumber = Utils.getRandomNumberRange(0, 5);
    return String.valueOf(randomNumber);
  }
}
