package leetcode.task907SumOfSubarrayMinimums;

import java.math.BigInteger;

class Solution {

  public int sumSubarrayMins(int[] arr) {
    BigInteger result = BigInteger.valueOf(0);
    int ndx;
    for (int size = 0; size < arr.length; size++) {
      ndx = -1;
      for (int from = 0, to = size; to < arr.length; from++, to++) {
        if (from == to)
          ndx = from;
        else if (ndx < from)
          ndx = findMinIndex(arr, from, to);
        else if (arr[ndx] >= arr[to])
          ndx = to;
        result = result.add(BigInteger.valueOf(arr[ndx]));
      }
    }

    if (result.compareTo(BigInteger.valueOf(Integer.MAX_VALUE)) <= 0)
      return result.intValue();
    else
      return result.mod(BigInteger.valueOf(1000000007)).intValue();
  }

  /**
   * @return index of min in arr segment
   */
  private int findMinIndex(int[] arr, int from, int to) {
    int ndx = from;
    for (int i = from; i <= to; i++) {
      ndx = arr[ndx] < arr[i] ? ndx : i;
    }
    return ndx;
  }
}
