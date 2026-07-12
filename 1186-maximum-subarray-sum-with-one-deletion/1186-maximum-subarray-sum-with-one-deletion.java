class Solution {
    public int maximumSum(int[] arr) {
        int noDelete = arr[0];
        int oneDelete = Integer.MIN_VALUE;
        int res = arr[0];
        int n = arr.length;
        for(int i = 1; i < n; i++){
            int p = noDelete;
            noDelete = Math.max(noDelete + arr[i] , arr[i]);
            int v;
            if(oneDelete == Integer.MIN_VALUE){
                v = arr[i];
            }
            else{
                v = oneDelete + arr[i];
            }
            oneDelete = Math.max(v, p);
            res = Math.max(res , Math.max(noDelete , oneDelete));
        }
        return res;
    }
}