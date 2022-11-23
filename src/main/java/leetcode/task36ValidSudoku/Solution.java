package leetcode.task36ValidSudoku;

import java.util.HashSet;

/**
 * Determine if a 9 x 9 Sudoku board is valid.
 * Only the filled cells need to be validated according to the following rules:
 * <p>
 * 1. Each row must contain the digits 1-9 without repetition.
 * 2. Each column must contain the digits 1-9 without repetition.
 * 3. Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p>
 * Note:
 * - A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * - Only the filled cells need to be validated according to the mentioned rules.
 */
class Solution {

  private final HashSet<Character> setLines = new HashSet<>(9);
  private final HashSet<Character> setColumns = new HashSet<>(9);

  public boolean isValidSudoku(char[][] board) {
    boolean result = true;
    for (int i = 0; i < 9; i++) {
      result = result && checkCross(board, i);
    }
    for (int i = 1; i < 9; i += 3) {
      for (int j = 1; j < 9; j += 3) {
        result = result && checkSquare(board, i, j);
      }
    }

    return result;
  }

  private boolean checkSquare(char[][] board, int centerY, int centerX) {
    setLines.clear();
    boolean result = true;
    for (int i = -1; i < 2; i++) {
      for (int j = -1; j < 2; j++) {
        result = result && checkChar(board[centerY + i][centerX + j], setLines);
      }
    }
    return result;
  }

  private boolean checkCross(char[][] board, int i) {
    setLines.clear();
    setColumns.clear();
    boolean result = true;
    for (int j = 0; j < 9; j++) {
      result = result && checkChar(board[i][j], setLines) && checkChar(board[j][i], setColumns);
    }
    return result;
  }

  private boolean checkChar(Character c, HashSet<Character> set) {
    if (c == '.')
      return true;
    else if (set.contains(c))
      return false;
    else
      set.add(c);
    return true;
  }

}
