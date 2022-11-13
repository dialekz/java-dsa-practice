package course2017.module_02;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Source:      Task01.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task01} RESOLVING TIME: 40min
 *
 * @author dialekz
 */
class Task01 {
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
    asserts(Task01::foo);
    System.out.println();
    asserts(Task01::foo1);
  }

  /**
   * Solution, O(N*logN) --> N - going to list, lonN - adding in tree
   */
  private static <T> LinkedList<T> foo(LinkedList<T> list) {
    TreeSet<T> set = new TreeSet<>(list);
    return new LinkedList<>(set);
  }

  /**
   * Solution, O(N^2)
   */
  private static <T> LinkedList<T> foo1(LinkedList<T> list) {
    if (list == null || list.isEmpty())
      return list;

    ListIterator<T> iterator;
    T current, element;
    int index = 0;

    while (index < list.size()) {
      iterator = list.listIterator(index++);
      current = iterator.next();

      while (iterator.hasNext()) {
        element = iterator.next();
        if (current.equals(element))
          iterator.remove();
      }
    }

    return list;
  }

  private static void asserts(Function<LinkedList, LinkedList> function) {
    for (String s : TEST_STRINGS) {
      System.out.println(s + "  -->  " + function.apply(new LinkedList<>(s
          .chars()
          .mapToObj(c -> (char) c)
          .collect(Collectors.toList()))));
    }
  }
}
