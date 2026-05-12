class Solution {
    public int numTrees(int n) {
        // initialize dp with n+1
        // number of left nodes = currentRoot -1
        // number of right nodes = all nodes - currentRoot
        int []dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] =1;
        }
        for(int node =2; node <= n; node++){
            int total =0;
            for(int root =1; root <= node; root++){
                total +=dp[root-1]*dp[node-root];
            }
            dp[node] = total;
         }
         return dp[n];
    }
}