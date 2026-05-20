class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        int dp[][] = new int[n][m];
        // Loop through each row and fill it with -1
      /*  for (int[] row : dp) {
            Arrays.fill(row, -1);
        } */
        Arrays.stream(dp).forEach(row -> Arrays.fill(row, -1));
        // n-1 and m-1 are last index
        return lcs(text1, text2, n-1, m-1, dp);
    }
    private int lcs(String s1, String s2, int i, int j, int [][]dp){
            // if both indexes are exhausted
            // base case
            if(i<0 || j<0) return 0;
            if(dp[i][j] != -1){
                return dp[i][j];
            }
            if(s1.charAt(i) == s2.charAt(j)){
                dp[i][j] = lcs(s1, s2, i-1, j-1, dp) +1;
            }else{
                dp[i][j] = Math.max(lcs(s1, s2, i, j-1, dp), lcs(s1, s2, i-1, j, dp));
            }
            return dp[i][j];
    }
}