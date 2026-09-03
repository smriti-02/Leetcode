class Solution {
    static void solve(int n , int o , int c, List<String> arr ,String temp ){
        if(o == n && c == n){
            arr.add(temp);
            return;
        }
        if(o < n){
            solve(n , o+1 , c, arr, temp +"(");
        }
        if(c < o){
            solve(n , o, c+1 , arr , temp + ")");
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> arr = new ArrayList<>();
        String temp = "";
        int o =0;
        int c = 0;
        solve(n, o, c, arr, temp);
        return arr;
    }
}