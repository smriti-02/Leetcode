class Pair{
    int x;
    char ch;
    Pair(int x, char ch){
        this.x = x;
        this.ch = ch;
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.x != b.x){
               return b.x - a.x;
            }
            return Character.compare(a.ch , b.ch);
        });
        HashMap<Character , Integer> map = new HashMap<>();
        HashMap<Character , Integer> m = new HashMap<>();
        for(int i = 0; i<tasks.length ; i++ ){
            map.put(tasks[i] ,map.getOrDefault(tasks[i] , 0)+1);
        }
        for(HashMap.Entry<Character , Integer> entry: map.entrySet()){
            pq.add(new Pair(entry.getValue() , entry.getKey()));
            m.put(entry.getKey() , 1);
        }
        int res = 1;
        while(!pq.isEmpty()){
            if(m.get(pq.peek().ch)<= res){
                Pair p = pq.poll();
                m.remove(p.ch); 
                int t = res + n + 1;
                m.put(p.ch , t);
                p.x--;
                if(p.x != 0){
                    pq.add(p);
                }
                res++;
            }
            else{
                ArrayList<Pair> pulled = new ArrayList<>();
                while(!pq.isEmpty()){
                    Pair q = pq.poll();
                    if(m.get(q.ch) <= res){
                        m.remove(q.ch);
                        m.put(q.ch , res +n +1);
                        q.x--;
                        if(q.x!= 0){
                            pq.add(q);
                        }
                        break;
                    }
                    else{
                        pulled.add(q);
                    }
                }
                for(int i =0 ; i<pulled.size() ; i++){
                    pq.add(pulled.get(i));
                }
                res++;
            }
        }
        return res -1;
    }
}