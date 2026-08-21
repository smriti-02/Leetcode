class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int end = 0;
        int max_length = 0;
        List <Character> list = new ArrayList<Character>();
        while(end<s.length()){
            if(!list.contains(s.charAt(end))){
                list.add(s.charAt(end));
                end++;
                max_length = Math.max(max_length , list.size());
            }
            else{
                list.remove(Character.valueOf(s.charAt(start)));
                start++;
            }
        }
        return max_length;
    }
        // int max = Integer.MIN_VALUE;
        // HashMap <Character, Integer> map = new HashMap<>();
        // if(s.isEmpty()){
        //     return 0;
        // }

        // for(char ch : s.toCharArray()){
        //     if(map.containsKey(ch)){
                
        //     }
        //     map.put(ch , 1);
        //     max = Math.max(map.size(), max);
        // }
        // return max;
    // }
}