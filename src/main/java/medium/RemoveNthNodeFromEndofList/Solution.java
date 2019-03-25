package medium.RemoveNthNodeFromEndofList;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(n==0)
            return head;
        ListNode pre = head;
        ListNode temp = head,li = head;

        ListNode tmp;
        int len = 0;
        while(pre!=null){
            len+=1;
            pre=pre.next;
        }
        n = n%len;
        int i = 1;
        while(i<n){
            temp = temp.next;
            i++;
        }
        while(temp!=null){
            li = li.next;
            temp = temp.next;
        }
        li.next = li.next.next;
        return head;

    }
}
