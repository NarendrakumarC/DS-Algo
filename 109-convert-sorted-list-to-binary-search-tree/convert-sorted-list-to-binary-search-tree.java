/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = convertLinkedListToArrayList(head);
        return solve(nums, 0, nums.size()-1);
    }
    private static TreeNode solve(List<Integer> arr, int lo, int hi){
        if(lo > hi) return null;
        int mid = lo + (hi - lo)/2;
        TreeNode root = new TreeNode(arr.get(mid));
        root.left = solve(arr, lo, mid-1);
        root.right = solve(arr, mid+1, hi);
        return root;
    }
    private static List<Integer> convertLinkedListToArrayList(ListNode head){
        ListNode temp = head;
      List<Integer> ans = new ArrayList<>();
        while(temp != null){
            ans.add(temp.val);
            temp = temp.next;
        }
        return ans;
    }
}