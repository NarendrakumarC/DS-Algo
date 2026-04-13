class Solution {
    public int minSubArrayLen(int target, int[] nums) {
       int minLen = Integer.MAX_VALUE;
        int start =0;
        int windowsum =0;
        for(int end=0;end<nums.length;end++){
            windowsum +=nums[end];
            while(windowsum>=target){
                minLen = Math.min(minLen, end-start+1);
                windowsum -=nums[start];
                start++;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
        
    }
}