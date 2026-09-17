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
    int idx = 0;
    TreeNode root = null;
    HashMap<Integer , Integer> map = new HashMap<>();
    public TreeNode help(int[] preorder,int low, int high){
        if(low>high){
            return null;
        }
        TreeNode node = new TreeNode(preorder[idx]);
        int in = map.get(preorder[idx]);
        if(idx == 0){
            root = node;
        }
        idx++;
        node.left = help(preorder , low , in -1);
        node.right = help(preorder, in+1 , high);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i< inorder.length ; i++){
            map.put(inorder[i] , i);
        }
        return help(preorder, 0, inorder.length -1);
        
    }
}