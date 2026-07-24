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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int sum = 0;
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode head = new ListNode();
        ListNode l3 = head;
        while(temp1 != null && temp2 != null){
            sum = temp1.val + temp2.val + carry;
            l3.next = new ListNode(sum % 10);
            carry = sum/10;
            temp1 = temp1.next;
            temp2 = temp2.next;
            l3 = l3.next;
        }
        while(temp1!= null){
            sum = temp1.val +carry;
            l3.next = new ListNode(sum%10);
            carry = sum/10;
            temp1 = temp1.next;
            l3 = l3.next;
        }
        while(temp2!= null){
            sum = temp2.val + carry;
            l3.next = new ListNode(sum%10);
            carry = sum/10;
            temp2 = temp2.next;
            l3 = l3.next;
        }
        if(carry != 0){
            l3.next = new ListNode(carry);
        }
        return head.next;

    }
}