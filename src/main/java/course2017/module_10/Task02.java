package course2017.module_10;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/**
 * Source:      Task02.java
 * Created:     11.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task02} RESOLVING TIME: 40m
 *
 * @author dialekz
 */
public class Task02 {

  /**
   * O(N*logN)
   */
  private static String[] foo(String[] array) {
    DoubleString[] arr = new DoubleString[array.length];

    for (int i = 0; i < array.length; i++) {
      arr[i] = new DoubleString(array[i]);
    }

    Arrays.sort(arr); // Use QuickSort for Comparable

    String[] result = new String[array.length];
    for (int i = 0; i < array.length; i++) {
      result[i] = arr[i].original;
    }

    return result;
  }

  /**
   * O(N*...)
   */
  private static String[] foo1(String[] array) {
    int i;
    boolean added = false;
    DoubleString doubleString;
    LinkedList<LinkedList<DoubleString>> list = new LinkedList<>();

    for (String str : array) {
      i = 0;
      doubleString = new DoubleString(str);

      for (LinkedList<DoubleString> l : list) {
        added = false;
        if (l.getFirst().anagram.equals(doubleString.anagram)) {
          l.add(doubleString);
          added = true;
          break;
        } else if (l.getFirst().anagram.compareTo(doubleString.anagram) < 0) {
          break;
        }
        i++;
      }

      if (!added) {
        list.add(i, new LinkedList<>(Collections.singletonList(doubleString)));
      }
    }

    i = 0;
    String[] result = new String[array.length];
    for (LinkedList<DoubleString> l : list) {
      for (DoubleString dstr : l) {
        result[i++] = dstr.original;
      }
    }

    return result;
  }

  private static class DoubleString implements Comparable<DoubleString> {
    String original, anagram;

    DoubleString(String str) {
      original = str;
      char[] arr = str.toCharArray();
      Arrays.sort(arr);
      anagram = String.valueOf(arr);
    }

    @Override
    public int compareTo(DoubleString o) {
      int result = anagram.compareTo(o.anagram);
      if (result == 0) {
        result = original.compareTo(o.original);
      }
      return result;
    }
  }
}
