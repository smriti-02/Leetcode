class Solution {
    public int lis(int[] nums, int n , int i , int prev , int[][] dp){
        if(i == n){
            return 0;
        }
        if(dp[i][prev+1] != -1){
            return dp[i][prev+1];
        }
        if(prev == -1 || nums[i]> nums[prev]){
            int c1 = 1 +  lis(nums , n, i+1 , i , dp);
            int c2 = lis(nums, n, i+1, prev, dp);
            return dp[i][prev+1] = Math.max(c1, c2);
        }
        return dp[i][prev+1] = lis(nums, n, i+1, prev, dp);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        int prev = -1;
        int i = 0;
        for(int j = 0; j<n ; j++){
            Arrays.fill(dp[j], -1);
        }
        return lis(nums, n, i, prev , dp);
    }
}