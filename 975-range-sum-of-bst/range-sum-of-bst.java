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
    int sum=0;
    public int rangeSumBST(TreeNode root, int low, int high) {
         inOrder(root, low, high);
         return sum;
    }
    private void inOrder(TreeNode node, int lo, int hi){
        if(node == null) return ;
         // InOrder traverse, compare range and compute sum
         inOrder(node.left, lo, hi);
         if(node.val >= lo && node.val <= hi){
             sum += node.val;
         }
         inOrder(node.right, lo, hi);
    }
}