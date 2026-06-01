class Solution {
    public int minElement(int[] nums) {
        int n = nums.length;
        // Initialize with max value
     int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int csum =0;
            while(nums[i]>0){
                csum +=nums[i] %10;
                nums[i] = nums[i]/10;   
            }
            min = Math.min(min, csum);
        }
        
       
        return min;
    }
}