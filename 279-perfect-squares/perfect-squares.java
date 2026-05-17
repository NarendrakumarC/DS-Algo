class Solution {
    public int numSquares(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
       int res = countSQ(n, dp);
        return res;
    }
    public int countSQ(int n, int[] dp){
        if(n==0 || n==1){
            dp[n] = n;
            return n;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
    int min  = Integer.MAX_VALUE;
    for(int k=1; k*k<=n; k++){
        int res = countSQ(n-k*k, dp);
        min  = Math.min(min, res);
    }
    return dp[n] = min+1;

    }

}