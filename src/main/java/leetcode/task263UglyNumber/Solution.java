package leetcode.task263UglyNumber;

import java.util.List;

class Solution {

  private final List<Integer> factors = List.of(2, 3, 5);

  private int leftPart, rightPart;

  public boolean isUgly(int n) {
    if (n == 1 || factors.contains(n))
      return true;

    for (Integer f : factors) {
      rightPart = n % f;
      if (rightPart != 0)
        continue;

      leftPart = n / f;
      if (leftPart == 0)
        continue;

      if (isUgly(leftPart))
        return true;
    }
    return false;
  }
}
