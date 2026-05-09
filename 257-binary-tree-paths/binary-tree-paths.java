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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<>();
        dfs(root, new ArrayList<>(), ans);
        return ans;
    }
    private void dfs(TreeNode node, List<String> currentPath, List<String> result){
        if(node == null) return ;
        // preOrder call
        currentPath.add(String.valueOf(node.val));

        //if leaf node join the path and add to result
        if(node.left == null && node.right == null){
            result.add(String.join("->",currentPath));
        }else{
               // recursive left and right (preOrder call)
               dfs(node.left, currentPath, result);
               dfs(node.right, currentPath, result); 
        }
        // BackTrack : remove the current node before returning
        currentPath.remove(currentPath.size()-1);
    }
}