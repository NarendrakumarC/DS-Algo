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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
         if(root == null) return ans;
        que.add(root);
        while(que.size()>0){
            int sz = que.size();
             List<Integer> arr = new ArrayList<>();
            for(int i=0;i<sz;i++){
                // remove
                TreeNode rem = que.remove();
                //print or add to ans
                arr.add(rem.val);
                // add children
                if(rem.left != null) que.add(rem.left);
                if(rem.right != null) que.add(rem.right);
            }
            ans.add(arr);
        
        }
        return ans;
    }
}