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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = new ListNode();
        ListNode l3 = head;
        ListNode temp1 = list1;
        ListNode temp2 = list2;
        int t = 0;
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                t = temp1.val;
                l3.next = new ListNode(t);
                l3 = l3.next;
                temp1 = temp1.next;
            }
            else{
                t = temp2.val;
                l3.next = new ListNode(t);
                l3 = l3.next;
                temp2 = temp2.next;
            }
        }
        while(temp1 != null){
            t = temp1.val;
            l3.next = new ListNode(t);
            temp1 = temp1.next;
            l3 = l3.next;
        }
        while(temp2 != null){
            t = temp2.val;
            l3.next = new ListNode(t);
            temp2 = temp2.next;
            l3 = l3.next;
        }
        return head.next;
    }
}