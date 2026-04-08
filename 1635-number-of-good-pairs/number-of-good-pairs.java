class Solution {
    public int numIdenticalPairs(int[] nums) {
        int n = nums.length;
        int pair_count =0;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            if(hm.containsKey(nums[i])){
                pair_count+=hm.get(nums[i]);
            }
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }
        return pair_count;
    }
}