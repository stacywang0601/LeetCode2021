import java.util.*;

public class Leet1836 {
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

    // Delete all duplicates - Map
    class Solution {
        public ListNode deleteDuplicatesUnsorted(ListNode head) {
            Map<Integer, Integer> nodes = new HashMap<>();
            ListNode cur = head;
            while (cur != null) {
                nodes.put(cur.val, nodes.getOrDefault(cur.val, 0) + 1);
                cur = cur.next;
            }
            // Dummy point to next
            ListNode root = new ListNode(0, head);
            ListNode pre = root;
            cur = head;
            while (cur != null) {
                ListNode next = cur.next;
                if (nodes.get(cur.val) > 1) { // Find duplicates
                    //Remove cur
                    pre.next = next;
                } else { // Only 1 occurrence
                    // keep going
                    pre = cur;
                }
                cur = next;
            }
            return root.next;
        }
    }

    // Variation: Keep one occurrence of duplicates - Set
    class Solution2 {
        public ListNode deleteDuplicates(ListNode head) {
            Set<Integer> set = new HashSet<>();
            ListNode cur = head;
            ListNode pre = null;
            while (cur != null) {
                ListNode next = cur.next;
                if (set.contains(cur.val)) { // Find duplicates
                    // Remove cur
                    pre.next = next;
                } else { // First occurrence
                    // Add to set and keep moving
                    set.add(cur.val);
                    pre = cur;
                }
                cur = next;
            }
            return head;
        }
    }
}
