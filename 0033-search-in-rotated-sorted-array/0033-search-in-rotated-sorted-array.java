class Solution {
    public int search(int[] nums, int target) {
        int l = 0;
        int n = nums.length;
        int h = n-1;
        int res = -1;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid] > nums[n-1]){
                if(nums[mid] < target){
                    l = mid +1;
                }
                else{
                    if(target < nums[0]){
                        l = mid+1;
                    }
                    else{
                        h = mid -1;
                    }
                }
            }
            else{
                if(target < nums[mid]){
                    h = mid -1;
                }
                else{
                    if(target > nums[n-1]){
                        h = mid - 1;
                    }
                    else{
                        l = mid +1;
                    }
                }
            }
        }
        return res;
    }
}