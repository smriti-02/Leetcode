class Solution {
    public void nextPermutation(int[] nums) {
        int index = -1;
        int n = nums.length;
        for (int i = n-2 ; i >= 0 ; i--){
            if (nums[i]<nums[i+1]){
                index = i;
                break;
            }
        }
        if (index!=-1){
            for(int i= n-1 ; i> index ; i--){
                if (nums[index]<nums[i]){
                    int temp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = temp;
                    break;
                }
            }
        }
        int t = n-1;
        for(int i = index+1,j=n-1 ; i < j; i++,j--){
            int temp = nums[t];
            nums[t] = nums[i];
            nums[i] = temp;
            t--; 
        }
    }
}