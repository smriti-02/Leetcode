class Pair{
    int x;
    char t;
    Pair(int x , char t){
        this.x = x;
        this.t = t;
    }
}

class Solution {
    public String reorganizeString(String s) {
        HashMap <Character , Integer> map = new HashMap<>();
        PriorityQueue <Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.x != b.x){
                return b.x - a.x;
            }
            return Character.compare(a.t , b.t);
        });
        for(char ch : s.toCharArray()){
            map.put(ch , map.getOrDefault(ch , 0)+1);
        }
        for(HashMap.Entry<Character , Integer> entry : map.entrySet()){
            pq.add(new Pair(entry.getValue() , entry.getKey()));
        }
        String res = "";
        char prev = '#';
        while(!pq.isEmpty()){      
            Pair p = pq.poll();
            if(prev != p.t){
                res += p.t;
                p.x--;
                if(p.x != 0){
                    pq.add(p);
                }
                prev = p.t;
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                Pair q = pq.poll();
                res += q.t;
                q.x--;
                if(q.x != 0){
                    pq.add(q);
                }
                pq.add(p);
                prev = q.t;
            }
        }
        return res;
    }
}