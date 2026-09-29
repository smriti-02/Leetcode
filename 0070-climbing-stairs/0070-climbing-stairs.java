class Solution {
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int help(int i , int n){
        if(i == n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        int p = help(i+1, n);
        int k = help(i+2, n);
        int res = p+k;
        dp.put(i , res);
        return res;
    }
    public int climbStairs(int n) {
        return help(0, n);
    }
}