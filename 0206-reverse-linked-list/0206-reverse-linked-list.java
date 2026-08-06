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
    public ListNode reverseList(ListNode head) {
        ListNode i = null;
        ListNode j = head;
        while(j != null){
            ListNode temp = j.next;
            j.next = i;
            i = j;
            j = temp;
        }
        head = i;
        return head;
    }
}