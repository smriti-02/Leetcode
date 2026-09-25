class Pair{
    int x;
    int y;
    Pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] res = new int[n+1];
        Arrays.fill(res, Integer.MAX_VALUE);
        ArrayList<ArrayList<Pair>> arr = new ArrayList<>();
        for(int i =0 ; i<=n ; i++){
            arr.add(new ArrayList<>());
        }
        for(int i =0; i<times.length ; i++){
            int src = times[i][0];
            int des = times[i][1];
            int wt = times[i][2];
            arr.get(src).add(new Pair(des, wt));
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->{
            return a.x - b.x;
        });
        pq.add(new Pair(0, k));
        res[k] = 0;
        while(!pq.isEmpty()){
            Pair t = pq.peek();
            pq.poll();
            if(t.x > res[t.y]){
                continue;
            }
            for(int i = 0; i<arr.get(t.y).size(); i++){
                int dis = t.x + arr.get(t.y).get(i).y;
                int nei = arr.get(t.y).get(i).x;
                if(res[nei] > dis){
                    res[nei] = dis;
                    pq.add(new Pair(dis, nei));
                }
            }
        }
        int val = Integer.MIN_VALUE;
        for(int i = 1 ; i< res.length; i++){
            if(res[i] == Integer.MAX_VALUE){
                return -1;
            }
            val = Math.max(val, res[i]);
        }
        return val;
    }
}