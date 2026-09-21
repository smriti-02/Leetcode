class Pair{
    int i;
    int j;
    Pair(int i , int j){
        this.i = i;
        this.j = j;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        Queue <Pair> q = new LinkedList<>();
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m ; j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j));
                    grid[i][j] = -1;
                }
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }
        int res =0;
        while(!q.isEmpty() && cnt > 0){
            res++;
            int t = q.size();
            while(t>0){
                int[] x = {-1,1,0,0};
                int[] y = {0,0,-1,1};
                for(int i= 0; i<4; i++){
                    int row = q.peek().i + x[i];
                    int col = q.peek().j + y[i];
                    if(row >= 0 && row < n && col >= 0 && col <m){
                        if(grid[row][col] == 1){
                            q.add(new Pair(row, col));
                            grid[row][col] = -1;
                            cnt--;
                        }
                    }
                }
                q.poll();
                t--;
            }
        }
        if(cnt >0 ){
            return -1;
        }
        return res;
    }
}