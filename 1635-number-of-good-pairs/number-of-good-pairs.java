class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int pair_count =0;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] == nums[j]){
                    pair_count++;
                }
            }
        }
        return pair_count;
    }
}