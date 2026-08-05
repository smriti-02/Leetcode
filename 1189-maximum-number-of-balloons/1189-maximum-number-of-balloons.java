class Solution {
    public int maxNumberOfBalloons(String text) {
        int min = Integer.MAX_VALUE;
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for(int i = 0; i<text.length(); i++){
            map1.put(text.charAt(i) , map1.getOrDefault(text.charAt(i) , 0)+1);
        }
        map2.put('b' , 1);
        map2.put('a' , 1);
        map2.put('l', 2);
        map2.put('o' , 2);
        map2.put('n' , 1);
        for(HashMap.Entry<Character , Integer> entry: map2.entrySet()){
            if(!map1.containsKey(entry.getKey())){
                min = 0;
                break;
            }
            else{
                int n = map1.get(entry.getKey()) / entry.getValue();
                min = Math.min(min , n);
            }
        }
        return min;
    }
}