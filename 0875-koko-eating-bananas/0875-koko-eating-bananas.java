class Solution {
    public long cal(int[] piles , long s , int n){
        long h = 0;
        for(int i = 0; i < n ; i++){
            h = h + piles[i]/s;
            if(piles[i] % s != 0){
                h++;
            }
        }
        return h;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        long l = 1;
        long hi = 0;
        for(int i = 0; i<n ; i++){
            hi = Math.max(piles[i], hi);
        }
        long res = -1;
        while(l <= hi){
            long mid = l +(hi-l)/2;
            long sum = cal(piles, mid, n);
            if(sum > h){
                l = mid +1;
            }
            else{
                res = mid;
                hi = mid-1;
            }
        }
        return (int) res;
    }
}