class Solution {
    public int prof(int[] prices, int i , int k , int[][] dp){
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        else if(k%2 == 0){
            int c1 = prof(prices, i+1, k, dp);
            int c2 = prof(prices, i+1, k-1, dp) - prices[i];
            return dp[i][k] = Math.max(c1, c2);
        }
        else {
            int a1 = prof(prices, i+1, k, dp);
            int a2 = prof(prices, i+1, k-1 , dp) + prices[i];
            return dp[i][k] = Math.max(a1, a2);
        }
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp[][] = new int[n+1][5];
        for(int i = 0; i<=n ; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i<= n; i++){
            dp[i][0] = 0;
        }
        dp[n][1] = 0;
        dp[n][2]= 0;
        dp[n][3] = 0;
        dp[n][4] = 0;
        int k = 4;
        int i = 0;
        return prof(prices, i, k , dp);
    }
}