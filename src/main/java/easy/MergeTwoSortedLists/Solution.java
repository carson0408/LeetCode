package easy.MergeTwoSortedLists;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(-1);
        ListNode pre =l;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                pre.next = new ListNode(l1.val);
                l1 = l1.next;
                pre = pre.next;
            }
            else{
                pre.next = new ListNode(l2.val);
                l2 = l2.next;
                pre = pre.next;
            }
        }
        while(l1!=null){
            pre.next = new ListNode(l1.val);
            l1 = l1.next;
            pre = pre.next;
        }
        while(l2!=null){
            pre.next = new ListNode(l2.val);
            l2 = l2.next;
            pre = pre.next;
        }
        return l.next;

    }
}
