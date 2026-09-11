/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    TreeNode res = null;
    public int help(TreeNode root , TreeNode p , TreeNode q){
        if(root == null){
            return 0;
        }
        int left = help(root.left , p , q);
        int right = help(root.right , p, q );
        int self = 0;
        if(root == p || root == q){
            self = 1;
        }
        int total = left + self + right;
        if(total == 2 && res == null){
            res = root;
        }
        return total;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        help(root , p  , q);
        return res;
    }
}