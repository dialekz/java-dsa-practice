package leetcode.task79WordSearch;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n grid of characters board and a string word, return true if word exists in the grid.
 * <p>
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
class Solution {

  public boolean exist(char[][] board, String word) {
    Queue<int[]> onStartQueue = new LinkedList<>();
    findFirst(board, word.toCharArray()[0], onStartQueue);

    byte[][] visited = new byte[board.length][board[0].length];
    int[] start;

    boolean result = word.length() == 1 && !onStartQueue.isEmpty();

    while (!onStartQueue.isEmpty()) {
      start = onStartQueue.poll();
      visited[start[0]][start[1]] = 1;
      result = result || findNext(board, 1, word, start[0], start[1], visited);
      visited[start[0]][start[1]] = 0;
    }
    return result;
  }

  private void findFirst(char[][] board, char c, Queue<int[]> queue) {
    int visitorNum = 1;
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[i].length; j++) {
        if (board[i][j] == c)
          queue.add(new int[]{i, j, 0, visitorNum++});
      }
    }
  }

  private boolean findNext(char[][] board, int current, String word, int y, int x, byte[][] visited) {
    int[][] steps = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    int[] variant;
    boolean result = false;
    for (int[] step : steps) {
      variant = new int[]{y + step[0], x + step[1]};

      if (variant[0] < 0 || variant[1] < 0
          || variant[0] >= board.length || variant[1] >= board[0].length
          || visited[variant[0]][variant[1]] == 1)
        continue;

      if (board[variant[0]][variant[1]] == word.charAt(current)) {
        if (current + 1 == word.length())
          return true;
        else {
          visited[variant[0]][variant[1]] = 1;
          result = result || findNext(board, current + 1, word, variant[0], variant[1], visited);
          visited[variant[0]][variant[1]] = 0;
        }
      }
    }
    return result;
  }
}
