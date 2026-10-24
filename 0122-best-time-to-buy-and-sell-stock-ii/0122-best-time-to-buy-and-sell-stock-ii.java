class Solution {
    public int prof(int[] prices, int k , int i , int[][] dp){
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        else if(k == 2){
            int c1 = prof(prices, k, i+1 , dp);
            int c2 = prof(prices,k-1, i+1, dp) - prices[i];
            return dp[i][k] = Math.max(c1,c2);
        }
        else if(k ==1){
            int a1 = prof(prices, 1, i+1, dp);
            int a2 = prof(prices, 2, i+1, dp) + prices[i];
            return dp[i][k] = Math.max(a1,a2);
        }
        return 0;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+1][3];
        for(int i = 0; i<=n; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0 ; i<= n; i++){
            dp[i][0] = 0;
        }
        dp[n][1] = 0;
        dp[n][2] = 0;
        int k = 2;
        int i = 0;
        return prof(prices, k, i, dp);
    }
}