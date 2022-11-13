package leetcode.task151ReverseWordsInString;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 151. Reverse Words in a String
 * <p>
 * Given an input string s, reverse the order of the words.
 * <p>
 * A word is defined as a sequence of non-space characters.
 * The words in s will be separated by at least one space.
 * <p>
 * Return a string of the words in reverse order concatenated by a single space.
 * <p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words.
 * Do not include any extra spaces.
 * <p>
 * Example 1:
 * Input: s = "the sky is blue"
 * Output: "blue is sky the"
 * <p>
 * Example 2:
 * Input: s = "  hello world  "
 * Output: "world hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * <p>
 * Example 3:
 * Input: s = "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 */
class Solution {

  public String reverseWords(String s) {
    final StringBuilder result = new StringBuilder(s.length());
    final StringBuilder word = new StringBuilder();

    new StringBuilder(s.trim()).chars()
        .mapToObj(c -> (char) c)
        .forEach(c -> {
          if (!c.equals(' ')) {
            word.append(c);
          } else {
            if (word.length() > 0)
              word.insert(0, ' ');

            result.insert(0, word);
            word.delete(0, word.length());
          }
        });

    return result.insert(0, word).toString();
  }

  public String reverseWordsSimple(String s) {
    final LinkedList<String> result = new LinkedList<>();
    Arrays.stream(s.trim().split(" "))
        .filter(str -> !str.isBlank())
        .forEachOrdered(str -> result.addFirst(str.trim()));
    return String.join(" ", result);
  }


  public String reverseWordsOptimal(String s) {
    final char[] src = s.trim().toCharArray();
    final StringBuilder result = new StringBuilder(src.length);

    boolean multiSpace = false;
    int wordCount = 0;

    for (char c : src) {
      if (c == ' ' && !multiSpace) {
        result.insert(0, c);
        multiSpace = true;
        wordCount = 0;
      } else if (c != ' ') {
        result.insert(wordCount++, c);
        multiSpace = false;
      }
    }

    return result.toString();
  }
}
