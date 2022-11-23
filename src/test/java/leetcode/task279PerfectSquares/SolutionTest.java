package leetcode.task279PerfectSquares;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 1:
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * <p>
 * Example 2:
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */
class SolutionTest {

  private final Solution solution = new Solution();

  @ParameterizedTest
  @CsvSource({
      "12, 3",
      "13, 2",
      "1, 1",
      "2, 2",
      "3, 3",
      "4, 1",
      "10000, 1",
      "9999, 4"})
  void numSquares(int n, int expected) {
    assertEquals(expected, solution.numSquares(n));
  }
}