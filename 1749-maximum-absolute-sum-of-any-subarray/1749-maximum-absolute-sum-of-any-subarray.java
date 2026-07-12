class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = Math.abs(nums[0]);
        int n= nums.length;
        for(int i =1; i<n; i++){
            int p = max + nums[i];
            int q = min + nums[i];
            int v = nums[i];
            max = Math.max(v, Math.max(p,q));
            min = Math.min(v, Math.min(p,q));
            res = Math.max(res , Math.max(Math.abs(max) ,Math.abs(min)));
        }
        return res;
    }
}