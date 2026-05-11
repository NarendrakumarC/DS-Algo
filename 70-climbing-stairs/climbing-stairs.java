class Solution {
    public int climbStairs(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp,-1);
        int res = ways(n,dp);
        return res;
    }
    private static int ways(int n, int []dp){
        //base case
        if(n<=2){
            dp[n]=n;
            return n;
        }
        // what if already solved then return from dp[]
        if(dp[n]!=-1){
            return dp[n];
        }
        int a = ways(n-1, dp);
        int b = ways(n-2, dp);
        return dp[n]=a+b;
    }
}