class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int n = nums.length;
        int count=0;
        for(int i=0;i<n-1;i++){
            if(nums[i] != nums[i+1]){
                nums[count] = nums[i];
                count++;
            }
        }
        
    // Add the last element
        nums[count] = nums[nums.length - 1];
        count++;

        return count;
    }
}