class Solution {
    boolean valid(int i, int j , int n , int m){
        if(i<0 || i>= n || j<0 || j>=m){
            return false;
        }
        return true;
    }
    void dfs(char[][] grid, boolean[][] arr ,int i , int j, int n , int m){
        arr[i][j] =  true;
        int x[] = {-1, 1, 0, 0};
        int y[] = {0,0,-1,1};
        for(int k = 0; k<4 ; k++){
            int row = i+ x[k];
            int col = j + y[k];
            if(valid(row, col, n, m) && grid[row][col] == '1' && arr[row][col] == false ){
                dfs(grid, arr, row, col, n, m);
            }
        }
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean [][] arr = new boolean[n][m];
        int res = 0;
        for(int i = 0; i<n; i++){
            for(int j =0; j<m; j++){
                if(grid[i][j] == '1' && arr[i][j] == false){
                    dfs(grid, arr, i, j, n, m);
                    res++;
                }
            }
        }
        return res;
    }
}