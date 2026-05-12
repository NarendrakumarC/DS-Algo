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
    long prev;
    boolean isBST;
    public boolean isValidBST(TreeNode root) {
        prev = Long.MIN_VALUE;
        isBST = Boolean.TRUE;
        inOrder(root);
        return isBST;
    }
    private void inOrder(TreeNode node){
        if(node == null) return;
        inOrder(node.left);
        // In Area check if prev < node.val update prev then continue else false  
        if(prev >= node.val){
            isBST = false;
            return;
        }
        prev = node.val;
        if(isBST == true){
            inOrder(node.right);
        }
    }
}