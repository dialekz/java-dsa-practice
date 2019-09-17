package leetcode.task002AddTwoNumbers;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder(Integer.toString(val));
        ListNode nxt = next;
        while (nxt != null) {
            res.append("-").append(nxt.val);
            nxt = nxt.next;
        }
        return res.toString();
    }
}
