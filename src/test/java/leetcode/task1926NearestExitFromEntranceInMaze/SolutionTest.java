package leetcode.task1926NearestExitFromEntranceInMaze;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

  private final Solution solution = new Solution();


  @Test
  void nearestExit1() {
    char[][] maze = new char[][]{
        {'+', '+', '.', '+'},
        {'.', '.', '.', '+'},
        {'+', '+', '+', '.'}};
    int[] entrance = new int[]{1, 2};
    int expected = 1;
    assertEquals(expected, solution.nearestExit(maze, entrance));
  }

  @Test
  void nearestExit2() {
    char[][] maze = new char[][]{
        {'+', '+', '+'},
        {'.', '.', '.'},
        {'+', '+', '+'}};
    int[] entrance = new int[]{1, 0};
    int expected = 2;
    assertEquals(expected, solution.nearestExit(maze, entrance));
  }

  @Test
  void nearestExit3() {
    char[][] maze = new char[][]{{'.', '+'}};
    int[] entrance = new int[]{0, 0};
    int expected = -1;
    assertEquals(expected, solution.nearestExit(maze, entrance));
  }


  @Test
  void nearestExit4() {
    char[][] maze = new char[][]{
        {'+', '+', '+', '.'},
        {'+', '+', '.', '.'},
        {'+', '.', '.', '.'},
        {'+', '.', '+', '.'}};
    int[] entrance = new int[]{3, 1};
    int expected = 3;
    assertEquals(expected, solution.nearestExit(maze, entrance));
  }


  @Test
  void nearestExit5() {
    char[][] maze = new char[][]{
        {'+', '+', '+', '+'},
        {'+', '.', '.', '+'},
        {'+', '.', '.', '+'},
        {'+', '.', '+', '+'}};
    int[] entrance = new int[]{3, 1};
    int expected = -1;
    assertEquals(expected, solution.nearestExit(maze, entrance));
  }


//  @Test
//  void nearestExit6() {
//    char[][] maze = new char[][]{
//        {'+', '+', '+'},
//        {'.', '.', '.'},
//        {'+', '+', '+'}};
//    int[] entrance = new int[]{1, 0};
//    int expected = -1;
//    assertEquals(expected, solution.nearestExit(maze, entrance));
//  }

}