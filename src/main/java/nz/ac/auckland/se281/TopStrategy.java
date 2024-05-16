package nz.ac.auckland.se281;

public class TopStrategy implements Strategies {
  private String oddorEven; // which numbers that the user used more? odd or even?
  private String userChoice; // user guessed type: odd or even

  @Override
  public int randomNumber() {
    return 0;
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
