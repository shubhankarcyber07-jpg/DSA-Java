 
public class LeetCode_2_Add_Two_Numbers {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int c = 0;

        ListNode t1 = l1, t2 = l2;

        while (t1 != null || t2 != null || c != 0) {
            int v1 = (t1 != null) ? t1.val : 0;
            int v2 = (t2 != null) ? t2.val : 0;

            int sum = v1 + v2 + c;
            c = sum / 10;
            sum = sum % 10;

            temp.next = new ListNode(sum);
            temp = temp.next;

            if (t1 != null) t1 = t1.next;
            if (t2 != null) t2 = t2.next;
        }

        return dummy.next;
    }
}
