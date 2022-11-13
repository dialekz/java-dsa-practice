package course2017.module_01;

import java.util.function.BiPredicate;

/**
 * Source:      Task05.java
 * Created:     05.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task05} RESOLVING TIME: 30min
 *
 * @author dialekz
 */
class Task05 {

  public static void main(String[] args) {
    asserts(Task05::foo);
  }

  /**
   * Solution, O(N)
   */
  private static boolean foo(String a, String b) {
    if (a == null || b == null)
      return false;

    if (Math.abs(a.length() - b.length()) > 1)
      return false;

    char[] arrayA = a.toCharArray();
    char[] arrayB = b.toCharArray();
    int step = a.length() - b.length();
    boolean needChange = false;

    for (int i = 0, j = 0; i < a.length() && j < b.length(); i++, j++) {
      if (arrayA[i] != arrayB[j]) {
        if (needChange)
          return false;

        needChange = true;
        if (step > 0) {
          j--;
        } else if (step < 0) {
          i--;
        }
      }
    }
    return true;
  }

  private static void asserts(BiPredicate<String, String> predicate) {
    System.out.println(predicate.test("aaaaaa", "aaaaaa"));
    System.out.println(predicate.test("aaaaaa", "aaaaa"));
    System.out.println(predicate.test("aaaaa", "aaaaaa"));
    System.out.println(predicate.test("abcde", "abcd"));
    System.out.println(predicate.test("abcde", "bcde"));
    System.out.println(predicate.test("abcde", "abde"));
    System.out.println(predicate.test("abcd", "abcde"));
    System.out.println(predicate.test("bcde", "abcde"));
    System.out.println(predicate.test("abde", "abcde"));

    System.out.println(!predicate.test("acde", "abcd"));
    System.out.println(!predicate.test("abcde", "bcdea"));
    System.out.println(!predicate.test("abcde", "ade"));
    System.out.println(!predicate.test("abdcd", "abcde"));
    System.out.println(!predicate.test("bcdee", "abcde"));
    System.out.println(!predicate.test("abe", "abcde"));
  }
}
