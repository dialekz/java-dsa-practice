package leetcode.task263UglyNumber;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

class SolutionTest {

  private final Solution solution = new Solution();

  @ParameterizedTest
  @CsvSource({"6, true", "1, true", "8, true", "14, false"})
  void isUgly(int n, boolean expected) {
    assertEquals(expected, solution.isUgly(n));
  }

  @Test
  void isUglyStackOverflow() {
    assertFalse(solution.isUgly(2147483647));
  }
}