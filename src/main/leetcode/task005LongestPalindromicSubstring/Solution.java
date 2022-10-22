package leetcode.task005LongestPalindromicSubstring;

public class Solution {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.longestPalindrome("bb"));       // bb
    System.out.println(solution.longestPalindrome("aaaa"));     // aaaa
    System.out.println(solution.longestPalindrome("ccc"));      // ccc

    System.out.println(solution.longestPalindrome(""));         //
    System.out.println(solution.longestPalindrome("a"));        // a
    System.out.println(solution.longestPalindrome("ab"));       // a
    System.out.println(solution.longestPalindrome("aba"));      // aba
    System.out.println(solution.longestPalindrome("abba"));     // abba
    System.out.println(solution.longestPalindrome("abac"));     // aba
    System.out.println(solution.longestPalindrome("acab"));     // aca
    System.out.println(solution.longestPalindrome("cdda"));     // dd
    System.out.println(solution.longestPalindrome("babcd"));    // bab
    System.out.println(solution.longestPalindrome("cbbab"));    // bab
    System.out.println(solution.longestPalindrome("cbbabcd"));  // bab
  }

  public String longestPalindrome(String s) {
    char[] arr = s != null ? s.toCharArray() : new char[]{};
    String result = "";

    if (arr.length >= 1) {
      result = String.valueOf(arr[0]);
    }

    for (int i = 1; i < arr.length; i++) {
      int left, right;
      if (arr[i] == arr[i - 1]) {
        left = i - 1;
        right = i;
        result = checkPalindrome(arr, result, left, right);
      }
      if (i + 1 < arr.length && arr[i + 1] == arr[i - 1]) {
        left = i - 1;
        right = i + 1;
        result = checkPalindrome(arr, result, left, right);
      }
    }

    return result;
  }

  private String checkPalindrome(char[] arr, String result, int left, int right) {
    while (--left >= 0 & ++right < arr.length) {
      if (arr[left] != arr[right]) {
        break;
      }
    }

    int len = right - left - 1;
    return result.length() >= len ? result : String.valueOf(arr, left + 1, len);
  }
}
