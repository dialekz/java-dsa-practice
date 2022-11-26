package leetcode.task907SumOfSubarrayMinimums;

import java.util.LinkedList;
import java.util.List;

class Solution {

  public int sumSubarrayMins(int[] arr) {
    long result = 0;
    List<Long> results = new LinkedList<>();
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

        result += arr[ndx];
        if (result > Integer.MAX_VALUE) {
          results.add(result);
          result = 0;
        }
      }
    }

    if (results.isEmpty())
      return (int) result;
    else
      return (int) (results.stream().mapToLong(Long::longValue).map(l -> l % 1000000007).sum() % 1000000007);
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
