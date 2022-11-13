package course2017.module_16;

/**
 * Source:      Task01.java
 * Created:     11.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task01} RESOLVING TIME: 15m
 *
 * @author dialekz
 */
public class Task01 {

  public static void main(String[] args) {
    foo(2, 3);
  }

  private static void foo(int a, int b) {
    System.out.print(a + ", " + b + " --> ");
    a = b - a;
    b = -a + b;
    a = a + b;
    System.out.print(a + ", " + b);
  }
}
