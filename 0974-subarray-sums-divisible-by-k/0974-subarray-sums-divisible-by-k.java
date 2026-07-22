class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int n = nums.length;
        int sum =0;
        int count =0;
        map.put(0,1);
        for(int i = 0; i<n ; i++){
            sum+= nums[i];
            int t = (sum%k + k) % k;
            if(map.containsKey(t)){
                count += map.get(t);
            }
            map.put(t , map.getOrDefault(t, 0)+1);

        }
        return count;
    }
}