package leetcode.task907SumOfSubarrayMinimums;

import java.util.Stack;


/**
 * Given an array of integers arr, find the sum of min(b),
 * where b ranges over every (contiguous) subarray of arr.
 * Since the answer may be large, return the answer modulo 109 + 7.
 */
class Solution {

  public int sumSubarrayMins(int[] arr) {
    long result = 0;
    int ndx, prev, from, to, current, mod = 1000000007;

    Stack<Integer> stack = new Stack<>();
    stack.push(-1);

    for (int i = 0; i <= arr.length; i++) {
      current = i == arr.length ? 0 : arr[i];
      while (stack.peek() != -1 && current < arr[stack.peek()]) {
        ndx = stack.pop();
        prev = stack.peek();
        from = ndx - prev;
        to = i - ndx;

        result += ((long) from * to * arr[ndx]) % mod;
      }
      stack.push(i);
    }

    return (int) (result % mod);
  }
}
