package nz.ac.auckland.se281;

/**
 * Represents a Easy difficulty of gamelevel. Produce a random number. It doesn't matter how many
 * times the rounds are played
 *
 * @author Chaeeun Lee
 */
public class Easy implements GameLevel {
  private Strategies strategy;

  /** Produce a random number by using the 'Random' mode in the strategy interface. */
  @Override
  public String play() {
    strategy = new Random();
    int randomNumber = strategy.randomNumber(); // Change to use Strategies interface
    return String.valueOf(randomNumber);
  }
}
