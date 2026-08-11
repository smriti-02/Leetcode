class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int result_diff = Integer.MAX_VALUE;
        int result_sum = Integer.MAX_VALUE;
        for(int i = 0 ; i< nums.length - 1 ; i++){
            int left = i+1;
            int right = nums.length -1;
            int diff;
            while(left < right){
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == target){
                    result_diff = 0;
                    result_sum = sum;
                    break;
                }
                else if(sum > target){
                    right--;
                    diff = Math.abs(sum - target);
                }
                else{
                    left++;
                    diff = Math.abs(sum - target);
                }
                if(result_diff > diff){
                    result_diff = diff;
                    result_sum = sum;
                }
            }
        }
        return result_sum ;
    }
}