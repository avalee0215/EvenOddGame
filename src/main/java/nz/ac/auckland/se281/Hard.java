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
   * Produce a random number by using the 'Random' mode and 'Top Strategy' mode in the strategy
   * interface. The first 3 rounds will use the Random mode. After the 3 rounds, the mode will
   * change based on the previous mode that the system used and whether the system lost or won by
   * using that method.
   */
  @Override
  public String play() {
    if (currentRound > 3) {
      if (loserOrWin) {
        strategy =
            (strategy instanceof Random)
                ? new TopStrategy(countOdd, countEven, userChoice)
                : new Random();
      }
    }
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
