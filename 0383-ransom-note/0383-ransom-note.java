class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character , Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        int n = ransomNote.length();
        int m = magazine.length();
        for(int i = 0; i<n ; i++){
            map1.put(ransomNote.charAt(i) , map1.getOrDefault(ransomNote.charAt(i) , 0)+1);
        }
        for(int i = 0; i<m ; i++){
            map2.put(magazine.charAt(i) , map2.getOrDefault(magazine.charAt(i) , 0)+1);
        }
        for(HashMap.Entry<Character , Integer> entry: map1.entrySet()){
            if(!map2.containsKey(entry.getKey()) || map2.get(entry.getKey())<(entry.getValue())){
                return false;
            }
        }
        return true;
    }
}