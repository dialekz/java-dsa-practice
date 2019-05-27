package yandexChampionship2019.championship;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;

public class TaskA {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nxk = in.nextLine().split(" ");
        if (nxk.length < 3) {
            throw new IllegalArgumentException();
        }
        int n = Integer.valueOf(nxk[0]);
        int x = Integer.valueOf(nxk[1]);
        int k = Integer.valueOf(nxk[2]);
        if (k == 0)
            k = 1;
        if (n == 0 || x == 0) {
            System.out.println(0);
            return;
        }

        String[] tnStr = in.nextLine().split(" ");
        if (tnStr.length != n) {
            throw new IllegalArgumentException();
        }

        int[] tnArr = Stream.of(tnStr)
                .map(Integer::valueOf)
                .mapToInt(i -> i)
                .sorted()
                .toArray();

        int step, tmp;
        boolean alert;
        for (int day = 0; day < Integer.MAX_VALUE; ) {
            step = x;
            tmp = 0;
            alert = false;

            for (int i = 0; tmp == 0 && i < tnArr.length; i++) {
                tmp = tnArr[i] - day;
                if (tmp == 0) {
                    tnArr[i] += x;
                    alert = true;
                } else if (tmp < step) {
                    step = tmp;
                    Arrays.sort(tnArr);
                }
            }

            if (alert) {
                k -= 1;
            }

            if (k == 0) {
                System.out.println(day);
                return;
            }
            day += step;
        }
    }
}
