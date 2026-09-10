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
    // public void help(TreeNode p , TreeNode q){
    //     if(p == null && q == null){
    //         return;
    //     }
    //     if(p == null && q != null){
    //         p.val = q.val;
    //         q = null;
    //     }
    //     else if(q == null && p != null){
    //         q.val = p.val;
    //         p = null;
    //     }
    //     else{
    //         int temp = p.val;
    //         p.val = q.val;
    //         q.val = temp;
    //     }
    //     help(p.left , q.right);
    //     help (p.right , q.left);
    // }
    public void help(TreeNode root){
        if(root == null){
            return;
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = tmp;
        help(root.left);
        help(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        help(root);
        
        return root;
    }
}