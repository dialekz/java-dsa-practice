package leetcode.task1926NearestExitFromEntranceInMaze;

class Solution {
  private char[][] staticMaze;
  private int[][] path;
  private int length, height;

  public int nearestExit(char[][] maze, int[] entrance) {
    staticMaze = maze;
    height = staticMaze.length - 1;
    length = staticMaze[0].length - 1;
    path = new int[staticMaze.length][staticMaze[0].length];
    path[entrance[0]][entrance[1]] = 1;
    return nearestExitRec(entrance, 0, -1);
  }

  private int nearestExitRec(int[] current, int count, int best) {
    int result, y = current[0], x = current[1];
    for (int[] position : new int[][]{{y - 1, x}, {y + 1, x}, {y, x - 1}, {y, x + 1}}) {
      int i = position[0], j = position[1];
      if (i < 0 || i > height || j < 0 || j > length)
        continue;

      if (path[i][j] == 1)
        continue;

      if (staticMaze[i][j] == '.') {
        if (i == 0 || j == 0 || i == height || j == length)
          return count + 1;
        else if (best != -1 && count + 1 > best)
          return best;
        else {
          path[i][j] = 1;
          result = nearestExitRec(position, count + 1, best);
          best = (result != -1) ? result : best;
          path[i][j] = 0;
        }
      }
    }
    return best;
  }
}
