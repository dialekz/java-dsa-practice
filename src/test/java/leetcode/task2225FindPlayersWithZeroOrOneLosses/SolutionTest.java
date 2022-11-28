package leetcode.task2225FindPlayersWithZeroOrOneLosses;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private final Solution solution = new Solution();

  @Test
  void findWinners1() {
    int[][] input = new int[][]{{1, 3}, {2, 3}, {3, 6}, {5, 6}, {5, 7}, {4, 5}, {4, 8}, {4, 9}, {10, 4}, {10, 9}};
    List<List<Integer>> expected = List.of(List.of(1, 2, 10), List.of(4, 5, 7, 8));
    assertEquals(expected, solution.findWinners(input));
  }

  @Test
  void findWinners2() {
    int[][] input = new int[][]{{2, 3}, {1, 3}, {5, 4}, {6, 4}};
    List<List<Integer>> expected = List.of(List.of(1, 2, 5, 6), List.of());
    assertEquals(expected, solution.findWinners(input));
  }

  @Test
  void findWinners3() {
    int[][] input = new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 10}, {10, 2}};
    List<List<Integer>> expected = List.of(List.of(1), List.of(3, 4, 5, 10));
    assertEquals(expected, solution.findWinners(input));
  }
}