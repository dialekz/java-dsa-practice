package leetcode.task374GuessNumberHigherOrLower;

public class GuessGame {

  private final int pick;

  public GuessGame(int pick) {
    this.pick = pick;
  }

  /**
   * Forward declaration of guess API.
   *
   * @param num your guess
   * @return -1 if num is higher than the picked number
   * 1 if num is lower than the picked number
   * otherwise return 0
   * int guess(int num);
   */
  public int guess(int num) {
    return Integer.compare(pick, num);
  }
}
