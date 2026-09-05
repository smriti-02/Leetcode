class Solution {
    public static void sol(int[] candidates, int target, List<Integer> diary , List<List<Integer>> arr , int ind, int sum){
        if(ind == candidates.length){
            if(sum == target){
                arr.add(new ArrayList<>(diary));
            }
            return;
        }
        sol(candidates , target , diary , arr, ind+1 , sum);
        if(sum < target){
            diary.add(candidates[ind]);
            sum += candidates[ind];
            sol(candidates , target , diary, arr, ind , sum);
            diary.remove(diary.size()-1);
            sum -= candidates[ind];
        }
    } 
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> arr = new ArrayList<>();
        int ind = 0;
        List<Integer> diary = new ArrayList<>();
        int sum = 0;
        sol(candidates , target, diary , arr , ind , sum);
        return arr;
    }
}