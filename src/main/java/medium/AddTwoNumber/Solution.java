package medium.AddTwoNumber;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {//链表的加法
        ListNode ans = new ListNode(-1);
        ListNode pre = ans;
        int t = 0;
        while(l1!=null&&l2!=null){
            int temp = l1.val+l2.val+t;
            int va = temp%10;
            t = temp/10;
            ListNode tmp = new ListNode(va);
            pre.next = tmp;
            pre = pre.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null){
            int temp = l1.val+t;
            int va = temp%10;
            t = temp/10;
            ListNode tmp = new ListNode(va);
            pre.next = tmp;
            pre = pre.next;
            l1=l1.next;
        }

        while(l2!=null){
            int temp = l2.val+t;
            int va = temp%10;
            t = temp/10;
            ListNode tmp = new ListNode(va);
            pre.next = tmp;
            pre = pre.next;
            l2 = l2.next;
        }
        if(t>0){
            ListNode tmp = new ListNode(t);
            pre.next = tmp;
            pre = pre.next;
        }

        return ans.next;

    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(-1);
        ListNode l11 = l1;
        l11.next = new ListNode(2);
        l11 = l11.next;
        l11.next = new ListNode(4);
        l11 = l11.next;
        l11.next = new ListNode(3);
        l11 = l11.next;

        ListNode l2 = new ListNode(-1);
        ListNode l22 = l2;
        l22.next = new ListNode(5);
        l22 = l22.next;
        l22.next = new ListNode(6);
        l22 = l22.next;
        l22.next = new ListNode(4);
        l22 = l22.next;

        ListNode ans = new Solution().addTwoNumbers(l1.next,l2.next);
        while(ans.next!=null){
            System.out.print(ans.val+"->");
            ans = ans.next;
        }
        System.out.print(ans.val);
    }
}
