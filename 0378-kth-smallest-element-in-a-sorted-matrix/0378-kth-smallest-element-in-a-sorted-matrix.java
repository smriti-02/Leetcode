class Solution {
    public int con(int[][] matrix , int mid ){
        int n = matrix.length;
        int row = n-1;
        int col = 0;
        int count = 0;
        int m = matrix[0].length;
        while(col<m && row >= 0){
            if(matrix[row][col] <= mid ){
                count = count + row + 1;
                col ++;
            }
            else{
                row--;
            }
        }
        return count;
    }
    public int kthSmallest(int[][] matrix, int k) {
        int i = matrix[0][0];
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;
        int j = matrix[n][m];
        int res = 0;
        while(i <= j){
            int mid = i +(j-i)/2;
            if(con(matrix , mid) >= k){
                res = mid;
                j = mid -1;
            }
            else{
                i = mid + 1;
            }
        }
        return res;
    }
}