package medium.OddEvenLinkedList;

/**
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.
 *
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.
 *
 * Example 1:
 *
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 *
 * Example 2:
 *
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 *
 * Note:
 *
 *     The relative order inside both the even and odd groups should remain as it was in the input.
 *     The first node is considered odd, the second node even and so on ...
 */
public class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode t1 = new ListNode(-1);
        ListNode node1 = t1;
        ListNode t2 = new ListNode(-1);
        ListNode node2 = t2;
        int k =1;
        while(head!=null){
            if(k%2==1){
                t1.next = new ListNode(head.val);
                t1 = t1.next;
            }
            else{
                t2.next = new ListNode(head.val);
                t2 = t2.next;
            }
            k++;
            head = head.next;
        }
        t1.next = node2.next;
        return node1.next;

    }
    public static void main(String[] args){
        ListNode l1 = new ListNode(-1);
        ListNode node = l1;
        l1.next = new ListNode(1);
        l1 = l1.next;
        l1.next = new ListNode(2);
        l1 = l1.next;
        l1.next = new ListNode(3);
        l1 = l1.next;
        l1.next = new ListNode(4);
        l1 = l1.next;
        l1.next = new ListNode(5);
        ListNode ans = new Solution().oddEvenList(node.next);
        while(ans!=null){
            System.out.print(ans.val+" ");
            ans = ans.next;
        }

    }
}
