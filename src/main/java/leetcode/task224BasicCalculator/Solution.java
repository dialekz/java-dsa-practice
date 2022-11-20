package leetcode.task224BasicCalculator;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a string s representing a valid expression,
 * implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions,
 * such as eval().
 * <p>
 * Constraints:
 * * 1 <= s.length <= 3 * 105
 * * s consists of digits, '+', '-', '(', ')', and ' '.
 * * s represents a valid expression.
 * * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * * There will be no two consecutive operators in the input.
 * * Every number and running calculation will fit in a signed 32-bit integer.
 */
public class Solution {

  public int calculate(String s) {
    StringBuilder value = new StringBuilder();
    int result = 0;
    char operation = '+';
    boolean revert = false;

    Deque<Boolean> revertDeque = new ArrayDeque<>();

    char[] arr = s.toCharArray();
    for (char c : arr) {
      switch (c) {
        case ' ':
          break;
        case '(':
          result = makeOperation(result, value.toString(), operation, revert);
          revertDeque.push(revert);
          revert = operation == '-' ? !revert : revert;
          operation = '+';
          value.delete(0, value.length());
          break;
        case ')':
          result = makeOperation(result, value.toString(), operation, revert);
          revert = revertDeque.pop();
          value.delete(0, value.length());
          break;
        case '-':
          result = makeOperation(result, value.toString(), operation, revert);
          operation = '-';
          value.delete(0, value.length());
          break;
        case '+':
          result = makeOperation(result, value.toString(), operation, revert);
          operation = '+';
          value.delete(0, value.length());
          break;
        default:
          value.append(c);
          break;
      }
    }
    return makeOperation(result, value.toString(), operation, revert);
  }

  private int makeOperation(int current, String potentialValue, char operation, boolean revert) {
    int value = potentialValue.equals("") ? 0 : Integer.parseInt(potentialValue);
    if ((revert && operation == '+') || (!revert && operation == '-'))
      return current - value;
    else
      return current + value;
  }

}
