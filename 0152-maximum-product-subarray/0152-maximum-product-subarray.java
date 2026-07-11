class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int res = nums[0];
        int n = nums.length;
        for(int i = 1; i <n ; i++){
            int a = max * nums[i];
            int c = min* nums[i];
            int b = nums[i];
            min = Math.min(a, Math.min(b , c));
            max = Math.max(a, Math.max(b , c));
            res = Math.max(res, max);
        }
        return res;
    }
}