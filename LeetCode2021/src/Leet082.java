public class Leet082 {
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode dummy = new ListNode(0, head);
            ListNode pre = dummy, cur = head;
            while (cur != null) {
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                ListNode next = cur.next;
                if (pre.next != cur) { // Find duplicates
                    // Remove cur
                    pre.next = next;
                } else { // No duplicates
                    // Keep going
                    pre = cur;
                }
                cur = next;
            }
            return dummy.next;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
