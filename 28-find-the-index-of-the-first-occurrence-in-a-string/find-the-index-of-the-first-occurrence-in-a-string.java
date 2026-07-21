class Solution {
    public int strStr(String haystack, String needle) {
       int n = haystack.length();
       int m = needle.length();
       for(int i=0; i<=n-m; i++){
        String first =  haystack.substring(i, i+m);
            if(needle.equals(first)){
                return i;
            }
       }
       return -1;
    }
}