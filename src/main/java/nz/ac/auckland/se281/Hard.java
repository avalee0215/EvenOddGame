package nz.ac.auckland.se281;

/**
 * It represents a hard difficulty at the game level. Produce a random number. The number of current
 * rounds and the result of the previous round are important.
 *
 * @author: Chaeeun Lee
 */
public class Hard implements GameLevel {
  private Strategies strategy;
  private int currentRound;
  private String userChoice;
  private int countOdd;
  private int countEven;
  private int randomNumber;
  private boolean loserOrWin;

  /** For the initial three rounds, set the strategy I am using is the random mode. */
  public Hard() {
    strategy = new Random();
  }

  /**
   * After the initial three rounds, the mode should be change based on the previous round result.
   * When the system lose, and the strategy was random, switch to the top strategy. Vice versa.
   */
  @Override
  public String play() {
    // After the initial three round,
    if (currentRound > 3) {
      // if the system lose for the previous round, change the method. Random to Top strategy, or
      // Top strategy to random.
      if (loserOrWin) {
        strategy =
            (strategy instanceof Random)
                ? new TopStrategy(countOdd, countEven, userChoice)
                : new Random();
      }
    }

    // Return the string value of the random number produced by using appropriate mode
    this.randomNumber = strategy.randomNumber();
    return String.valueOf(randomNumber);
  }

  /**
   * Save current state values to use the appropriate method to produce the random number.
   *
   * @param round : current round.
   * @param choice : what the user chose: odd or even.
   * @param change : the system lose or not at the previous game.
   */
  public void currentState(int round, String choice, boolean change) {
    this.currentRound = round;
    this.userChoice = choice;
    this.loserOrWin = change;
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
