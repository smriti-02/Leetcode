class Solution {
    public boolean checkInclusion(String s1, String s2) {
        HashMap <Character , Integer> map1 = new HashMap<>();
        for(char ch : s1.toCharArray()){
            map1.put(ch , map1.getOrDefault(ch, 0)+1);
        }
        HashMap <Character , Integer> map2 = new HashMap<>();
        int i = 0; 
        int j = 0;
        if(s1.length() > s2.length()){
            return false;
        }
        while(j < s1.length()){
            char c = s2.charAt(j);
            map2.put(c, map2.getOrDefault(c, 0)+1);
            j++;
        }
        j = j-1;
        boolean res = false;
        while(j < s2.length()){
            if(map1.equals(map2)){
                return true;
            }
            if(map2.get(s2.charAt(i)) == 1){
                map2.remove(s2.charAt(i));
            }
            else{
                map2.put(s2.charAt(i) , map2.get(s2.charAt(i))-1);
            }
            i++;
            j++;
            if(j < s2.length()){
                map2.put(s2.charAt(j) , map2.getOrDefault(s2.charAt(j), 0)+1);
            }
        }
        return res;
    }
}