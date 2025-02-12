class Solution {

public static boolean isVowel(Character ch){
    return ch=='a' || ch=='e' || ch=='i'|| ch=='o'||ch=='u';
}
    public Node arrangeCV(Node head) {
        // write code here and return the head of changed linked list
        Node vowelHead=null ,vowelTemp=null;
        Node consonantHead=null, consonantTemp=null;
        Node temp=head;
        while(temp!=null){
            if(isVowel(temp.data)){
                if(vowelHead==null){
                    vowelHead=vowelTemp=temp;
                }
                else{
                    vowelTemp.next=temp;
                    vowelTemp=vowelTemp.next;
                }
            }
            else{
                if(consonantHead==null){
                    consonantHead=consonantTemp=temp;
                }
                else{
                    consonantTemp.next=temp;
                    consonantTemp=consonantTemp.next;
                }
            }
            temp=temp.next;
        }
        if(vowelHead==null){
            return consonantHead;
        }
        if(consonantHead==null){
            return vowelHead;
        }
        vowelTemp.next=consonantHead;
        consonantTemp.next=null;
        return vowelHead;
    }
}
