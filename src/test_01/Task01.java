package test_01;

import java.util.LinkedList;

/**
 * Source:      Task01.java
 * Created:     08.12.2017
 * Project:     Practice-DSA
 * Make:        IntelliJ IDEA
 * <p>
 * {@code Task01} 1.	Последовательность Фибоначчи выглядит следующим образом 0 1 1 2 3 5 8 13 21 34 55 ...,
 * то есть каждый последующий член последовательности равен сумме двух предыдущих.
 * На ввод поступает строка например вида «13213455». Напишите программу,
 * проверяющую является ли строка частью последовательности Фибоначчи.
 *
 * @author dialekz
 */
public class Task01 {

    static LinkedList<Integer> fib = new LinkedList<>();
    static {
        fib.add(0);
        fib.add(1);
    }

    private static boolean foo(String str) {

//        IT's BAD SOLUTION
//        int n1Size = 1, n2Size = 1, index1, index2;
//        int n1, n2, sum;
//        int finish = 2;
//        String sumStr, current = str;
//        boolean result = false;
//
//
//        n2 = Integer.valueOf(current.substring(0,n1Size));
//
//        while (finish <= str.length()) {
//            index1 = n1Size + n1Size;
//            n1 = n2;
//            n2 = Integer.valueOf(current.substring(n1Size, index1));
//            sum = n1 + n2;
//
//            sumStr = String.valueOf(sum);
//            if (current.substring(index1, index1 + sumStr.length()).equals(sumStr)) {
//                result = true;
//            } else {
//                if (n1Size == n2Size) {
//                    n2Size++;
//                } else {
//                    n1Size++;
//                }
//                result = false;
//            }
//        }

        int fullSize = 1, size = 1;
        String current = str;
        boolean result = false;

        while (fullSize != str.length()) {
            int n = Integer.valueOf(current.substring(size));
            if (!fib.contains(n) && fib.peekLast() < n) {
                int n1, n2 = fib.get(fib.size()-2);
                while (fib.peekLast() <= n) {
                    n1 = n2;
                    n2 = fib.peekLast();
                    fib.add(n1 + n2);
                }
            }

            if (fib.peekLast() > n) {
                size++;
                fullSize++;
                current = str;
                continue;
            } else if (fib.peekLast() == n) {
                // TODO
            }
        }

        return result;
    }
}
