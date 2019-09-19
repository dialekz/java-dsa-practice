package leetcode.task003LongestWithoutRepeating;

public class Solution {

    public int lengthOfLongestSubstring(String s) {
        byte[] letters = new byte[1000];
        char[] arr = s.toCharArray();

        int count = 0;
        int max = 0;

        int left = 0;
        for (char rightChar : arr) {
            if (letters[rightChar] == 0) {
                letters[rightChar] = 1;
                count++;
            } else {
                max = Math.max(max, count);

                char leftChar = arr[left];
                while (true) {
                    left++;

                    if (leftChar == rightChar) {
                        break;
                    }

                    count--;
                    letters[leftChar] = 0;
                    leftChar = arr[left];
                }
            }
        }
        max = Math.max(max, count);
        return max;
    }

    public static void main(String[] args) {
        var solution = new Solution();

        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));  // 3
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));    // 3
        System.out.println();
        System.out.println(solution.lengthOfLongestSubstring("a"));         // 1
        System.out.println(solution.lengthOfLongestSubstring("aa"));        // 1
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));     // 1
        System.out.println();
        System.out.println(solution.lengthOfLongestSubstring("asdfaa"));    // 4
        System.out.println(solution.lengthOfLongestSubstring("aaasdf"));    // 4
        System.out.println();
        System.out.println(solution.lengthOfLongestSubstring("abcadf"));    // 5
        System.out.println(solution.lengthOfLongestSubstring("abcbdf"));    // 4
    }
}
