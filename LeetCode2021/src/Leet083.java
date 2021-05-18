import java.util.HashSet;
import java.util.Set;

public class Leet083 {
    // Remove cur.next
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head;
            while (cur != null) {
                if (cur.next != null && cur.next.val == cur.val) {
                    cur.next = cur.next.next;
                } else {
                    cur = cur.next;
                }
            }
            return head;
        }
    }

    // Hashset
    class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode cur = head, pre = null;
            Set<Integer> set = new HashSet<>();
            while (cur != null) {
                ListNode next = cur.next;
                if (set.contains(cur.val)) {
                    pre.next = next;
                } else {
                    set.add(cur.val);
                    pre = cur;
                }
                cur = cur.next;
            }
            return head;
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
