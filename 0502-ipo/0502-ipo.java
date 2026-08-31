class Pair{
    int x ;
    int y ;
    Pair(int x , int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        ArrayList<Pair> arr= new ArrayList<>();
        PriorityQueue <Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i< profits.length ; i++){
            arr.add(new Pair(capital[i] , profits[i]));
        }
        arr.sort((a,b) ->{ if(a.x!= b.x){return a.x - b.x;}
        return a.y - b.y;});
        int ind = 0;
        while(k != 0){
            while(ind < profits.length && arr.get(ind).x <= w){
                pq.add(arr.get(ind).y);
                ind++;
            }
            if(pq.isEmpty()){
                return w;
            }
            w += pq.poll();
            k--;
        }
        return w;
    }
}