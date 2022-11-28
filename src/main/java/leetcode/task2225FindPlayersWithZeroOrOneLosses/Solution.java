package leetcode.task2225FindPlayersWithZeroOrOneLosses;

import java.util.LinkedList;
import java.util.List;

/**
 * You are given an integer array matches where matches[i] = [winner[i], loser[i]]
 * indicates that the player winner[i] defeated player loser[i] in a match.
 * <p>
 * Return a list answer of size 2 where:
 * <p>
 * answer[0] is a list of all players that have not lost any matches.
 * answer[1] is a list of all players that have lost exactly one match.
 * The values in the two lists should be returned in increasing order.
 * <p>
 * Note:
 * - You should only consider the players that have played at least one match.
 * - The testcases will be generated such that no two matches will have the same outcome.
 */
class Solution {

  public List<List<Integer>> findWinners(int[][] matches) {
    int players = 0;
    for (int[] game : matches) {
      players = Integer.max(players, game[0]);
      players = Integer.max(players, game[1]);
    }

    int[] score = new int[players + 1];
    for (int[] game : matches) {
      if (score[game[0]] == 0)
        score[game[0]] = 1;

      if (score[game[1]] == 0)
        score[game[1]] = 1;

      score[game[1]] += 1;
    }

    List<Integer> winners = new LinkedList<>();
    List<Integer> losers = new LinkedList<>();

    for (int i = 0; i < score.length; i++) {
      if (score[i] == 1)
        winners.add(i);
      else if (score[i] == 2)
        losers.add(i);
    }

    return List.of(winners, losers);
  }
}
