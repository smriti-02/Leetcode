class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> arr = new ArrayList<>();
        if(p.length() > s.length()){
            return arr;
        }
        HashMap<Character , Integer> map1 = new HashMap<>();
        for(char ch : p.toCharArray()){
            map1.put(ch , map1.getOrDefault(ch , 0)+1);
        }
        HashMap<Character, Integer> map2 = new HashMap<>();
        int ind = -1;
        for(int t= 0; t < p.length() ; t++){
            map2.put(s.charAt(t) , map2.getOrDefault(s.charAt(t) , 0)+1);
        }
        int i =0;
        int j = p.length() -1;
        while(j < s.length()){
            if(map1.equals(map2)){
                arr.add(i);
            }
            if(map2.get(s.charAt(i)) == 1){
                map2.remove(s.charAt(i));
            }
            else{
                map2.put(s.charAt(i) , map2.get(s.charAt(i))-1);
            }
            i++;
            j++;
            if(j < s.length()){
                map2.put(s.charAt(j) , map2.getOrDefault(s.charAt(j), 0)+1);
            }
        }
        return arr;
    }
}