package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // Count how many times the newGame is involked
  private int countNewGame = 0;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    countNewGame++; // when the new game is clicked, the countnewgame will increase
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // Task 1 Testing 1: Welcome_message
  }

  public void play() {
    // Task 1 Testing 2: Play command
    String countNewGameString = String.valueOf(countNewGame); // Change integer to string
    MessageCli.START_ROUND.printMessage(countNewGameString); // print the message
    // Task 1 Testing 3: ask for input
    MessageCli.ASK_INPUT.printMessage();
  }

  public void endGame() {}

  public void showStats() {}
}
