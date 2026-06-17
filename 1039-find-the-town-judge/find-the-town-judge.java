class Solution {
    public int findJudge(int n, int[][] trust) {
       int []indegree = new int[n+1];
       int []outdegree = new int[n+1];
       for(int []t : trust){
            indegree[t[1]]++; // a trust someone
            outdegree[t[0]]++; // b is trusted
       }
       for(int i=1;i<=n;i++){
            if(indegree[i]==n-1 && outdegree[i]==0){
                return i;
            }
       }
       return -1;
    }

}