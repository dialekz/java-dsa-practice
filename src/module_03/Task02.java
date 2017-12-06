package module_03;

/**
 * Source:      Task02.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task02} RESOLVING TIME: 30min
 *
 * @author dialekz
 */
class Task02 {

    private static class MyStack<T extends Comparable<T>> {

        Entry current = new Entry(null, null);
        {
            current.prev = current;
        }

        private class Entry {
            final T value;
            final T min;
            Entry prev;

            private Entry(T value, T min) {
                this.value = value;
                this.min = (min == null || min.compareTo(value) > 0) ? value : min;
            }
        }

        /** O(N) */
        public void push(T t) {
            Entry entry = new Entry(t, current.min);
            entry.prev = current;
            current = entry;
        }

        /** O(N) */
        public T pop() {
            T value = current.value;
            current = current.prev;
            return value;
        }

        /** O(N) */
        public T min() {
            return current.min;
        }

    }
}
