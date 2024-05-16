package nz.ac.auckland.se281;

public class Medium implements GameLevel {
  Strategies strategy;
  private int currentRound;
  private String userChoice;
  private int countOdd;
  private int countEven;
  private int randomNumber;

  @Override
  public String play() {
    if (currentRound < 4) {
      strategy = new Random();
      this.randomNumber = strategy.randomNumber(); // First 3 rounds should use the random mode
      return String.valueOf(randomNumber);
    }
    return null;
  }

  public void currentState(int round, String choice) {
    this.currentRound = round;
    this.userChoice = choice;
  }

  public void countOddEven(int odd, int even) {
    this.countOdd = odd;
    this.countEven = even;
  }
}
