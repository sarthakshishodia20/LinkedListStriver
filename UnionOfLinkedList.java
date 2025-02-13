class Solution {
    public static Node findUnion(Node head1, Node head2) {
        // Add your code here.
        // List<Integer> list=new ArrayList<>();
        TreeSet<Integer> list=new TreeSet<>();
        Node temp1=head1;
        Node temp2=head2;
        while(temp1!=null){
            if(list.contains(temp1.data)){
                temp1=temp1.next;
            }
            else{
            list.add(temp1.data);
            temp1=temp1.next;
            }
        }
        while(temp2!=null){
            if(list.contains(temp2.data)){
                temp2=temp2.next;
            }
            else{
                list.add(temp2.data);
                temp2=temp2.next;
            }
        }
        // Collections.sort(list);
        Node newHead=new Node(-1);
        Node newTemp=newHead;
       for(int it:list){
           Node newNode=new Node(it);
           newTemp.next=newNode;
           newTemp=newTemp.next;
       }
       return newHead.next;
        // return newHead;
    }
}
