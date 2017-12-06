package module_01;

import java.util.Arrays;
import java.util.function.BiPredicate;

/**
 * Source:      Task02.java
 * Created:     05.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task02} RESOLVING TIME: 1h
 *
 * @author dialekz
 */
public class Task02 {

    public static void main(String[] args) {
        asserts(Task02::foo);
    }

    /** First solution, O(N*logN) */
    private static boolean foo(String a, String b) {
        if (a == null || b == null)
            return false;

        // Preparing
        a = a.trim().replace(" ", "");
        b = b.trim().replace(" ", "");
        if (a.length() != b.length())
            return false;
        if (a.equals(b))
            return true;

        // Check using sort
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();
        Arrays.sort(aChars);
        Arrays.sort(bChars);

        return new String(aChars).equals(new String(bChars));
    }

    /** Second solution, O(N) TODO */
    private static boolean foo1(String a, String b) {
        if (a == null || b == null)
            return false;

        a = a.trim().replace(" ", "");
        b = b.trim().replace(" ", "");
        if (a.length() != b.length())
            return false;
        if (a.equals(b))
            return true;

        // TODO use HashMap

        return false;
    }

    private static void asserts(BiPredicate<String, String> predicate) {
        System.out.println(predicate.test("aaaaaa", "aaaaaa"));
        System.out.println(predicate.test("test", "test"));
        System.out.println(predicate.test("abcd", "dbac"));

        System.out.println(!predicate.test("aaaaaa", "aaaa"));
        System.out.println(!predicate.test("aaaaaa", "aaaaa"));
        System.out.println(!predicate.test("aaaaaa", "aaaaab"));
    }
}
