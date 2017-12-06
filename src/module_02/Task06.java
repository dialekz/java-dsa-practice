package module_02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Source:      Task06.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task06} RESOLVING TIME: 10min
 *
 * @author dialekz
 */
class Task06 {
    private static final Integer[][] PALINDROMES = {{}, {0}, {1,2,1},{2,3,2},{6,7,6},{7,8,7},{1,2,2,1},{5,6,6,5},{1,2,3,2,1},{5,6,7,6,5}};
    private static final Integer[][] NOT_PALINDROMES = {{1,2,3},{2,3,4},{6,7,8},{7,8,9},{1,2,3,4},{5,6,5,6},{1,2,3,4,5},{5,6,7,8,9}};

    public static void main(String[] args) {
        asserts(Task06::foo);
    }

    /** Solution, O(N/2) */
    private static boolean foo(LinkedList<?> list) {
        if (list == null || list.isEmpty())
            return true;

        ListIterator forward = list.listIterator();
        ListIterator backward = list.listIterator(list.size());

        while (forward.nextIndex() < backward.nextIndex()) {
            if (!forward.next().equals(backward.previous()))
                return false;
        }

        return true;
    }

    private static void asserts(Predicate<LinkedList> predicate) {
        for (Integer[] element : PALINDROMES) {
            System.out.println(predicate.test(new LinkedList<>(Arrays.stream(element).collect(Collectors.toList()))));
        }
        System.out.println();
        for (Integer[] element : NOT_PALINDROMES) {
            System.out.println(!predicate.test(new LinkedList<>(Arrays.stream(element).collect(Collectors.toList()))));
        }
    }
}
