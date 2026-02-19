class Solution {
    public int[] twoSum(int[] nums, int target) {
         HashMap<Integer, Integer> hm = new HashMap<>();
	        int n = nums.length;  
	        for (int i = 0; i < n; i++) {
	        	hm.put(nums[i], i);
	        }
	        for(int i=0;i<nums.length-1;i++){
	        	int copair = target - nums[i];
	        	if(hm.containsKey(copair) && hm.get(copair) !=i) {
	        		return new int[] {i,hm.get(copair)};
	        	}
	        } 
	    return new int[]{};
    }
}