class Solution {
    public int binary(int low , int high , int mid , int nums[] , int target){
        if(low > high){
            return -1;
        }
        if(target > nums[mid]){
            low = mid +1;
            mid =low + (high - low)/2;
            return binary(low , high , mid , nums , target);
        }
        else if(target < nums[mid]){
            high = mid - 1;
            mid =low+ (high- low)/2;
            return binary(low , high , mid , nums , target); 
        }
        else{
            return mid;
        }
    }
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length -1;
        int mid =low + (high - low)/2;
        int t = binary(low , high , mid , nums , target);
        return t;
    }
}