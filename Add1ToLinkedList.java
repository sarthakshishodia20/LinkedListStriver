class Solution {
    //add one to linked list
    public Node reverse(Node head){
        Node prev = null;
        Node currNode = head;
        Node next;
        while (currNode != null) {
            next = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = next;
        }
        return prev;
    }

    public Node addOne(Node head) {
        head = reverse(head);
        Node temp = head;
        int carry = 1; 

        while (temp != null) {
            temp.data += carry;
            if (temp.data < 10) {
                carry = 0;
                break;
            } else {
                temp.data = 0;
                carry = 1;
            }
            if (temp.next == null && carry > 0) {
                temp.next = new Node(1);
                carry = 0;
            }
            temp = temp.next;
        }
        return reverse(head);
    }
}
