package leetcode.task1235MaximumProfitInJobScheduling;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  void jobScheduling1() {
    int[] startTime = {1, 2, 3, 3};
    int[] endTime = {3, 4, 5, 6};
    int[] profit = {50, 10, 40, 70};
    int expected = 120;
    assertEquals(expected, solution.jobScheduling(startTime, endTime, profit));
  }

  @Test
  void jobScheduling2() {
    int[] startTime = {1, 1, 1};
    int[] endTime = {2, 3, 4};
    int[] profit = {5, 6, 4};
    int expected = 6;
    assertEquals(expected, solution.jobScheduling(startTime, endTime, profit));
  }
}