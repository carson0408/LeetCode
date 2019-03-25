package medium.AddTwoNumbersII;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Follow up:
 * What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
 *
 * Example:
 *
 * Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 8 -> 0 -> 7
 */
public class Solution {
    /**
     *
     * @param l1
     * @param l2
     * @return
     * 解题思路：先将两个链表翻转，然后从各自表头依次遍历，依次相加，最后将结果再次翻转就是输出答案。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode l11 = reverse(l1);
        ListNode l21 = reverse(l2);
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;
        int t = 0;
        while(l11!=null&&l21!=null){
            temp.next = new ListNode((t+l11.val+l21.val)%10);
            t = (t+l11.val+l21.val)/10;
            l11 = l11.next;
            l21 = l21.next;
            temp = temp.next;
        }
        while(l11!=null){
            temp.next = new ListNode((t+l11.val)%10);
            t = (t+l11.val)/10;
            l11 = l11.next;
            temp = temp.next;
        }
        while(l21!=null){
            temp.next = new ListNode((t+l21.val)%10);
            t = (t+l21.val)/10;
            l21 = l21.next;
            temp = temp.next;
        }
        if(t>0){
            temp.next=new ListNode(t);
            temp = temp.next;
        }
        ListNode result = reverse(ans.next);
        return result;
    }
    //翻转链表
    public static ListNode reverse(ListNode node){
        ListNode temp = null;
        ListNode tmp = null;

        while(node!=null){
            tmp = node.next;
            node.next=temp;
            temp = node;
            node = tmp;

        }
        return temp;
    }
}
