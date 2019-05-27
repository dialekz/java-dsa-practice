package yandexChampionship2019.championship;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskC {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] kn = in.nextLine().split(" ");

        int k = Integer.valueOf(kn[0]);
        int n = Integer.valueOf(kn[1]);

        String[] tnStr = in.nextLine().split(" ");
        if (tnStr.length != n) {
            throw new IllegalArgumentException();
        }

        LinkedList<AtomicInteger> tnArr = Stream.of(tnStr)
                .map(Integer::valueOf)
                .filter(i -> i > 0)
                .map(AtomicInteger::new)
                .collect(Collectors.toCollection(LinkedList::new));

        int vasyaScore = 0, petyaScore = 0;

        for (int i = 0; i < 10000008; i++) {
            for (Iterator<AtomicInteger> iterator = tnArr.iterator(); iterator.hasNext(); ) {
                AtomicInteger ai = iterator.next();

                boolean resV = (ai.get() % 17) == 0;
                boolean resP = (ai.get() % 31) == 0;
                if (resP && !resV) {
                    petyaScore++;
                    if (petyaScore == k) {
                        System.out.println("Petya");
                        return;
                    }
                    iterator.remove();
                } else if (resV && !resP) {
                    vasyaScore++;
                    if (vasyaScore == k) {
                        System.out.println("Vasya");
                        return;
                    }
                    iterator.remove();
                } else {
                    ai.set(ai.get() * 2);
                }
            }
        }

        System.out.println("Too long");
    }
}
