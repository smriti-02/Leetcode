class Solution {
    public List<String> stringMatching(String[] words) {
        ArrayList<String> str = new ArrayList<>();
        for(String s : words){
            for(String t: words){
                if(s != t && t.contains(s)){
                    str.add(s);
                    break;
                }
            }
        }
        return str;
    }
}