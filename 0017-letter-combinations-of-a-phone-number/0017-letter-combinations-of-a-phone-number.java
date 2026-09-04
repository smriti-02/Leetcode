class Solution {
    static void sol(String digits , String temp , List<String> arr , int ind, HashMap<Character, String> map){
        if(ind == digits.length()){
            arr.add(temp);
            return;
        }
        String choice = map.get(digits.charAt(ind));
        for(char ch : choice.toCharArray()){
            sol(digits , temp + ch , arr , ind+1, map );
        }

    }
    public List<String> letterCombinations(String digits) {
        HashMap<Character , String> map = new HashMap<>();
        map.put('2' , "abc");
        map.put('3' , "def");
        map.put('4', "ghi");
        map.put('5' ,"jkl");
        map.put('6', "mno");
        map.put('7' ,"pqrs");
        map.put('8' , "tuv");
        map.put('9' , "wxyz");
        String temp = "";
        List<String> arr = new ArrayList<>();
        int ind = 0;
        sol(digits , temp , arr , ind , map );
        return arr;
    }
}