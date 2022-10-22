package course2017.module_03;

import java.util.Arrays;
import java.util.function.Function;

/**
 * Source:      Task05.java
 * Created:     06.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task05} RESOLVING TIME: 1h
 *
 * @author dialekz
 */
class Task05 {
  private static final Integer[][] TEST_ARRAYS = {{}, {0}, {1, 2, 3}, {3, 2, 1}, {1, 5, 3, 4, 2}, {9, 6, 7, 5, 8}};

  public static void main(String[] args) {
    asserts(Task05::foo);
  }

  private static <T extends Comparable<T>> MyStack<T> foo(MyStack<T> stack) {
    MyStack<T> sorted = new MyStack<>();
    MyStack<T> backward1 = new MyStack<>();
    MyStack<T> backward2 = new MyStack<>();

    while (!stack.isEmpty()) {
      if (!backward1.isEmpty() && backward1.peek().compareTo(stack.peek()) > 0) {
        if (sorted.isEmpty()) {
          fromStackToStack(backward1, sorted);
        } else {
          fromStackToStack(sorted, backward2);
          sorted = joinStacks(backward1, backward2);
        }
      }
      backward1.push(stack.pop());
    }
    fromStackToStack(sorted, backward2);
    return joinStacks(backward1, backward2);
  }

  /**
   * From stack1 to stack2 like: {1,2,3,4} -> {4,3,2,1}
   */
  private static <T extends Comparable<T>> void fromStackToStack(MyStack<T> stack1, MyStack<T> stack2) {
    while (!stack1.isEmpty()) {
      stack2.push(stack1.pop());
    }
  }

  /**
   * Join stacks with comparing elements in heads
   */
  private static <T extends Comparable<T>> MyStack<T> joinStacks(MyStack<T> stack1, MyStack<T> stack2) {
    MyStack<T> result = new MyStack<>();

    while (!stack2.isEmpty()) {
      if (!stack1.isEmpty() && stack1.peek().compareTo(stack2.peek()) > 0) {
        result.push(stack1.pop());
      } else {
        result.push(stack2.pop());
      }
    }

    while (!stack1.isEmpty()) {
      result.push(stack1.pop());
    }

    return result;
  }

  private static void asserts(Function<MyStack<Integer>, MyStack<Integer>> function) {
    MyStack<Integer> stack;
    for (Integer[] array : TEST_ARRAYS) {
      System.out.print(Arrays.toString(array) + " --> ");
      stack = new MyStack<>();
      for (Integer i : array) {
        stack.push(i);
      }

      stack = function.apply(stack);

      for (int i = 0; i < array.length; i++) {
        array[i] = stack.pop();
      }

      System.out.println(Arrays.toString(array));
    }
  }

  private static class MyStack<T extends Comparable<T>> {

    Entry current = new Entry(null, null);

    {
      current.prev = current;
    }

    void push(T t) {
      Entry entry = new Entry(t, current.min);
      entry.prev = current;
      current = entry;
    }

    T pop() {
      T value = current.value;
      current = current.prev;
      return value;
    }

    T peek() {
      return current.value;
    }

    boolean isEmpty() {
      return current.prev == current;
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

  }
}
