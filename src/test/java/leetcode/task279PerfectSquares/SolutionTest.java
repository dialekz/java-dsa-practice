package leetcode.task279PerfectSquares;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

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