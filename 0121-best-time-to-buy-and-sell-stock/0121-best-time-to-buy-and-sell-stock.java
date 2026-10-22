class Solution {
    public int prof(int[] prices, int k , int i, int[][] dp){
        if(dp[i][k] != -1){
            return dp[i][k];
        }
        if(k == 2){
            int c1 = prof(prices , k , i+1, dp);
            int c2 = prof(prices, k-1 , i+1, dp) - prices[i];
            return dp[i][k] = Math.max(c1, c2);
        }
        else if(k == 1){
            int a1 = prof(prices, k, i+1, dp);
            int a2 = prof(prices, k-1, i+1, dp) + prices[i];
            return dp[i][k] = Math.max(a1, a2);
        }
        return 0;
    }
    public int maxProfit(int[] prices) {
       int k = 2;
       int i = 0;
       int dp[][] = new int[prices.length +1][3];
       for(int j = 0 ; j< prices.length +1 ; j++){
            Arrays.fill(dp[j] , -1);
       }
       for(int j = 0; j<= prices.length; j++){
        dp[j][0] = 0;
       }
       dp[prices.length][1] = 0;
       dp[prices.length][2] = 0;
       return prof(prices, k , i, dp);

    }
}