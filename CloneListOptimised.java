class Solution {
    // Striver Sheet Solution 
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        insertBetweenNode(head);
        copyRandomNode(head);
        return getDeepCopy(head);
    }
    public static void insertBetweenNode(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = new Node(temp.val);
            copyNode.next = temp.next;
            temp.next = copyNode;
            temp = temp.next.next;
        }
    }
    public static void copyRandomNode(Node head) {
        Node temp = head;
        while (temp != null) {
            if (temp.random != null) {
                temp.next.random = temp.random.next;
            }
            temp = temp.next.next;
        }
    }
    public static Node getDeepCopy(Node head) {
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            if (temp != null) temp = temp.next;
        }
        return dummyNode.next;
    }
}
