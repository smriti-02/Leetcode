class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    boolean valid(int row , int col, int n , int m){
        if(row>=0 && col >= 0 && row<n && col <m){
            return true;
        }
        return false;
    }
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] arr = new int[n][m];
        for(int i = 0; i<arr.length; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0));
        arr[0][0] = grid[0][0];
        while(!q.isEmpty()){
            Pair t = q.peek();
            q.poll();
            int row = t.x;
            int col = t.y;
            int x[] = {-1,1,0,0};
            int y[] = {0,0,-1,1};
            for(int i = 0; i<4; i++){
                int r = row + x[i];
                int c = col + y[i];
                if(!valid(r,c,n,m)){
                    continue;
                }
                if(arr[r][c] == Integer.MAX_VALUE){
                    arr[r][c] = Math.max(grid[r][c] , arr[row][col]);
                    q.add(new Pair(r,c));
                }
                else{
                    int ne = Math.min(arr[r][c] , Math.max(arr[row][col] , grid[r][c]));
                    if(ne < arr[r][c]){
                        arr[r][c] = ne;
                        q.add(new Pair(r ,c));
                    }
                }    
            }
        }
        return arr[n-1][m-1];
    }
}