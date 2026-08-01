class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        int n = s.length();
        String str = "";
        for(int i = 0; i <n ;i++){
            if(stack.isEmpty()){
                stack.push(s.charAt(i));
            }
            else{
                if(s.charAt(i) == stack.peek()){
                    stack.pop();
                }
                else{
                    stack.push(s.charAt(i));
                }
            }
        }
        while(!stack.isEmpty()){
            str += stack.pop();
        }
        String s1 = "";
        for(int i = str.length()-1; i >=0; i-- ){
            s1+= str.charAt(i);
        }
        return s1;
    }
}