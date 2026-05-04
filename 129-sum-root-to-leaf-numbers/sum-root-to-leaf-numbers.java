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
    int sum =0;
    public int sumNumbers(TreeNode root) {
        dfs(root,0);
        return sum;
    }
    private void dfs(TreeNode node, int path){
        if(node == null) return;
        // append each digit at msb 
        path = path * 10 + node.val;
        // check if current node is leaf node ,then calculate sum
        if(node.left == null && node.right == null){
            sum +=path;
        }
        dfs(node.left, path);
        dfs(node.right, path);
    }
}