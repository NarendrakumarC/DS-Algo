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
     List<Integer> ans;
    public List<Integer> inorderTraversal(TreeNode root) {
         ans = new ArrayList<>();
        morrisTraversal(root);
        return ans;
    }
    private void morrisTraversal(TreeNode node) {
		TreeNode curr = node;
		while(curr!=null) {
			TreeNode lnode = curr.left;
			if(lnode == null) {
				ans.add(curr.val);
				curr = curr.right;
			}else {
				// find rightMost node
				TreeNode rmnode = getRightMostNode(lnode,curr);
				if(rmnode.right == null) {
					// case of making thread and moving toward left
                    rmnode.right = curr;
                    curr = curr.left;
				}else {
                    // in this case, rmnode.right is curr itself
                    // print -> break the thread -> move toward right 
                    ans.add(curr.val);
                    rmnode.right = null;
                    curr = curr.right;
                }
			}
		}
	}

   private  TreeNode getRightMostNode(TreeNode lnode, TreeNode curr) {
        TreeNode temp = lnode;
        while(temp.right != null && temp.right != curr) {
            temp = temp.right;
        }
        return temp;
    }
}