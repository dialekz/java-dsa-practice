package leetcode.task224BasicCalculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 1:
 * Input: s = "1 + 1"
 * Output: 2
 * <p>
 * Example 2:
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * <p>
 * Example 3:
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 */
class SolutionTest {

  private final Solution solution = new Solution();

  @ParameterizedTest
  @CsvSource({
      "1 + 1, 2",
      "-1, -1",
      "2-1 + 2, 3",
      "(1+(4+5+2)-3)+(6+8), 23",
      "- (3 + (4 + 5)), -12",
      "- ((3 + 4) + 5), -12",
      "(7)-(0)+(4), 11"
  })
  public void calculate(String input, int expected) {
    assertEquals(expected, solution.calculate(input));
  }

}