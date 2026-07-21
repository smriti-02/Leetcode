class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        String str = "";
        for(int i = 0; i< s.length() ; i++){
            if(Character.isLetter(s.charAt(i))|| Character.isDigit(s.charAt(i))){
                str += s.charAt(i);
            }
        }
        int n = 0;
        int m = str.length() -1;
        while(n<=m){
            if(str.charAt(n)!= str.charAt(m)){
                return false;
            }
            n++;
            m--;
        }
        return true;
    }
}