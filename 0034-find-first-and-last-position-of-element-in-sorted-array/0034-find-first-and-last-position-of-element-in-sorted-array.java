class Solution {
    public int[] searchRange(int[] nums, int target) {
        int low = 0;
        int [] arr = new int[2];
        int high = nums.length - 1;
        int first = -1;
        int last = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{
                first = mid;
                high = mid -1;
            }
        }
        arr[0] = first;
        low = 0;
        high = nums.length -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] < target){
                low = mid + 1;
            }
            else if(nums[mid] > target){
                high = mid -1;
            }
            else{
                last = mid;
                low = mid + 1;
            }
        }
        arr[1] = last;
        return arr;
    }
}