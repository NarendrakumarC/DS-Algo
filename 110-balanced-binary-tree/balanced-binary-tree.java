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
    boolean isBalanced;
    public boolean isBalanced(TreeNode root) {
        isBalanced = true;
        helperHeight(root);
        return isBalanced;
    }
    private int helperHeight(TreeNode node){
        if(node == null) return 0;
        int lh = helperHeight(node.left);
        int rh = helperHeight(node.right);
        if(isBalanced == true && Math.abs(lh-rh)>1){
            isBalanced = false;
        }
        return Math.max(lh,rh)+1;
    }
}