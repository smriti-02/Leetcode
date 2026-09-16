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
    int wrong = 0;
    TreeNode w1first = null;
    TreeNode w1second = null;
    TreeNode w2first = null;
    TreeNode w2second = null;
    TreeNode prev = null;
    public void help(TreeNode root){
        if(root == null){
            return;
        }
        help(root.left);
        if(prev == null){
            prev = root;
        }
        else{
            if(prev.val >= root.val){
                wrong++;
                if(wrong == 1){
                    w1first = prev;
                    w1second = root;
                }
                if(wrong == 2){
                    w2first = prev;
                    w2second = root;
                }
            }
            prev = root;
        }
        help(root.right);
    }
    public void recoverTree(TreeNode root) {
        help(root);
        if(wrong == 1){
            int temp = w1first.val;
            w1first.val = w1second.val;
            w1second.val = temp;
        }
        if(wrong == 2){
            int temp = w1first.val;
            w1first.val = w2second.val;
            w2second.val = temp;
        }
    }
}