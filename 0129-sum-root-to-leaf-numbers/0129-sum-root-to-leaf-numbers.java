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
    public void help(TreeNode root , List<Integer> li, String st){
        if(root == null){
            return;
        }
        st += root.val;
        if(root.right == null && root.left == null){
            int t = Integer.parseInt(st);
            li.add(t);
        }
        help(root.left , li , st);
        help(root.right , li , st);
    } 
    public int sumNumbers(TreeNode root) {
        int sum = 0;
        String st = "";
        List<Integer> li = new ArrayList<>();
        help(root , li, st);
        for(int i = 0 ; i<li.size() ; i++){
            sum  += li.get(i);
        }
        return sum;
    }
}