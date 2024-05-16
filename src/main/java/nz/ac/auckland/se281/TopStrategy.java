package nz.ac.auckland.se281;

public class TopStrategy implements Strategies {
  private String oddorEven; // which numbers that the user used more? odd or even?
  private String userChoice; // user guessed type: odd or even

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
        return Utils
            .getRandomEvenNumber(); // even + even = even. Therefore, the random number should be
        // even
      }
    } else {
      return Utils.getRandomNumberRange(
          0,
          5); // when  the player has played an equal number of ODD and EVEN numbers, the AI will
              // resort to a random selection between 0 and 5.
    }
  }

  public String oddorEven(int odd, int even, String choice) {
    this.userChoice = choice;
    if (odd > even) {
      this.oddorEven =
          "ODD"; // If the user used odd numbers more than the even number, save it "odd". This
      // value will be useful in the randomNumber.

    } else {
      this.oddorEven =
          "EVEN"; // If the user used even numbers more than the even number, save it "even".
    }

    return oddorEven;
  }
}
