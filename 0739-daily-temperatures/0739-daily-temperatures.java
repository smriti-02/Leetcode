class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int arr[] = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();
        int n = temperatures.length;
        arr[n-1] = 0;
        stack.push(n-1);
        for(int i = n-2 ; i>= 0 ; i--){
            while(!stack.isEmpty() && temperatures[stack.peek()]<=temperatures[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                arr[i] =0;
            }
            else{
                arr[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return arr;
    }
}