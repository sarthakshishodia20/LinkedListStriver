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
    // Using Striver Sheet Soultion
    public ListNode swapPairs(ListNode head) {
        ListNode dummyNode=new ListNode(-1);
        dummyNode.next=head;
        ListNode temp=dummyNode;
        while(temp.next!=null && temp.next.next!=null){
            ListNode swap1=temp.next;
            ListNode swap2=temp.next.next;

            swap1.next=swap2.next;
            swap2.next=swap1;
            temp.next=swap2;
            temp=swap1;
        }
        return dummyNode.next;
    }
}
