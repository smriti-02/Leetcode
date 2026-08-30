class Pair{
    int first ;
    String sec;
    Pair(int f , String s){
        first = f;
        sec = s;
    }
}
class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        ArrayList<String> arr = new ArrayList<>();
        HashMap <String , Integer> map = new HashMap<>();
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) ->{
            if(a.first != b.first){
                return a.first - b.first;
            }
        return b.sec.compareTo(a.sec);
        });
        for(int i = 0 ; i <words.length ; i++){
            map.put(words[i] , map.getOrDefault(words[i], 0)+1);
        }
        int cnt = 0;
        for(HashMap.Entry<String , Integer> entry: map.entrySet()){
            if(cnt<k){
                pq.add(new Pair(entry.getValue() , entry.getKey()));
                cnt++;
            }
            else{
                if(entry.getValue() > pq.peek().first || (entry.getValue() == pq.peek().first && entry.getKey().compareTo(pq.peek().sec)<0) ){
                    pq.poll();
                    pq.add(new Pair(entry.getValue(), entry.getKey()));
                }
            }
        }
        while(!pq.isEmpty()){
            arr.add(pq.poll().sec);
        }
        Collections.reverse(arr);
        return arr;
    }
}