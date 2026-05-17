class Solution {
    
    public int fib(int n) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        return solve(n, dp);
    }

    private int solve(int n, int []dp){
        if(n==0 || n == 1){
            dp[n]=n;
            return n;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int a = solve(n-1, dp);
        int b = solve(n-2, dp);
        int res = a+b;
        return dp[n] = res;
    }
}