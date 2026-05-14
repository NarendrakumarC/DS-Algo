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
    TreeNode prev = null;
    int minDiff = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        return minDiff;
    }
    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        // Prev Node should not null and take absolute diff b/w prev and curr node value
        if(prev != null){
            minDiff = Math.min(minDiff, node.val - prev.val);
        }
        // assign curr node to prev to compare and iterate next
        prev = node;
        inOrder(node.right);
    }

}