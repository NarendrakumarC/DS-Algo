class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
    // Step 1: Calculate total sum
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }    
    // Step 2: Iterate and compute differences
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            answer[i] = Math.abs(leftSum - rightSum);
            // Update leftSum for next index
            leftSum += nums[i];
        }

        return answer;
    }
}