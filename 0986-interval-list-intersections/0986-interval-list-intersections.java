class Solution {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int n = firstList.length;
        int m = secondList.length;
        int i =0;
        int j = 0;
        ArrayList<int[]> arr = new ArrayList<>();
        while(i<n && j<m){
           int start1 = firstList[i][0];
           int end1 = firstList[i][1];
           int start2 = secondList[j][0];
           int end2 = secondList[j][1];
            if(start1<= end2 && start2 <= end1){
                int start = Math.max(start1 , start2);
                int end = Math.min(end1 , end2);
                arr.add(new int[]{start, end});
            }
            if(end1>end2){
                    j++;
            }
            else{
                i++;
            }
        }
        return arr.toArray(new int[0][]);
    }
}