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
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
            inOrder(root);
            // swap the values of 2 nodes
            if(first != null && second != null){
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
    }
    private void inOrder(TreeNode node){
        if(node == null) return;
        // travers left
        inOrder(node.left);
        // detect violation
        if(prev != null && prev.val > node.val){
            // First violation
            if(first == null){
                first = prev;
            }
            //update second every time violation occurs
            second = node;  
        }
        prev = node;
        //traverse right
        inOrder(node.right);
    }
}