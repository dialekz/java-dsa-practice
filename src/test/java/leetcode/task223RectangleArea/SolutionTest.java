package leetcode.task223RectangleArea;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 1:
 * Input: ax1 = -3, ay1 = 0, ax2 = 3, ay2 = 4, bx1 = 0, by1 = -1, bx2 = 9, by2 = 2
 * Output: 45
 * <p>
 * Example 2:
 * Input: ax1 = -2, ay1 = -2, ax2 = 2, ay2 = 2, bx1 = -2, by1 = -2, bx2 = 2, by2 = 2
 * Output: 16
 */
class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  void computeArea() {
    assertEquals(45, solution.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    assertEquals(16, solution.computeArea(-2, -2, 2, 2, -2, -2, 2, 2));
  }
}