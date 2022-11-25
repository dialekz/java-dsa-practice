package leetcode.task907SumOfSubarrayMinimums;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  void sumSubarrayMins1() {
    int[] arr = new int[]{3, 1, 2, 4};
    int expected = 17;
    assertEquals(expected, solution.sumSubarrayMins(arr));
  }

  @Test
  void sumSubarrayMins2() {
    int[] arr = new int[]{11, 81, 94, 43, 3};
    int expected = 444;
    assertEquals(expected, solution.sumSubarrayMins(arr));
  }

  @Test
  void sumSubarrayMins3() {
    int[] arr = new int[]{1};
    int expected = 1;
    assertEquals(expected, solution.sumSubarrayMins(arr));
  }

  @Test
  void sumSubarrayMins4() {
    int[] arr = new int[]{1, 2};
    int expected = 4;
    assertEquals(expected, solution.sumSubarrayMins(arr));
  }

  @Test
  void sumSubarrayMins5() {
    int[] arr = new int[]{1, 1};
    int expected = 3;
    assertEquals(expected, solution.sumSubarrayMins(arr));
  }

  @Test
  void sumSubarrayMins6() {
    int[] arr = new int[]{1, 2, 3};
    int expected = 10;
    assertEquals(expected, solution.sumSubarrayMins(arr));
  }

  @Test
  void sumSubarrayMins7() {
    int[] arr = new int[]{3,2,1};
    int expected = 10;
    assertEquals(expected, solution.sumSubarrayMins(arr));
  }

}