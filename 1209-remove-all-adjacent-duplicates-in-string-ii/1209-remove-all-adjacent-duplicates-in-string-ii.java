 class Pair{
      char ch;
      int m;
      Pair(char ch , int m){
        this.ch = ch;
        this.m = m;
      }  
}
class Solution {
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stack = new Stack<>();
        int  n = s.length();
        String st = "";
        for(int i = 0; i< n; i++){
            if(stack.isEmpty()){
                stack.push(new Pair(s.charAt(i) , 1));
            }
            else if(stack.peek().ch != s.charAt(i)){
                stack.push(new Pair(s.charAt(i), 1));
            }
            else if(stack.peek().ch == s.charAt(i) && stack.peek().m == k-1){
                stack.pop();
            }
            else if(stack.peek().ch == s.charAt(i) && stack.peek().m < k-1){
                stack.peek().m++;
            }
        }
        while(!stack.isEmpty()){
            int l = stack.peek().m;
            while(l!=0){
                st += stack.peek().ch;
                l--;
            }
            stack.pop();
        }
        String str ="";
        for(int i = st.length()-1 ; i>= 0 ; i--){
            str += st.charAt(i);
        }
        return str;
    }
}