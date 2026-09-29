class Pair{
    String s;
    int x;
    Pair(String s, int x){
        this.s = s;
        this.x = x;
    }
}
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s: wordList){
            map.put(s, 1);
        }
        if(!map.containsKey(beginWord)){
            map.put(beginWord ,1);
        }
        if(!map.containsKey(endWord)){
            return 0;
        }
        int val = 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord , 1));
        map.remove(beginWord);
        while(!q.isEmpty()){
            Pair t = q.poll();
            String st = t.s;
            if(st.equals(endWord)){
                return t.x;
            }
            char[] arr = st.toCharArray();
            for(int i = 0; i< st.length(); i++){
                char c = arr[i];
                for(char ch ='a'; ch <= 'z' ; ch++){
                    if(c == ch){
                        continue;
                    }
                    arr[i] = ch;
                    String newSt = new String(arr);
                    if(map.containsKey(newSt)){
                        q.add(new Pair(newSt, t.x+1));
                        map.remove(newSt);
                    }
                }
                arr[i] = c;
            }
        }
        return 0;
    }
}