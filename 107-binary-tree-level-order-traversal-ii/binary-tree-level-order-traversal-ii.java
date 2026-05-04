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
    List<List<Integer>> ans = new ArrayList<>();
   
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
            if(root == null) return ans;
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(q.size()>0){
                int s = q.size();
                 List<Integer> num = new ArrayList<>();
                for(int i=0;i<s;i++){
                    // remove
                    TreeNode rem = q.remove();
                    //print
                    num.add(rem.val);
                    // add children
                    if(rem.left != null) q.add(rem.left);
                    if(rem.right != null) q.add(rem.right);
                }
                ans.add(num);
            }
            Collections.reverse(ans);
        return ans;
    }
}