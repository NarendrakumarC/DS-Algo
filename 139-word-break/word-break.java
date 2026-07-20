class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> hs = new HashSet<>(wordDict);
       Boolean []dp = new Boolean[s.length()];
               return solveWordBreak(0, s, hs, dp);
    }
    private boolean solveWordBreak(int start, String s, HashSet<String> set, Boolean []dp){
        //base case
        if(start==s.length()) return true;
        if(dp[start] != null){
            return dp[start];
        }
        boolean rres = false;
        for(int end= start+1; end<=s.length(); end++) {
            if(set.contains(s.substring(start, end)) && solveWordBreak(end,s,set,dp)){
                 return dp[start] = true;
            }
        }
        return dp[start] = false;
    }
}