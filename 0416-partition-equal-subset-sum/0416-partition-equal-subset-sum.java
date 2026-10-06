class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i<n ; i++){
            sum += nums[i];
        }
        if(sum % 2 != 0){
            return false;
        }
        int tot = sum/2;
        boolean[][] dp = new boolean[n+1][tot+1];
        dp[n][0] = true;
        for(int i = n-1 ; i>= 0; i--){
            for(int j = 0; j<=tot ; j++){
                if(nums[i]>j){
                    dp[i][j] = dp[i+1][j];
                }
                else{
                    dp[i][j] = dp[i+1][j] || dp[i+1][j -nums[i]];
                }
            }
        }
        return dp[0][tot];
    }
}