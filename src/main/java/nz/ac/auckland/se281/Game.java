package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Choice;
import nz.ac.auckland.se281.Main.Difficulty;

/** This class represents the Game is the main entry point. */
public class Game {
  // Count how many times the newGame is involked
  private int countRound = -1; // when the new_game has never typed, the value is -1
  private String userName = null;
  private String userChoiceString;
  private GameLevel level;
  private Choice userChoice;
  private int countOdd = 0;
  private int countEven = 0;
  private boolean loserOrWin = true; // true: the system lose
  private int userWin = 0;
  private int aiWin = 0;

  /**
   * This class save the information of the new game.
   *
   * @param difficulty : Input value that the user choose the difficulty of game levels from easy,
   *     medium, or hard.
   * @param choice : Input value that the user choose odd or even.
   * @param options : Input value showing the name of the user.
   */
  public void newGame(Difficulty difficulty, Choice choice, String[] options) {
    // Initialise the values
    countRound = 0;
    countOdd = 0;
    countEven = 0;
    userName = null;
    userChoiceString = null;
    userWin = 0;
    aiWin = 0;

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

  /**
   * Plays the game based on the information from the new_game. User should type the value between 0
   * and 5 A result of this round is printed out after the game.
   */
  public void play() {
    // Error message: new_game has not been typed
    if (countRound == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }
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
              countRound,
              userChoiceString,
              loserOrWin); // Update the needed data. This time, include the boolean value
      ((Hard) level).countOddEven(countOdd, countEven);
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
        loserOrWin = true; // system lose
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
        loserOrWin = true; // system lose
      } else {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage(
            String.valueOf(sum),
            "ODD",
            "HAL-9000"); // when sum and user choosed value is different, the winner is HAL-9000
        loserOrWin = false; // system won
      }
    }

    // update the userWin and aiWin value based on the loseOrWin value
    if (loserOrWin) {
      userWin++;
    } else {
      aiWin++;
    }
  }

  /** End the game by print the statistical value and the result (who wins). */
  public void endGame() {
    // Error message: new_game has not been typed
    if (countRound == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print out the stats messages
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        userName, String.valueOf(userWin), String.valueOf(aiWin));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWin), String.valueOf(userWin));

    // show who wins
    if (userWin > aiWin) {
      MessageCli.PRINT_END_GAME.printMessage(userName);
    } else if (userWin < aiWin) {
      MessageCli.PRINT_END_GAME.printMessage("HAL-9000");
    } else {
      MessageCli.PRINT_END_GAME_TIE.printMessage();
    }

    // Initialise the values
    countRound = -1;
    countOdd = 0;
    countEven = 0;
    userName = null;
    userChoiceString = null;
    userWin = 0;
    aiWin = 0;
  }

  /** Show the statistical values that show who wins and loses how many times. */
  public void showStats() {
    // Error message: new_game has not been typed
    if (countRound == -1) {
      MessageCli.GAME_NOT_STARTED.printMessage();
      return;
    }

    // print out the stats messages
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        userName, String.valueOf(userWin), String.valueOf(aiWin));
    MessageCli.PRINT_PLAYER_WINS.printMessage(
        "HAL-9000", String.valueOf(aiWin), String.valueOf(userWin));
  }
}
