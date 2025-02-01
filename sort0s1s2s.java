class Solution {
    // Function to sort a linked list of 0s, 1s, and 2s.
    static Node segregate(Node head) {
        if (head == null || head.next == null) return head;

        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        Node zero = zeroHead, one = oneHead, two = twoHead;
        Node temp = head;

        while (temp != null) {
            if (temp.data == 0) {
                zero.next = temp;
                zero = zero.next;
            } else if (temp.data == 1) {
                one.next = temp;
                one = one.next;
            } else if (temp.data == 2) {
                two.next = temp;
                two = two.next;
            }
            temp = temp.next;
        }

        // Connecting the segregated parts
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        one.next = twoHead.next;
        two.next = null; // End of the last node

        Node newHead = zeroHead.next; // Assign new head properly
        return newHead;
    }
}
