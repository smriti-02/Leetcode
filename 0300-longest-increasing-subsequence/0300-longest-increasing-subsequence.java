class Solution {
    public int lengthOfLIS(int[] nums) {
       int n = nums.length;
       int[] res = new int[n];
       int max= Integer.MIN_VALUE;
       for(int i = 0; i<n; i++){
            res[i] = 1;
            for(int j= 0; j<i; j++){
                if(nums[i]>nums[j]){
                    res[i] = Math.max(res[i], res[j]+1);
                }
            }
            max = Math.max(max, res[i]);
       }
       return max;
    }
}