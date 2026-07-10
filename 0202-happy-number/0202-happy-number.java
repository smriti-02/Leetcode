class Solution {
    public int res(int n ){
        int s = 0;
        while(n!=0){
            int d = (n % 10);
            s += d * d;
            n = n/10;
        }
        return s;
    }
    public boolean isHappy(int n) {
        int s = n;
        int f = n;
        while(f!=1){
            s = res(s);
            f = res(f);
            f = res(f);
            if(s == f && f!=1){
                return false;
            }
        }
        return true;
    }
}