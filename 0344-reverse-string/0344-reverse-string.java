class Solution {
    public void reverseString(char[] s) {
        Stack <Character> stack = new Stack<>();
        int n = s.length;
        for(int i = 0; i <n ; i++){
            stack.push(s[i]);
        }
        for(int i = 0; i <n; i++){
            s[i] = stack.pop();
        }
    }
}