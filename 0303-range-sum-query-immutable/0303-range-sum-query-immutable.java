class NumArray {
    int[] res;
    public NumArray(int[] nums) {
        res = new int[nums.length];
        res[0] = nums[0];
        for(int i = 1; i<nums.length ; i++){
            res[i] = res[i-1] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        if(left == 0){
            return res[right];
        }
        else{
            return res[right] - res[left -1];
        }
    }
}
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */