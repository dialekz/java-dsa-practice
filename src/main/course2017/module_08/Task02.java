package course2017.module_08;

import java.util.Arrays;

/**
 * Source:      Task02.java
 * Created:     11.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task02} RESOLVING TIME: 1h
 *
 * @author dialekz
 */
public class Task02 {
  private static final int[][] ARRAY = {
      {0, 2, 0, 0, 0, 2, 2, 0},
      {0, 0, 0, 2, 2, 2, 2, 0},
      {0, 2, 0, 0, 0, 2, 2, 0},
      {0, 2, 0, 2, 0, 2, 2, 0},
      {0, 2, 0, 0, 0, 2, 2, 0},
      {0, 2, 0, 0, 0, 2, 2, 0},
      {0, 2, 0, 0, 0, 0, 0, 0},
      {0, 2, 0, 0, 0, 2, 2, 0},
  };

  public static void main(String[] args) {
    for (int[] i : ARRAY) {
      System.out.println(Arrays.toString(i));
    }

    System.out.println("\n" + foo(ARRAY, 0, 0) + "\n");

    for (int[] i : ARRAY) {
      System.out.println(Arrays.toString(i));
    }
  }

  /**
   * O(?)
   */
  private static boolean foo(int[][] array, int line, int clmn) {
    array[line][clmn] = 1;

    if (line == array.length - 1 && clmn == array[line].length - 1) {
      return true;
    }

    if (line < array.length - 1 && array[line + 1][clmn] == 0 && foo(array, line + 1, clmn)) {
      return true;
    }
    if (clmn < array[line].length - 1 && array[line][clmn + 1] == 0 && foo(array, line, clmn + 1)) {
      return true;
    }
    if (line > 0 && array[line - 1][clmn] == 0 && foo(array, line - 1, clmn)) {
      return true;
    }
    if (clmn > 0 && array[line][clmn - 1] == 0 && foo(array, line, clmn - 1)) {
      return true;
    }

    array[line][clmn] = 0;
    return false;
  }
}
