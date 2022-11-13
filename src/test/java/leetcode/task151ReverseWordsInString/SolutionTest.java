package leetcode.task151ReverseWordsInString;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SolutionTest {
  private final Solution solution = new Solution();

  /**
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

  @Test
  public void testReverseWords() {
    assertEquals("blue is sky the", solution.reverseWords("the sky is blue"));
    assertEquals("world hello", solution.reverseWords("  hello world  "));
    assertEquals("example good a", solution.reverseWords("a good   example"));
  }

  @Test
  public void testReverseWordsSimple() {
    assertEquals("blue is sky the", solution.reverseWordsSimple("the sky is blue"));
    assertEquals("world hello", solution.reverseWordsSimple("  hello world  "));
    assertEquals("example good a", solution.reverseWordsSimple("a good   example"));
  }

  @Test
  public void testReverseWordsOptimal() {
    assertEquals("blue is sky the", solution.reverseWordsOptimal("the sky is blue"));
    assertEquals("world hello", solution.reverseWordsOptimal("  hello world  "));
    assertEquals("example good a", solution.reverseWordsOptimal("a good   example"));
  }
}