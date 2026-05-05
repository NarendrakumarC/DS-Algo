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
        List<Integer> ans = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        TreeNode rvn = null;
        while(q.size()>0){
            int sz = q.size();
            for(int i=0;i<sz;i++){
                // remove
                TreeNode rem = q.remove();
                // print
                rvn = rem;
                // Add children
                if(rem.left != null) q.add(rem.left);
                if(rem.right != null) q.add(rem.right);
            }
            ans.add(rvn.val);
        }
            return ans;
    }
}