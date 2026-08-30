class Pair{
    int x;
    int y;
    Pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public static int calc (int x , int y){
        int res = x*x + y*y;
        return res;
    }
    public int[][] kClosest(int[][] points, int k) {
        int[][] arr = new int[k][2];
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) ->{
        return (calc(b.x , b.y) - calc(a.x , a.y));
        });
        for(int i = 0; i<k ; i++){
            pq.add(new Pair(points[i][0] , points[i][1]));
        }
        for(int i = k ; i<points.length ; i++){
            if(calc(points[i][0] , points[i][1]) < calc(pq.peek().x , pq.peek().y)){
                pq.poll();
                pq.add(new Pair(points[i][0] , points[i][1]));
            }
        } 
        int i = 0;   
        while(!pq.isEmpty()){
            arr[i][0] = pq.peek().x;
            arr[i][1] = pq.peek().y;
            pq.poll();
            i++;
        }

        return arr;
    }
}