package nz.ac.auckland.se281;

/**
 * Represents a Top Strategy mode of Strategies. It will produce a number based on the situation.
 *
 * @author Chaeeun Lee
 */
public class TopStrategy implements Strategies {
  private String oddorEven = null; // which numbers that the user used more? odd or even?
  private String userChoice; // user guessed type: odd or even

  /**
   * Update the data needed to use the top strategy mode. Also, Check what type of number is more
   * frequently used by the user (odd or even).
   */
  public TopStrategy(int odd, int even, String choice) {
    this.userChoice = choice;
    if (odd > even) {
      this.oddorEven =
          "ODD"; // If the user used odd numbers more than the even number, save it "odd". This
      // value will be useful in the randomNumber.

    } else if (odd < even) {
      this.oddorEven =
          "EVEN"; // If the user used even numbers more than the even number, save it "even".
    }
  }

  /**
   * Based on what kind of number the user used more and what the user chose as an answer, the type
   * (odd or even) of the random number that is produced will be different.
   */
  @Override
  public int randomNumber() {
    if (oddorEven == "ODD") {
      // To win, the sum should be even
      if (userChoice == "ODD") {
        return Utils
            .getRandomOddNumber(); // odd + odd  = even. Therefore, the random number should be odd
      } else {
        // To win, the sum should be odd
        return Utils
            .getRandomEvenNumber(); // odd + even = odd. So, the random number should be even
      }
    } else if (oddorEven == "EVEN") {
      // To win, the sum should be odd
      if (userChoice == "EVEN") {
        return Utils.getRandomOddNumber(); // even + odd = even. So, the random number should be odd
      } else {
        // To win, the sum should be even
        return Utils.getRandomEvenNumber(); // even + even = even. So, the random number is even
      }
    } else {
      return Utils.getRandomNumberRange(0, 5); // Same EVEN and ODD numbers will use the Random mode
    }
  }
}
