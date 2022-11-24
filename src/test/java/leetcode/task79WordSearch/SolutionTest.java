package leetcode.task79WordSearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example 1:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * Output: true
 * <p>
 * Example 2:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
 * Output: true
 * <p>
 * Example 3:
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
 * Output: false
 */
class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  void exist1() {
    boolean expected = true;
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    String word = "ABCCED";
    assertEquals(expected, solution.exist(board, word));
  }

  @Test
  void exist2() {
    boolean expected = true;
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    String word = "SEE";
    assertEquals(expected, solution.exist(board, word));
  }

  @Test
  void exist3() {
    boolean expected = false;
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    String word = "ABCB";
    assertEquals(expected, solution.exist(board, word));
  }

  @Test
  void exist4() {
    boolean expected = true;
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    String word = "A";
    assertEquals(expected, solution.exist(board, word));
  }

  @Test
  void exist5() {
    boolean expected = true;
    char[][] board = new char[][]{
        {'A', 'B', 'C', 'E'},
        {'S', 'F', 'C', 'S'},
        {'A', 'D', 'E', 'E'}};
    String word = "AB";
    assertEquals(expected, solution.exist(board, word));
  }
}