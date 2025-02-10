/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // StrIver Sheet Solution 
    public static ListNode getKth(ListNode head, int k) {
        ListNode temp = head; 
        int c = 0;
        while (temp != null && c < k - 1) { 
            temp = temp.next;
            c++;
        }
        return temp;
    }
    public static void reverse(ListNode head) {
        ListNode currNode = head;
        ListNode prevNode = null;
        ListNode next;
        while (currNode != null) {
            next = currNode.next;
            currNode.next = prevNode;
            prevNode = currNode;
            currNode = next;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode nextNode = null;
        ListNode prevNode = null;
        while (temp != null) {
            ListNode KthNode = getKth(temp, k);
            if (KthNode == null) {
                if (prevNode != null) {
                    prevNode.next = temp;
                }
                break;
            }
            nextNode = KthNode.next;
            KthNode.next = null;
            reverse(temp); 
            if (temp == head) {
                head = KthNode; 
            } else {
                prevNode.next = KthNode; 
            }   
            prevNode = temp; 
            temp = nextNode; 
        }
        return head; 
    }
}
