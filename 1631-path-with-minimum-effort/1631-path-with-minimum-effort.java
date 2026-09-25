class Pair{
    int x;
    int y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Node{
    int t;
    Pair p;
    Node(int t, Pair p){
        this.t = t;
        this.p = p;
    }
}
class Solution {
    boolean valid(int x, int y, int n, int m){
        if(x >= 0 && x< n && y>=0 && y<m){
            return true;
        }
        return false;
    }
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] arr = new int[n][m];
        for(int i = 0; i<n; i++){
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) ->{
            return a.t - b.t;
        });
        pq.add(new Node(0,new Pair(0,0)));
        arr[0][0] = 0;
        int[] x ={-1, 1, 0, 0};
        int[] y = {0,0,-1,1};
        while(!pq.isEmpty()){
            Node l = pq.poll();
            int dis = l.t;
            int row = l.p.x;
            int col = l.p.y;
            if(dis> arr[row][col]){
                continue;
            }
            for(int i = 0; i<4; i++){
                int k = row + x[i];
                int p = col + y[i];
                if(!valid(k , p , n, m)){
                    continue;
                }
                int diff = Math.abs(heights[k][p] - heights[row][col]);
                int res = Math.max(diff , dis);
                if(res < arr[k][p]){
                    arr[k][p] = res;
                    pq.add(new Node(res, new Pair(k, p)));
                }
            }
        }
        return arr[n-1][m-1];
    }
}