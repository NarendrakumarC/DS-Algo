class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        int i=0; int j =0;
        int l1 = nums1.length;
        int l2 = nums2.length;
        // Invalid
        if (nums1[l1 - 1] < nums2[0] || nums2[l2 - 1] < nums1[0]) {
            return -1;
        }
        // use this approach only if array is sorted 
        //two pointers, i and j, at the start of both arrays
        while(i<l1 && j<l2){
            if(nums1[i] == nums2[j]){
                return nums1[i];
            }else{
                if(nums1[i] < nums2[j]){
                    i++;
                }else if(nums1[i] > nums2[j]){
                    j++;
                }
            }
        }
        return -1;
    }
}