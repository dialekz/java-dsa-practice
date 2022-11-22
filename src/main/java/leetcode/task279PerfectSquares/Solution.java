package leetcode.task279PerfectSquares;

import java.util.ArrayList;
import java.util.List;

public class Solution {

  public int numSquares(int n) {
    int i, value;
    List<Integer> values = new ArrayList<>();
    for (i = 1, value = 1; value <= n; i++, value = i * i) {
      values.add(value);
    }

    return numSquaresRec(n, values.size() - 1, 0, 1, -1, values);
  }

  private int numSquaresRec(int n, int i, int currentSum, int count, int result, List<Integer> values) {
    if (result != -1 && result <= count)
      return result;

    int tmp, applicant;

    for (; i >= 0; i--) {
      tmp = values.get(i) + currentSum;
      if (tmp == n)
        return count;
      else if (tmp < n) {
        applicant = numSquaresRec(n, i, tmp, count + 1, result, values);
        if (result == -1 || result > applicant)
          result = applicant;
      }
    }
    return result;
  }
}
