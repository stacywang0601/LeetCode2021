// 2021-04-29 Thu
public class Leet206 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    // Approach 1: Iterative
    // Time: O(n) Space: O(1)
    public ListNode reverseList(ListNode head) {
        ListNode pre = null, cur = head;

        while(cur != null) {
            ListNode next =  cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    // Approach 2: Recursive
    // Time: O(n) Space: O(n)
    public ListNode reverseList2(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode second =  head.next;
        ListNode newHead =  reverseList(second);

        second.next = head;
        head.next = null;

        return newHead;
    }
}
