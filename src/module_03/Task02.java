package module_03;

/**
 * Source:      Task02.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task02} RESOLVING TIME: in progress
 *
 * @author dialekz
 */
class Task02 {

    private static class MyStack<T extends Comparable<T>> {
        T min = null;

        Entry<T> current = new Entry<>(null);
        {
            current.prev = current;
        }

        private static class Entry<E extends Comparable<E>> {
            final E value;
            Entry prev;

            private Entry(E value) {
                this.value = value;
            }
        }

        public void push(T t) {
            min = (min == null || min.compareTo(t) > 0) ? t : min;
            // TODO ...
        }


    }
}
