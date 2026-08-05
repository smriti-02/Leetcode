class Solution {
    public int longestPalindrome(String s) {
        int odd = 0;
        int res = 0;
        HashMap<Character , Integer> map = new HashMap<>();
        for(char ch: s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }
        for(HashMap.Entry<Character , Integer> entry: map.entrySet()){
            if(entry.getValue()%2 == 0){
                res += entry.getValue();
            }
            else{
                odd =1;
                res += entry.getValue() -1;
            }
        }
        return res + odd;
    }
}