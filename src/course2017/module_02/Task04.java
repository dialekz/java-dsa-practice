package course2017.module_02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Source:      Task04.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task04} RESOLVING TIME: 30min
 *
 * @author dialekz
 */
class Task04 {
    private static final Integer[] TEST_ARRAY = {20,19,18,17,16,15,14,13,12,11,10,9,8,7,6,5,4,3,2,1};

    public static void main(String[] args) {
        asserts(Task04::foo);
    }

    /** Solution, O(N) */
    private static LinkedList<Integer> foo(LinkedList<Integer> list, Integer x) {
        if (list == null || list.isEmpty())
            return list;

        LinkedList<Integer> result = new LinkedList<>();
        ListIterator<Integer> iterator = list.listIterator();
        Integer element;

        while (iterator.hasNext()) {
            element = iterator.next();
            if (element < x) {
                result.addFirst(element);
            } else {
                result.addLast(element);
            }
            iterator.remove();
        }

        list.addAll(result);

        return list;
    }

    private static void asserts(BiFunction<LinkedList<Integer>, Integer, LinkedList<Integer>> function) {
        LinkedList<Integer> list;
        int index;
        for (Integer element : TEST_ARRAY) {
            list = function.apply(new LinkedList<>(Arrays.stream(TEST_ARRAY).collect(Collectors.toList())), element);
            index = 0;

            System.out.print(element + "  -->  ");

            while (list.get(index) < element) {
                System.out.print(list.get(index++) + ", ");
            }
            System.out.print("<--> ");
            while (index < list.size()) {
                System.out.print(list.get(index++) + ", ");
            }
            System.out.println();
        }
    }
}
