class Solution {
    public int[] sortedSquares(int[] nums) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        ArrayList<Integer> arr2 = new ArrayList<>();
        for(int i = 0 ; i<nums.length ; i++){
            int x = nums[i];
            if(x<0){
                arr1.add(x*x);
            }
            else{
                arr2.add(x*x);
            }
        }
        int x = arr1.size()-1;
        int y = 0;
        int z = 0;
        while(x>=0 && y<arr2.size()){
            if(arr1.get(x) < arr2.get(y)){
                nums[z] = arr1.get(x);
                x--;
                z++;
            }
            else{
                nums[z]= arr2.get(y);
                y++;
                z++;
            }
        }
        while(x>=0){
            nums[z]=arr1.get(x);
            x--;
            z++;
        }
        while(y<arr2.size()){
            nums[z]= arr2.get(y);
            y++;
            z++;
        }
        return nums;
    }
}