package nz.ac.auckland.se281;

/**
 * It represents a medium difficulty at the game level. Produce a random number. The number of
 * current rounds and the how many times the user used each type of number is important.
 *
 * @author: Chaeeun Lee
 */
public class Medium implements GameLevel {
  private Strategies strategy;
  private int currentRound;
  private String userChoice;
  private int countOdd;
  private int countEven;
  private int randomNumber;

  /** For the initial three rounds, set the strategy I am using is the random mode. */
  public Medium() {
    strategy = new Random();
  }

  /**
   * After the initial three rounds, the mode should be change, the mode should change to the Top
   * Stratety.
   */
  @Override
  public String play() {
    if (currentRound > 3) {
      strategy = new TopStrategy(countOdd, countEven, userChoice);
    }
    this.randomNumber = strategy.randomNumber();

    return String.valueOf(randomNumber);
  }

  /**
   * Save current state values to use the appropriate method to produce the random number.
   *
   * @param round : current round.
   * @param choice : what the user chose: odd or even.
   */
  public void currentState(int round, String choice) {
    this.currentRound = round;
    this.userChoice = choice;
  }

  /**
   * Save the numbers that count how many times the user typed each type of number.
   *
   * @param odd : odd number count.
   * @param even : even number count.
   */
  public void countOddEven(int odd, int even) {
    this.countOdd = odd;
    this.countEven = even;
  }
}
