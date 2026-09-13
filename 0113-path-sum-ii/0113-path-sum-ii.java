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
    public void help(TreeNode root , int targetSum, List<List<Integer>> list ,List<Integer> arr, int sum){
        if(root == null){
            return;
        }
        sum += root.val;
        arr.add(root.val);
        if(root.right == null && root.left == null){
            if(sum == targetSum){
                list.add(new ArrayList<>(arr));
            }
        }
        help(root.right , targetSum, list, arr, sum );
        help(root.left, targetSum , list , arr, sum);
        arr.remove(arr.size()-1);

    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        int sum = 0;
        help(root, targetSum, list, arr, sum);
        return list;
    }
}