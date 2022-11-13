package leetcode.task007ReverseInteger;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.reverse(0) == 0);
    System.out.println(solution.reverse(1) == 1);
    System.out.println(solution.reverse(-1) == -1);
    System.out.println(solution.reverse(12) == 21);
    System.out.println(solution.reverse(-12) == -21);
    System.out.println(solution.reverse(11) == 11);
    System.out.println(solution.reverse(10) == 1);
    System.out.println(solution.reverse(100) == 1);
    System.out.println(solution.reverse(1000) == 1);
    System.out.println(solution.reverse(12000) == 21);
    System.out.println(solution.reverse(10002) == 20001);
    System.out.println(solution.reverse(2003456781) == 1876543002);
    System.out.println(solution.reverse(2023456781) == 1876543202);
    System.out.println(solution.reverse(-2023456781) == -1876543202);
    System.out.println(solution.reverse(2023456789) == 0);
    System.out.println(solution.reverse(-2023456789) == 0);
  }

  public int reverse(int x) {
    long result = 0;
    while (x != 0) {
      result = result * 10 + x % 10;
      x /= 10;
      if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
        return 0;
      }
    }
    return (int) result;
  }

  public int reverseFirst(int x) {
    long longResult = 0L;
    int value, drop = 0;

    for (long step = 10L; drop != x; step *= 10) {
      value = (int) (x % step) - drop;
      drop += value;
      longResult = longResult * 10 + value * 10L / step;
    }

    return (longResult <= Integer.MAX_VALUE && longResult >= Integer.MIN_VALUE) ? (int) longResult : 0;
  }
}
