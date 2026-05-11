class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int dp[] = new int[n];
        Arrays.fill(dp, -1);
        return Math.min(minCost(dp, cost, n-1), minCost(dp, cost, n-2));
    }
    private static int minCost(int []dp, int cost[], int i){
        if(i<0) return 0;
        if(i==0 || i==1){
            return dp[i]=cost[i];
        }
        if(dp[i] != -1){
            return dp[i];
        }
        int a = minCost(dp, cost, i-1);
        int b = minCost(dp, cost, i-2);
       
        return  dp[i] = Math.min(a,b)+cost[i];
    }
}