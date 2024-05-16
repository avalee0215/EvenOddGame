package nz.ac.auckland.se281;

public class Hard implements GameLevel {
  Strategies strategy;
  private int currentRound;
  private int randomNumber;
  private boolean loserOrWin;

  @Override
  public String play() {
    if (currentRound < 4) {
      strategy = new Random();
      this.randomNumber = strategy.randomNumber(); // First 3 rounds should use the random mode
      return String.valueOf(randomNumber);
    } else {
      return null; // Different from Medium level at this part
    }
  }

  public void currentState(int round, boolean change) {
    this.currentRound = round;
    this.loserOrWin = change;
  }
}
