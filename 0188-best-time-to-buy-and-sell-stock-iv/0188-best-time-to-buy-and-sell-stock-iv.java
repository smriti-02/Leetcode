class Solution {
    public int prof(int[] prices, int l, int i, int[][] dp){
        if(dp[i][l] != -1){
            return dp[i][l];
        }
        else if(l%2 == 0){
            int c1 = prof(prices, l , i+1, dp);
            int c2 = prof(prices, l-1, i+1, dp) - prices[i];
            return dp[i][l] = Math.max(c1, c2);
        }
        else{
            int a1 = prof(prices, l, i+1, dp);
            int a2 = prof(prices, l-1, i+1, dp) + prices[i];
            return dp[i][l] = Math.max(a1, a2);
        }
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int l = k*2;
        int dp [][] = new int[n+1][l+1];
        for(int i = 0; i<= n; i++){
            Arrays.fill(dp[i], -1);
        }
        for(int i = 0; i<=n ; i++){
            dp[i][0] = 0;
        }
        for(int i = 0; i<=l; i++){
            dp[n][i]= 0;
        }
        int i = 0; 
        return prof(prices, l, i, dp);
    }
}