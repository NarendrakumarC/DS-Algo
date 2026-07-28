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
    static int sum =0;
    public int sumEvenGrandparent(TreeNode root) {
        sum =0;
        dfs(root, null, null);
        return sum;
    }
    void dfs(TreeNode current, TreeNode parent, TreeNode grandparent){
        if(current == null) return ;
        if(grandparent != null && grandparent.val % 2 == 0){
            sum +=current.val;
        }
        dfs(current.left, current, parent);
        dfs(current.right, current, parent);
    }
}