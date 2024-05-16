package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // Count how many times the newGame is involked
  private int countRound = 0;
  private String userName = null;

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    userName = options[0];
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // Task 1 Testing 1: Welcome_message
  }

  public void play() {
    // Task 1 Testing 2: Play command
    countRound++; // when the new game is clicked, the countnewgame will increase
    String countNewGameString = String.valueOf(countRound); // Change integer to string
    MessageCli.START_ROUND.printMessage(countNewGameString); // print the message
    // Task 1 Testing 3: ask for input
    boolean rightInput = true;
    String inputValue = null;
    while (rightInput) {
      MessageCli.ASK_INPUT.printMessage(); // print out the message to ask input
      String input = Utils.scanner.nextLine(); // scan input
      int inputInt = Integer.parseInt(input); // convert to int to check it is between 0 to 5
      if (inputInt < 0 || inputInt > 5) {
        MessageCli.INVALID_INPUT.printMessage();
      } else {
        inputValue = input;
        rightInput = false;
      }
    }
    MessageCli.PRINT_INFO_HAND.printMessage(userName, inputValue);
  }

  public void endGame() {}

  public void showStats() {}
}
