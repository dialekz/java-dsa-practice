package leetcode.task006ZigZagConversion;

public class Solution {
  public static void main(String[] args) {
    Solution solution = new Solution();

    System.out.println(solution.convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));
    System.out.println(solution.convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI"));
    System.out.println(solution.convert("abababab", 2).equals("aaaabbbb"));
    System.out.println(solution.convert("abababab", 1).equals("abababab"));
  }

  public String convert(String s, int numRows) {
    if (s == null || numRows == 0) {
      return "";
    }

    StringBuilder result = new StringBuilder(s.length());
    char[] arr = s.toCharArray();
    int initStep = (numRows - 1) * 2;
    initStep = initStep > 0 ? initStep : 1;

    for (int i = 0; i < numRows; i++) {
      int stepOne = initStep - i * 2;
      int stepTwo = initStep - stepOne;
      boolean isFirst = true;
      for (int j = i; j < arr.length; ) {
        result.append(arr[j]);
        if (stepOne == 0) {
          j += stepTwo;
        } else if (stepTwo == 0) {
          j += stepOne;
        } else {
          j += isFirst ? stepOne : stepTwo;
        }
        isFirst = !isFirst;
      }
    }

    return result.toString();
  }
}
