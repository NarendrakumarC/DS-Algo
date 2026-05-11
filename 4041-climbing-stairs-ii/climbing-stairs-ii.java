class Solution {
    public int climbStairs(int n, int[] costs) {
        int dp[] = new int[n+1];
        Arrays.fill(dp, -1);
        int res = minCost(0, n, dp, costs);
        return res;
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