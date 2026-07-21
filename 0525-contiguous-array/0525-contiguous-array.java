class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        int res =0;
        int zero = 0;
        int one = 0;
        map.put(0,-1);
        for(int i = 0; i<n ; i++){
            if(nums[i] == 0){
                zero++;
            }
            else{
                one++;
            }
            int dif = one - zero;
            if(map.containsKey(dif)){
                int t = i - map.get(dif);
                res = Math.max(t , res);
            }
            else{
                map.put(dif, i);
            }
            
        }
        return res;
    }
}