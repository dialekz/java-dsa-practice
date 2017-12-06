package module_02;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

/**
 * Source:      Task05.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task05} RESOLVING TIME: 30min
 *
 * @author dialekz
 */
public class Task05 {
    private static final Integer[][] TEST_ARRAYS = {{}, {0}, {1}, {1,2,3},{7,8,9},{1,2,3,4,5},{5,6,7,8,9}};

    public static void main(String[] args) {
        asserts(Task05::foo1);
    }

    /** Solution, O(N) */
    private static LinkedList<Integer> foo(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if (list1 == null || list1.isEmpty())
            return list2;
        if (list2 == null || list2.isEmpty())
            return list1;

        LinkedList<Integer> result = new LinkedList<>();

        ListIterator<Integer> iterator1 = list1.listIterator();
        ListIterator<Integer> iterator2 = list2.listIterator();
        int a, b, res, transfer = 0;

        while (iterator1.hasNext() || iterator2.hasNext()) {
            a = iterator1.hasNext() ? iterator1.next() : 0;
            b = iterator2.hasNext() ? iterator2.next() : 0;
            res = a + b + transfer;
            result.add(res % 10);
            transfer = res / 10;
        }
        if (transfer != 0)
            result.add(transfer);

        return result;
    }

    /** Solution for back form using previous() method of iterator, O(N) */
    private static LinkedList<Integer> foo1(LinkedList<Integer> list1, LinkedList<Integer> list2) {
        if (list1 == null || list1.isEmpty())
            return list2;
        if (list2 == null || list2.isEmpty())
            return list1;

        LinkedList<Integer> result = new LinkedList<>();

        ListIterator<Integer> iterator1 = list1.listIterator(list1.size());
        ListIterator<Integer> iterator2 = list2.listIterator(list2.size());
        int a, b, res, transfer = 0;

        while (iterator1.hasPrevious() || iterator2.hasPrevious()) {
            a = iterator1.hasPrevious() ? iterator1.previous() : 0;
            b = iterator2.hasPrevious() ? iterator2.previous() : 0;
            res = a + b + transfer;
            result.addFirst(res % 10);
            transfer = res / 10;
        }
        if (transfer != 0)
            result.add(transfer);

        return result;
    }

    private static void asserts(BiFunction<LinkedList<Integer>, LinkedList<Integer>, LinkedList<Integer>> function) {
        LinkedList<Integer> list1, list2;
        for (Integer[] element1 : TEST_ARRAYS) {
            list1 = new LinkedList<>(Arrays.stream(element1).collect(Collectors.toList()));
            for (Integer[] element2 : TEST_ARRAYS) {
                list2 = new LinkedList<>(Arrays.stream(element2).collect(Collectors.toList()));
                System.out.println(Arrays.toString(element1) + " + " + Arrays.toString(element2) + " --> " + function.apply(list1, list2));
            }
        }
    }
}
