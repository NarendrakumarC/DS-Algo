class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length()==0){
            return "";
        }
        int n = s.length();
        int start =0;
        int maxlen=0;
        // for odd case
        for(int c=0;c<n;c++){
            int left =c;
            int right = c;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxlen){
                    start = left;
                    maxlen = right-left+1;
                }
                left--;
                right++;
            }
        }
        // for even case
         for(int c=0;c<n;c++){
            int left =c;
            int right = c+1;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                if(right-left+1 > maxlen){
                    start = left;
                    maxlen = right-left+1;
                }
                left--;
                right++;
            }
        }
    return s.substring(start, start+maxlen);
    }

}