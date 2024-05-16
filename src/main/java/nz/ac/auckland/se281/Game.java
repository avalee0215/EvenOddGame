package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // Count how many times the newGame is involked
  private int countRound = 0;
  private String userName = null;
  private String userChoiceString;
  private GameLevel level;
  private Choice userChoice;
  private int countOdd = 0;
  private int countEven = 0;
  private boolean loserOrWin = true; // true: the system lose

  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // the first element of options[0]; is the name of the player
    userName = options[0];
    userChoice = choice;
    userChoiceString = choice.name();
    switch (difficulty) {
      case EASY:
        level = new Easy();
        break;
      case MEDIUM:
        level = new Medium(); // Switch to Medium
        break;
      case HARD:
        level = new Hard(); // Swtich to Hard
        break;
    }
    MessageCli.WELCOME_PLAYER.printMessage(options[0]); // Task 1 Testing 1: Welcome_message
  }

  public void play() {
    // Task 1 Testing 2: Play command
    countRound++; // when the new game is clicked, the countnewgame will increase

    // if the chosen level is medium, upload the needed data
    if (level instanceof Medium) {
      ((Medium) level)
          .currentState(
              countRound,
              userChoiceString); // Update the current round and the choice of user(ODD or EVEN)
      // when the level is medium
      ((Medium) level).countOddEven(countOdd, countEven);
    }

    // if the chosen level is hard, upload the needed data
    if (level instanceof Hard) {
      ((Hard) level)
          .currentState(
              countRound, loserOrWin); // Needed data; current round, did the system lose or win
    }

    String countNewGameString = String.valueOf(countRound); // Change integer to string
    MessageCli.START_ROUND.printMessage(countNewGameString); // print the message
    // Task 1 Testing 3: ask for input
    boolean rightInput = true;
    String inputValue = null;
    int inputInt = 0;

    while (rightInput) {
      MessageCli.ASK_INPUT.printMessage(); // print out the message to ask input
      String input = Utils.scanner.nextLine(); // scan input
      inputInt = Integer.parseInt(input); // convert to int to check it is between 0 to 5
      if (inputInt < 0 || inputInt > 5) {
        MessageCli.INVALID_INPUT.printMessage();
      } else {
        inputValue = input;
        rightInput = false;
      }
    }

    String aiNumberString = level.play();
    int aiNumberInt = Integer.parseInt(aiNumberString);
    MessageCli.PRINT_INFO_HAND.printMessage(userName, inputValue);
    MessageCli.PRINT_INFO_HAND.printMessage("HAL-9000", aiNumberString);

    // save the previous values that the user typed.  AI can only get the values of the previous
    // rounds
    if (inputInt % 2 == 0) {
      countEven++;
    } else {
      countOdd++;
    }

    int sum = aiNumberInt + inputInt; // sum of the user and the saved ai created values;
    // if the sum is even, else is when the sum is odd
    if (sum % 2 == 0) {
      if (userChoice == Choice.EVEN) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(sum),
            "EVEN",
            userName); // when both sum and user choosed value is even, the winner is the user
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(sum),
            "EVEN",
            "HAL-9000"); // when sum and user choosed value is different, the winner is HAL-9000
        loserOrWin = false; // system won
      }
    } else {
      if (userChoice == Choice.ODD) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(sum),
            "ODD",
            userName); // when both sum and user choosed value is odd, the winner is the user
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(sum),
            "ODD",
            "HAL-9000"); // when sum and user choosed value is different, the winner is HAL-9000
        loserOrWin = false; // system won
      }
    }
  }

  public void endGame() {}

  public void showStats() {}
}
