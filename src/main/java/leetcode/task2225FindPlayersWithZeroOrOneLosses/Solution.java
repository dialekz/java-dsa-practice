package leetcode.task2225FindPlayersWithZeroOrOneLosses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

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
    HashMap<Integer, Integer> losers = new HashMap<>(matches.length);
    HashSet<Integer> winners = new HashSet<>(matches.length);
    Integer winner, loser, loses;

    for (int[] game : matches) {
      loser = game[1];
      loses = Optional.ofNullable(losers.get(loser)).orElse(0);
      if (loses < 2)
        losers.put(loser, loses + 1);
    }

    for (int[] game : matches) {
      winner = game[0];
      if (!losers.containsKey(winner))
        winners.add(winner);

    }

    return List.of(
        new ArrayList<>(winners),
        new ArrayList<>(losers.entrySet().stream()
            .filter(entry -> entry.getValue() == 1)
            .map(Map.Entry::getKey).collect(Collectors.toList())));
  }
}
