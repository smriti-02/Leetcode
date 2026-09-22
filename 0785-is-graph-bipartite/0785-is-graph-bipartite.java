class Solution {
    boolean res = true;
    void dfs(int[][] graph, int i, int[] col, int c){
        col[i] = c;
        for(int j = 0; j < graph[i].length; j++){
            int t = graph[i][j];
            if(col[t] == -1){
                dfs(graph, t, col, 1-c);
            }
            else if(col[t] == c ){
                res = false;
            }
        }
        return;
    }
    public boolean isBipartite(int[][] graph) {
        int[] col = new int[graph.length];
        for(int i = 0; i<graph.length; i++){
            col[i] = -1;
        }
        for(int i =0; i<graph.length ; i++){
            if(col[i] == -1)
            dfs(graph, i, col, 0);
        }
        return res;
    }
}