class Solution {
    public int findMin(int[] nums) {
        int l = 0;
        int n = nums.length -1;
        int h = nums.length -1;
        int res = -1;
        while(l<= h){
            int mid = l+(h-l)/2;
            if(nums[mid] > nums[n]){
                l = mid +1;
            }
            else{
                res = nums[mid];
                h = mid -1;
            }
        }
        return res;
    }
}