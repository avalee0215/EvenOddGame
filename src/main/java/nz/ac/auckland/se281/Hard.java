package nz.ac.auckland.se281;

public class Hard implements GameLevel {
  Strategies strategy;
  private int currentRound;
  private String userChoice;
  private int countOdd;
  private int countEven;
  private int randomNumber;
  private boolean loserOrWin;
  private String mode;

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

  public void currentState(int round, String choice, boolean change) {
    this.currentRound = round;
    this.userChoice = choice;
    this.loserOrWin = change;
  }

  public void countOddEven(int odd, int even) {
    this.countOdd = odd;
    this.countEven = even;
  }
}
