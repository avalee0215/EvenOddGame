package nz.ac.auckland.se281;

/** A interface for different modes to produce a random number. */
public interface Strategies {
  int randomNumber();

  String oddorEven(int odd, int even, String choice);
}
