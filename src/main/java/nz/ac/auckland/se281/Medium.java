package nz.ac.auckland.se281;

public class Medium implements GameLevel {
  Strategies strategy;
  private int currentRound;
  private String userChoice;

  @Override
  public String play() {
    return null;
  }

  public void currentState(int round, String choice) {
    this.currentRound = round;
    this.userChoice = choice;
  }
}
