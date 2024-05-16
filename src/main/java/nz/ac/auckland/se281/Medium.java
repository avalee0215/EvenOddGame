package nz.ac.auckland.se281;

public class Medium implements GameLevel {
  Strategies strategy;
  private int currentRound;
  private String userChoice;
  private int countOdd;
  private int countEven;

  @Override
  public String play() {
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
