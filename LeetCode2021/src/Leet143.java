public class Leet143 {
    // 2021-07-28 Wed
    class Solution {
        public void reorderList(ListNode head) {
            if (head == null || head.next == null) return;

            ListNode fast = head, slow = head;
            while (fast != null && fast.next != null) {
                fast = fast.next.next;
                slow = slow.next;
            }
            ListNode second = reverse(slow.next);
            slow.next = null;

            ListNode first = head;
            while (first != null && second != null) {
                ListNode t1 = first.next;
                ListNode t2 = second.next;
                first.next = second;
                second.next = t1;
                first = t1;
                second = t2;
            }
        }

        private ListNode reverse(ListNode head) {
            if (head == null || head.next == null) return head;

            ListNode pre = null, cur = head;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = pre;
                pre = cur;
                cur = next;
            }
            return pre;
        }
    }
}
