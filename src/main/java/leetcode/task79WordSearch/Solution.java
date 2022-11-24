package leetcode.task79WordSearch;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
class Solution {

  byte[][] visited;
  int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

  public boolean exist(char[][] board, String word) {
    visited = new byte[board.length][board[0].length];

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == word.charAt(0)) {
          visited[i][j] = 1;
          if (word.length() == 1 || findNext(board, 1, word, i, j))
            return true;
          visited[i][j] = 0;
        }
      }
    }
    return false;
  }

  private boolean findNext(char[][] board, int current, String word, int y, int x) {
    int i, j;
    for (int[] step : steps) {
      i = y + step[0];
      j = x + step[1];

      if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == 1)
        continue;

      if (board[i][j] == word.charAt(current)) {
        if (current + 1 == word.length())
          return true;
        else {
          visited[i][j] = 1;
          if (findNext(board, current + 1, word, i, j))
            return true;
          visited[i][j] = 0;
        }
      }
    }
    return false;
  }
}
