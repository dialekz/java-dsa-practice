package leetcode.task1926NearestExitFromEntranceInMaze;

import java.util.LinkedList;
import java.util.Queue;

class Solution {

  public int nearestExit(char[][] maze, int[] entrance) {
    int height = maze.length - 1;
    int length = maze[0].length - 1;

    int[][] path = new int[maze.length][maze[0].length];
    path[entrance[0]][entrance[1]] = 1;

    Queue<int[]> states = new LinkedList<>();
    Queue<Integer> values = new LinkedList<>();
    states.add(entrance);
    values.add(0);

    int[][] steps = new int[][]{{-1, 0}, {+1, 0}, {0, -1}, {0, +1}};

    int i, j, count;
    int[] current;

    while (!states.isEmpty() && !values.isEmpty()) {
      count = values.poll();
      current = states.poll();
      for (int[] step : steps) {
        i = current[0] + step[0];
        j = current[1] + step[1];

        if (i < 0 || i > height || j < 0 || j > length)
          continue;

        if (path[i][j] == 1)
          continue;

        if (maze[i][j] == '.') {
          if (i == 0 || j == 0 || i == height || j == length)
            return count + 1;
          else {
            path[i][j] = 1;
            states.add(new int[]{i, j});
            values.add(count + 1);
          }
        }
      }
    }
    return -1;
  }
}
