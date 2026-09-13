/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Stack<TreeNode> small = new Stack<>();
    Stack<TreeNode> big = new Stack<>();
    public int getSmall(){
        TreeNode t = small.peek();
        small.pop();
        int res = t.val;
        TreeNode right = t.right;
        while(right!= null){
            small.push(right);
            right = right.left;
        }
        return res;
    }
    public int getBig(){
        TreeNode t = big.peek();
        big.pop();
        int res = t.val;
        TreeNode left = t.left;
        while(left!= null){
            big.push(left);
            left = left.right;
        }
        return res;
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null){
            return false;
        }
        TreeNode t = root;
        while(t!= null){
            small.push(t);
            t = t.left;
        }
        TreeNode q = root;
        while(q != null){
            big.push(q);
            q= q.right;
        }
        int i = getSmall();
        int j = getBig();
        while( i<j){
            int sum = i+j;
            if(sum == k){
                return true;
            }
            else if(sum < k){
                i = getSmall();
            }
            else{
                j = getBig();
            }
        }
        return false;
    }
}