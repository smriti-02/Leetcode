class Solution {
    public String reverseVowels(String s) {
        if(s.isEmpty()){
            return s;
        }
        int j = s.length()-1;
        int n = s.length();
        char[] arr =s.toCharArray();
        int i = 0;
        while(i<j){
            if(!(s.charAt(j) =='a' || s.charAt(j) =='e' || s.charAt(j) =='i' || s.charAt(j) =='o' || s.charAt(j) =='u' || s.charAt(j) =='A' || s.charAt(j) =='E' || s.charAt(j) =='I' || s.charAt(j) =='O' || s.charAt(j) =='U')){
                j--;
            }
            else if(!(s.charAt(i) =='a' || s.charAt(i) =='e' || s.charAt(i) =='i' || s.charAt(i) =='o' || s.charAt(i) =='u' || s.charAt(i) =='A' || s.charAt(i) =='E' || s.charAt(i) =='I' || s.charAt(i) =='O' || s.charAt(i) =='U')){
                i++;
            }
            else{ 
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j--;
                i++;
            }
        }
        String t ="";
        for(int k = 0; k<n ; k++){
            t += arr[k];
        }
        return t;
    }
}