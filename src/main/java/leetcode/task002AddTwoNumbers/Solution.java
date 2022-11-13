package leetcode.task002AddTwoNumbers;

public class Solution {
  public static void main(String[] args) {
    var solution = new Solution();

    System.out.println(solution.addTwoNumbers(new ListNode(1), new ListNode(1))); // 2

    ListNode value12 = new ListNode(1);
    value12.next = new ListNode(2);
    System.out.println(solution.addTwoNumbers(value12, new ListNode(1))); // 2-2
    System.out.println(solution.addTwoNumbers(new ListNode(1), value12)); // 2-2
    System.out.println(solution.addTwoNumbers(value12, new ListNode(9))); // 0-3
    System.out.println(solution.addTwoNumbers(new ListNode(9), value12)); // 0-3

    ListNode value123 = new ListNode(1);
    value123.next = new ListNode(2);
    value123.next.next = new ListNode(3);
    System.out.println(solution.addTwoNumbers(value123, new ListNode(1))); // 2-2-3
    System.out.println(solution.addTwoNumbers(new ListNode(1), value123)); // 2-2-3
    System.out.println(solution.addTwoNumbers(value123, value123));        // 2-4-6
  }

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int val = l1.val + l2.val;
    int addValue = val / 10;
    ListNode result = new ListNode(val % 10);
    ListNode current = result;
    l1 = l1.next;
    l2 = l2.next;

    while (l1 != null || l2 != null) {
      int val1 = 0;
      int val2 = 0;

      if (l1 != null) {
        val1 = l1.val;
        l1 = l1.next;
      }
      if (l2 != null) {
        val2 = l2.val;
        l2 = l2.next;
      }

      val = val1 + val2 + addValue;
      current.next = new ListNode(val % 10);
      current = current.next;
      addValue = val / 10;
    }

    if (addValue != 0) {
      current.next = new ListNode(addValue);
    }

    return result;
  }
}
