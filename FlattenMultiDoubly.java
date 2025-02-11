class Solution {
    // Using Striver Sheet +Shraddha
    
    public Node flatten(Node head) {
        if (head == null) return null;
        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node nextNode = curr.next;
                Node childList = flatten(curr.child);
                curr.next = childList;
                childList.prev = curr;
                curr.child = null;
                Node tail = childList;
                while (tail.next != null) {
                    tail = tail.next;
                }
                if (nextNode != null) {
                    tail.next = nextNode;
                    nextNode.prev = tail;
                }
            }
            curr = curr.next;
        }
        return head;
    }
}
