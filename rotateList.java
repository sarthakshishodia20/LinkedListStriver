// Using Striver Sheet Solution 
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        tail.next = head;
        k = k % len;
        if (k == 0) {
            tail.next = null;
            return head;
        }
        ListNode newLastNode = getNewLastNode(head, len - k - 1);
        ListNode newHead = newLastNode.next;
        newLastNode.next = null;
        return newHead;
    }

    public static ListNode getNewLastNode(ListNode head, int n) {
        ListNode temp = head;
        for (int i = 0; i < n; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
