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
    boolean b = false;
    public void help(TreeNode root , int targetSum , int sum){
        if(root == null){
            return;
        }
        sum += root.val;
        if(root.left == null && root.right == null){
            if(sum == targetSum){
                b = true;
            }
        }
        help(root.left , targetSum , sum);
        help(root.right, targetSum , sum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        int sum = 0;
        help(root , targetSum , sum);
        return b;
    }
}