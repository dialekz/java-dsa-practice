package leetcode.task374GuessNumberHigherOrLower;

/**
 * We are playing the Guess Game. The game is as follows:
 * <p>
 * I pick a number from 1 to n. You have to guess which number I picked.
 * <p>
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 * <p>
 * You call a pre-defined API int guess(int num), which returns three possible results:
 * <p>
 * -1: Your guess is higher than the number I picked (i.e. num > pick).
 * 1: Your guess is lower than the number I picked (i.e. num < pick).
 * 0: your guess is equal to the number I picked (i.e. num == pick).
 * Return the number that I picked.
 */
public class Solution extends GuessGame {

  public Solution(int pick) {
    super(pick);
  }

  public int guessNumber(int n) {
    int i, guess, from = 1, to = n;
    while (to >= from) {
      i = (int) (((long) from + (long) to) / 2);
      guess = guess(i);
      switch (guess) {
        case -1:
          to = (i == to) ? --i : i;
          break;
        case 1:
          from = (i == from) ? ++i : i;
          break;
        case 0:
          return i;
      }
    }
    throw new RuntimeException("Unexpected guess result");
  }

  public int guessNumberRecursive(int n) {
    return guessNumberRecursive(1, n);
  }

  private int guessNumberRecursive(int from, int to) {
    int i = (int) (((long) from + (long) to) / 2);
    int guess = guess(i);
    switch (guess) {
      case -1:
        return (i == to) ? guessNumberRecursive(from, i - 1) : guessNumberRecursive(from, i);
      case 1:
        return (i == from) ? guessNumberRecursive(i + 1, to) : guessNumberRecursive(i, to);
      case 0:
        return i;
    }
    throw new RuntimeException("Unexpected guess result");
  }
}
