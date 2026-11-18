class Solution {
    public int findMiddleIndex(int[] nums) {
        int res = -1;
        int left = 0;
        int sum = 0;
        int right = 0;
        for(int i = 0; i< nums.length; i++){
            sum += nums[i];
        }
        for(int i = 0; i<nums.length; i++){
            if(i == 0){
                left = 0;
            }
            else{
                left += nums[i-1];
            }
            if(i == nums.length -1){
                right = 0;
            }
            else{
                right = sum - left - nums[i];
            }
            if(left == right){
                res = i;
                break;
            }
        }
        return res;
    }
}