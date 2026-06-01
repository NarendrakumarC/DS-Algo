class Solution {
    public int minimumCost(int[] cost) {
        //Sort the ascending order first
        Arrays.sort(cost);
        int total =0;
        int n = cost.length;
        //Traverse from largest to smallest
        int count =0;
        for(int i=n-1;i>=0;i--){
            count++;
            //Every 3rd candy is free skip it
            if(count % 3 != 0){
                total +=cost[i];
            }
        }
        return total;
    }
}