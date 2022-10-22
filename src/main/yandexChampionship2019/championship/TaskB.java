package yandexChampionship2019.championship;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class TaskB {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    int k = Integer.parseInt(in.nextLine());
    if (k <= 0) {
      System.out.println("NO SOLUTION");
    }

    HashMap<String, Integer> table = new HashMap<>();

    double linesNum = Math.pow(2, k) - 1;
    for (int i = 0; i < linesNum; i++) {
      String[] names = in.nextLine().split(" ");
      for (String name : names) {
        if (table.containsKey(name)) {
          table.put(name, table.get(name) + 1);
        } else {
          table.put(name, 1);
        }
      }
    }

    int score = Collections.max(table.values()) - 1;
    for (int i = score; i > 0; i--) {
      final int check = i;
      long count = table.values().stream()
          .filter(v -> v == check)
          .count();

      if (count > 0) {
        List<String> find = new ArrayList<>();
        table.forEach((key, val) -> {
          if (val == score)
            find.add(key);
        });

        if (find.size() == 1) {
          System.out.println(find.get(0));
        } else if (find.size() == 2) {
          System.out.println(find.get(0) + " " + find.get(1));
        } else {
          System.out.println("NO SOLUTION");
        }
        return;
      }
    }
    System.out.println("NO SOLUTION");
  }
}
