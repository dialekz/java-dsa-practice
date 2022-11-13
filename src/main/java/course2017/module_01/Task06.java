package course2017.module_01;

import java.util.function.Function;

/**
 * Source:      Task06.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * {@code Task06} RESOLVING TIME: 20min
 *
 * @author dialekz
 */
class Task06 {
  private static final String[] TEST_STRINGS = {
      "aaaaaaaaaaaaaa",
      "bbbbbbbbbbbbbb",
      "ababababababab",
      "aabbccddeeffjj",
      "aaabbbcccdddee",
      "aaaabbbbccccaa",
      "abcdefghigklmn",
      "aabcdefghigklm",
      "aaabcdefghigkl",
      "aaaabcdefghigk",
      "aaaaabcdefghig",
      "aaaaaabcdefghi",
      "aaaaaaabcdefgh",
      "aaaaaaaabcdefg",
      "aaaaaaaaabcdef",
      "aaaaaaaaaabcde",
      "aaaaaaaaaaabcd",
      "aaaaaaaaaaaabc",
      "aaaaaaaaaaaaab",
      "aaaaaaaaaaaaaa"};

  public static void main(String[] args) {
    asserts(Task06::foo);
  }

  /**
   * Solution, O(N)
   */
  private static String foo(String a) {
    if (a == null || a.isEmpty())
      return "";

    int count = 0;
    char current = '0';
    char[] array = a.toCharArray();
    for (char c : array) {
      if (current != c) {
        count++;
        current = c;
      }
    }

    if (count * 2 >= a.length())
      return a;

    StringBuilder builder = new StringBuilder(count * 2);
    current = array[0];
    count = 0;

    for (char c : array) {
      if (current != c) {
        builder.append(current).append(count);
        current = c;
        count = 0;
      }
      count++;
    }
    builder.append(current).append(count);

    return builder.length() >= a.length() ? a : builder.toString();
  }

  private static void asserts(Function<String, String> function) {
    for (String s : TEST_STRINGS) {
      System.out.println(s + "  -->  " + function.apply(s));
    }
  }
}
