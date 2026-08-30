class Pair{
    int first;
    int sec;
    Pair(int f , int s){
        first = f;
        sec = s;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        HashMap <Integer , Integer> map = new HashMap<>();
        PriorityQueue <Pair> pq = new PriorityQueue<>( (a,b) -> {if(a.first != b.first){
            return a.first - b.first;}
        return a.sec - b.sec;}); 
        for(int i = 0 ; i<nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i] , 0)+1);
        }
        int cnt = 0;
        for(HashMap.Entry <Integer , Integer> entry : map.entrySet()){
            if(cnt < k){
                pq.add(new Pair(entry.getValue() , entry.getKey()));
                cnt++;
            }
            else{
                if(entry.getValue() > pq.peek().first){
                    pq.poll();
                    pq.add(new Pair(entry.getValue() , entry.getKey()));
                }
            }
        }
        int i = 0;
        while(!pq.isEmpty()){
            arr[i] = pq.poll().sec;
            i++;
        }
        return arr;
    }
}