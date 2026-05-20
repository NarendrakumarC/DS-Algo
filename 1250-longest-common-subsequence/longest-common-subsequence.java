class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // DP:Tabulation
        int n = text1.length();
        int m = text2.length();
        int [][]dp = new int[n+1][m+1];
        // fill 0th row and 0th col with zero values
        // 1. Fill the entire 0th row with 0
        Arrays.fill(dp[0],0);
        // 2. Fill the 0th column of every row with 0
        for(int row=0;row<dp.length;row++){
            dp[row][0]=0;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] +1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
// because LCS lies in last indext n-1,m-1
        return dp[n][m];
    }
    
}