package leetcode.task374GuessNumberHigherOrLower;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 1:
 * Input: n = 10, pick = 6
 * Output: 6
 * <p>
 * Example 2:
 * Input: n = 1, pick = 1
 * Output: 1
 * <p>
 * Example 3:
 * Input: n = 2, pick = 1
 * Output: 1
 */
class SolutionTest {

  @ParameterizedTest
  @CsvSource({"6, 10", "1, 1", "1, 2", "1702766719, 2126753390"})
  void testGuessNumber(int pick, int n) {
    Solution game = new Solution(pick);
    assertEquals(pick, game.guessNumber(n));
  }

  @ParameterizedTest
  @CsvSource({"6, 10", "1, 1", "1, 2", "1702766719, 2126753390"})
  void testGuessNumberRecursive(int pick, int n) {
    Solution game = new Solution(pick);
    assertEquals(pick, game.guessNumberRecursive(n));
  }
}