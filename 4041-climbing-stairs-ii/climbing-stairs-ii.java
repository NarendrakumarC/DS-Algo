class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n+1];
        dp[0] =0;
        for(int j=1;j<=n; j++){
            dp[j] = Integer.MAX_VALUE;
            if(j-1 >= 0) 
                dp[j] = Math.min(dp[j], dp[j-1]+costs[j-1]+1);
            if(j-2 >= 0)
                dp[j] = Math.min(dp[j], dp[j-2]+costs[j-1]+4);
            if(j-3>=0)
                dp[j] = Math.min(dp[j], dp[j-3]+costs[j-1]+9);    
        }
        return dp[n];
    }
    private static int minCost(int i, int n, int []dp, int []cost){
        //base case
        if(i==n){ // At Top staircase
            dp[i] = 0;
            return 0;
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;

        // taking one steps
        if(i<n){
            one = cost[i] + minCost(i+1, n, dp, cost) +1;
        }
        //taking two steps
        if(i+1 < n){
            two = cost[i+1] + minCost(i+2, n, dp, cost) + 4;
        }
        // taking three steps
        if(i+2 < n){
            three = cost[i+2] + minCost(i+3, n, dp, cost) + 9;
        }
        dp[i] = Math.min(one, Math.min(two, three));

        return dp[i];
    }
}