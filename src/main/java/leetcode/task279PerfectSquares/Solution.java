package leetcode.task279PerfectSquares;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 * <p>
 * A perfect square is an integer that is the square of an integer;
 * in other words, it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
public class Solution {

  public int numSquares(int n) {
    int i, value;
    List<Integer> values = new ArrayList<>();
    for (i = 1, value = 1; value <= n; i++, value = i * i) {
      values.add(value);
    }

    return numSquaresRec(n, values.size() - 1, 0, 1, n, values);
  }

  private int numSquaresRec(int n, int i, int currentSum, int count, int result, List<Integer> values) {
    if (result <= count)
      return result;

    int tmp, applicant;

    for (; i >= 0; i--) {
      tmp = values.get(i) + currentSum;
      if (tmp == n)
        return count;
      else if (tmp < n) {
        applicant = numSquaresRec(n, i, tmp, count + 1, result, values);
        if (result > applicant)
          result = applicant;
      }
    }
    return result;
  }
}
