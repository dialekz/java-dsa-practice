package course2017.module_16;

/**
 * Source:      Task07.java
 * Created:     11.12.2017
 * Project:     Practice-DSA
 * <p>
 * {@code Task07} RESOLVING TIME: 30min
 *
 * @author dialekz
 */
public class Task07 {

  public static void main(String[] args) {
    System.out.println("2, 8 --> " + foo(2, 8));
    System.out.println("8, 2 --> " + foo(8, 2));
  }

  private static int foo(int a, int b) {
    int c = b - a;
    int d = c >>> 31;
    return a * d - b * (d - 1);
  }
}
