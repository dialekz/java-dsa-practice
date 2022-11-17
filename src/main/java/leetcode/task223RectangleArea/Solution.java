package leetcode.task223RectangleArea;

/**
 * Given the coordinates of two rectilinear rectangles in a 2D plane,
 * return the total area covered by the two rectangles.
 * <p>
 * The first rectangle is defined by its bottom-left corner (ax1, ay1)
 * and its top-right corner (ax2, ay2).
 * <p>
 * The second rectangle is defined by its bottom-left corner (bx1, by1)
 * and its top-right corner (bx2, by2).
 */
class Solution {

  public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
    int x = calcLine(ax1, ax2, bx1, bx2);
    int y = calcLine(ay1, ay2, by1, by2);
    return calcArea(ax1, ax2, ay1, ay2) + calcArea(bx1, bx2, by1, by2) - (x * y);
  }

  private int calcLine(int a1, int a2, int b1, int b2) {
    int left = Integer.compare(a1, b1);
    int right = Integer.compare(a2, b2);
    long result;
    if (left == right) {
      result = Long.min((long) a2 - b1, (long) b2 - a1);
    } else {
      result = Long.min((long) a2 - a1, (long) b2 - b1);
    }
    return Long.valueOf(Long.max(result, 0)).intValue();
  }

  private int calcArea(int x1, int x2, int y1, int y2) {
    return (x2 - x1) * (y2 - y1);
  }
}
