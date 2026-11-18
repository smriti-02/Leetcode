class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int sum = 0;
        for(int i = 0; i<n ; i++){
            sum += nums[i];
        }
        int left = 0;
        int right = 0;
        for(int i = 0; i<n; i++){
            if(i != 0){
                left += nums[i-1];
            }
            if(i == n -1){
                right = 0;
            }
            else{
                right = sum - left - nums[i];
            }
            res[i] = Math.abs(left - right);
        }
        return res;
    }
}