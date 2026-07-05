class Solution {
    public int find(int[] arr){
        int max = 0;
        for(int i =0 ; i<256 ; i++ ){
            max = Math.max(arr[i], max);
        }
        return max;
    }
    public int characterReplacement(String s, int k) {
        int low = 0;
        int res = 0;
        int arr [] = new int[256];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            arr[ch] ++;
            int len = i - low + 1;
            int diff = len - find(arr);
            while(diff > k){
                arr[s.charAt(low)]--;
                low++;
                len = i - low + 1;
                diff = len - find(arr);
            }
            res = Math.max(res, len);
        }
        return res;
    }
}