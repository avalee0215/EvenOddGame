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

  /**
   * Produce a random number by using the 'Random' mode and 'Top Strategy' mode in the strategy
   * interface. The first 3 rounds will use the Random mode. After the 3 rounds, the mode will use
   * the Top Strategy mode.
   */
  @Override
  public String play() {
    if (currentRound < 4) {
      strategy = new Random();
      this.randomNumber = strategy.randomNumber(); // First 3 rounds should use the random mode
      return String.valueOf(randomNumber);
    } else {
      strategy = new TopStrategy();
      strategy.oddorEven(countOdd, countEven, userChoice); // Update the current values
      this.randomNumber = strategy.randomNumber();

      return String.valueOf(randomNumber);
    }
  }

  /**
   * save current state values to use the appropriate method to produce the random number.
   *
   * @param round : current round
   * @param choice : what the user chose: odd or even
   */
  public void currentState(int round, String choice) {
    this.currentRound = round;
    this.userChoice = choice;
  }

  /**
   * save the numbers that count how many times the user typed each type of number
   *
   * @param odd : odd number count
   * @param even : even number count
   */
  public void countOddEven(int odd, int even) {
    this.countOdd = odd;
    this.countEven = even;
  }
}
