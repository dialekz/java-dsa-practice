package course2017.module_01;

import java.util.LinkedList;
import java.util.function.Predicate;

/**
 * Source:      Task04.java
 * Created:     05.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task04} RESOLVING TIME: 15min
 *
 * @author dialekz
 */
class Task04 {

    public static void main(String[] args) {
        asserts(Task04::foo);
    }

    /** First solution, O(N^2) --> N * (N/2 removing) */
    private static boolean foo(String a) {
        if (a == null)
            return false;
        if (a.isEmpty())
            return true;

        a = a.trim().replace(" ", "");

        Character mChar;
        LinkedList<Character> list = new LinkedList<>();

        for (char c : a.toCharArray()) {
            mChar = c;
            if (!list.removeIf(mChar::equals)) {
                list.add(mChar);
            }
        }

        return list.size() <= 1;
    }

    private static void asserts(Predicate<String> predicate) {
         System.out.println(predicate.test("aaaaaa"));
         System.out.println(predicate.test("aaaaaaa"));
         System.out.println(predicate.test("aabbcc"));
         System.out.println(predicate.test("aabbc"));

         System.out.println(!predicate.test("aabbca"));
         System.out.println(!predicate.test("aabbcd"));
         System.out.println(!predicate.test("aabbfg"));
    }

}
