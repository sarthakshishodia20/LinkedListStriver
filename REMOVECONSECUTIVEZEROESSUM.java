class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while (temp != null) {
            list.add(temp.val);
            temp = temp.next;
        }
        boolean found = true;
        while (found) {
            found = false;
            for (int i = 0; i < list.size(); i++) {
                int sum = 0;
                for (int j = i; j < list.size(); j++) {
                    sum += list.get(j);
                    if (sum == 0) {
                        for (int k = j; k >= i; k--) {
                            list.remove(k); 
                        }
                        found = true;
                        break; 
                    }
                }
                if (found) break;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int val : list) {
            curr.next = new ListNode(val);
            curr = curr.next;
        }
        return dummy.next;
    }
}
