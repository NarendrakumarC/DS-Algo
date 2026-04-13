class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = Integer.MAX_VALUE;
        int left = 0;
        int cursum =0;
        for(int right=0;right<nums.length;right++){
            cursum +=nums[right];
            while(cursum >=target){
                if(right-left+1 < minLen){
                    minLen = right-left+1;
                }
                cursum = cursum-nums[left];
                left++;
            }
        }
        return minLen !=Integer.MAX_VALUE ? minLen :0;
        
    }
}