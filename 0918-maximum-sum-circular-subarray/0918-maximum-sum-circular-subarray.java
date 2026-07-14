class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int minSum = nums[0];
        int n = nums.length;
        int s = 0;
        for(int i =0; i < n; i++){
            s += nums[i];
        }
        for(int i = 1; i<n ; i++){
            int sum = maxSum + nums[i];
            int v = nums[i];
            int p = minSum + nums[i];
            minSum = Math.min(v,p);
            min = Math.min(min, minSum);
            maxSum = Math.max(sum, v);
            max = Math.max(max, maxSum);
            
        }
        if(max < 0){
            return max;
        }
        else{
            return Math.max(res, Math.max((s-min), max));
        }
    }
}