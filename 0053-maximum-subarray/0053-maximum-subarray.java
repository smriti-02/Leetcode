class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum =nums[0];
        int res = nums[0];
        int n = nums.length;
        for(int i =1; i <n; i++){
            int sum = maxSum + nums[i];
            int v = nums[i];
            maxSum = Math.max(sum , v);
            res = Math.max(res, maxSum);
        }
       return res;
    }
}