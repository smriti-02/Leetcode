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
    public static void rev(ListNode left , int k){
        ListNode prev = null;
        int n = k;
        while(n >0){
            ListNode temp = left.next;
            left.next = prev;
            prev = left;
            left = temp;
            n--;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode left = head;
        ListNode right = null;
        ListNode prevleft = null;
        ListNode res = null;
        ListNode nextleft = null;
        while(true){
            right = left;
            for(int i = 0; i <k-1; i++){
                right = right.next;
                if(right == null){
                    prevleft.next = left;
                    return res;
                }
            }
            nextleft = right.next;
            rev(left , k);
            if(prevleft!=null){
                prevleft.next = right;
            }
            prevleft = left;
            left = nextleft;
            if(res == null){
                res = right;
            }
            if(left == null){
                break;
            }
        }
        return res;
    }
}