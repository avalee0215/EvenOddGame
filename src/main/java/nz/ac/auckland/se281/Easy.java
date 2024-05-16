package nz.ac.auckland.se281;

public class Easy implements GameLevel {
  Strategies strategy;

  @Override
  public String play() {
    strategy = new Random();
    int randomNumber = strategy.randomNumber(); // Change to use Strategies interface
    return String.valueOf(randomNumber);
  }
}
