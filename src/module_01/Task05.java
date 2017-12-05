package module_01;

import java.util.function.BiPredicate;

/**
 * Source:      Task05.java
 * Created:     05.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task05} RESOLVING TIME: in progress
 *
 * @author dialekz
 */
public class Task05 {

    public static void main(String[] args) {
        asserts(Task05::foo);
    }

    private static boolean foo(String a, String b) {
        return false;
    }

    private static void asserts(BiPredicate<String, String> predicate) {
        System.out.println(predicate.test("aaaaaa", "aaaaaa"));
    }
}
