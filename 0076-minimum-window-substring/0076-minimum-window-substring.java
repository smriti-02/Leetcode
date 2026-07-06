class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int n1 = t.length();
        for(int i = 0; i<n1 ; i++){
            char ch = t.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }
        int l = 0;
        int n = s.length();
        int min = Integer.MAX_VALUE;
        int r=0 , m=0;
        for(int h = 0; h <n ; h++){
            char c = s.charAt(h);
            map1.put(c, map1.getOrDefault(c,0)+1);
            while(check(map1 , map2)){
                int len = h - l + 1;
                if(len < min){
                    r = l;
                    m = h;
                    min = len;
                }
                map1.put(s.charAt(l), map1.get(s.charAt(l))-1);
                l++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if(min == Integer.MAX_VALUE){
            sb.append("");
        }
        else{
            for(int i = r; i <= m ; i++){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public boolean check(HashMap<Character, Integer> map1 , HashMap<Character, Integer> map2){
        for(Character key : map2.keySet()){
            if(!map1.containsKey(key) || map1.get(key) < map2.get(key)){
                return false;
            }
        }
        return true;
    }
}