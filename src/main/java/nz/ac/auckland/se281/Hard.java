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
  private String mode;

  /**
   * Produce a random number by using the 'Random' mode and 'Top Strategy' mode in the strategy
   * interface. The first 3 rounds will use the Random mode. After the 3 rounds, the mode will
   * change based on the previous mode that the system used and whether the system lost or won by
   * using that method.
   */
  @Override
  public String play() {
    if (currentRound < 4) {
      strategy = new Random();
      this.randomNumber = strategy.randomNumber(); // First 3 rounds should use the random mode
      this.mode = "random";
      return String.valueOf(randomNumber);
    } else {
      // if the system lose
      if (loserOrWin) {
        // if the previous method was random, switch to the Top Strategy mode.
        if (mode == "random") {
          strategy = new TopStrategy();
          strategy.oddorEven(countOdd, countEven, userChoice); // Update the current values
          this.mode = "Top";
          this.randomNumber = strategy.randomNumber();
          return String.valueOf(randomNumber);
        } else {
          // if the previous method was top, switch to the Random mode.
          strategy = new Random();
          this.randomNumber = strategy.randomNumber();
          this.mode = "random";
          return String.valueOf(randomNumber);
        }
      } else {
        // if the system won, keep the same method
        if (mode == "random") {
          strategy = new Random();
          this.randomNumber = strategy.randomNumber();
          this.mode = "random";
          return String.valueOf(randomNumber);
        } else {
          strategy = new TopStrategy();
          strategy.oddorEven(countOdd, countEven, userChoice); // Update the current values
          this.mode = "Top";
          this.randomNumber = strategy.randomNumber();
          return String.valueOf(randomNumber);
        }
      }
    }
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
