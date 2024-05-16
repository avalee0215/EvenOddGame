package nz.ac.auckland.se281;

public class Hard implements GameLevel {
  Strategies strategy;
  private int currentRound;
  private String userChoice;
  private int countOdd;
  private int countEven;
  private int randomNumber;
  private boolean loserOrWin;

  @Override
  public String play() {
    if (currentRound < 4) {
      strategy = new Random();
      this.randomNumber = strategy.randomNumber(); // First 3 rounds should use the random mode
      return String.valueOf(randomNumber);
    } else {
      return null;
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
