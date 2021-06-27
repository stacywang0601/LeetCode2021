import java.util.PriorityQueue;

public class Leet023 {
    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            if (lists.length == 1) return lists[0];
            return partition(lists, 0, lists.length - 1);
        }

        private ListNode partition(ListNode[] lists, int l, int h) {
            if (l == h) return lists[l];
            int m = (l + h) / 2;
            ListNode l1 = partition(lists, l, m);
            ListNode l2 = partition(lists, m + 1, h);
            return merge(l1, l2);
        }

        private ListNode merge(ListNode l1, ListNode l2) {
            if (l1 == null) return l2;
            if (l2 == null) return l1;
            if (l1.val < l2.val) {
                l1.next = merge(l1.next, l2);
                return l1;
            }
            l2.next = merge(l1, l2.next);
            return l2;
        }
    }

    class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) return null;
            if (lists.length == 1) return lists[0];
            PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

            for (ListNode list : lists) {
                if (list != null) {
                    pq.offer(list);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode cur = dummy;
            while (!pq.isEmpty()) {
                ListNode node = pq.poll();
                cur.next = node;
                if (node.next != null) {
                    pq.offer(node.next);
                }
                cur = cur.next;
            }
            return dummy.next;
        }
    }

    class ListNode {
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
