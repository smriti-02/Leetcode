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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null){
            return res;
        }
        q.add(root);
        int right = 0;
        int left = 1;
        while(!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int n = q.size();
            while(n > 0){
                TreeNode t =q.poll();
                if(left == 1){
                    temp.add(t.val);
                }
                if(right == 1){
                   temp.add(0, t.val);
                }
                if(t.left != null){
                    q.add(t.left);
                }
                if(t.right != null){
                    q.add(t.right);
                }
                n--;
            }
            left = 1 - left;
            right = 1 - right;
            res.add(temp);
        }
        return res;
    }
}