class Solution {
    public int lengthOfLongestSubstring(String s) {
          int maxlen =0;
        int left =0, right =0;
        int n = s.length();
        HashSet<Character> hs = new HashSet<>();
        for( right=0;right<n;right++) {
        	 if(!hs.contains(s.charAt(right))){ 
        		 hs.add(s.charAt(right));
        		 maxlen =Math.max(maxlen, right - left + 1);
        	 }else { 
        		 while(hs.contains(s.charAt(right))){
                     hs.remove(s.charAt(left));
            		 left++;
                 }
                 hs.add(s.charAt(right));
        		
        	 }
        }
        return maxlen;
        
    }
}