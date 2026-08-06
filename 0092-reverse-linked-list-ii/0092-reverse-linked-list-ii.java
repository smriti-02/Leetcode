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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int cnt = 1;
        ListNode t = head;
        ListNode leftN = null;
        ListNode rightNode = null;
        ListNode before = null;
        while(t != null ){
            if(cnt == left ){
                leftN = t;
            }
            if(cnt == right){
                rightNode = t;
            }
            if( left != 1 && cnt == left-1){
                before = t;
            }
            t = t.next;
            cnt++;
        }
        ListNode leftNode = leftN;
        ListNode prev = null;
        ListNode tmp = null;
        int times = right - left +1;
        int count =0;
        while(count < times){
            tmp = leftNode.next;
            leftNode.next = prev;
            prev = leftNode;
            leftNode = tmp;
            count++;
        }
        leftN.next = tmp;
        if(before != null && before.next!= null){
            before.next = rightNode;
            return head;
        }
        
        
        return rightNode;
    }
}