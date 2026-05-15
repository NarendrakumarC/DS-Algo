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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        // if root.val == k
        if(root.val == key){
            // if root is leaf node
            if(root.left == null && root.right == null){
                return null;
            }
            // if node to be deleted has a single child
            if(root.left == null || root.right == null){ // either left or right is null
                if(root.left == null) return root.right;
                if(root.right == null) return root.left;
            }
            // find min value in right subtree
            TreeNode temp = root.right;
            // Navigate to left to find min with in right subtree
            while(temp.left != null){
                temp = temp.left;
            }
            // copy min data to curr node
            root.val= temp.val;
            // delete that min value from right subtree
            root.right = deleteNode(root.right, temp.val);
            // return update node after delete , and it is still BST
            return root;
        }else if(root.val > key){
            // Navigate to left subtree
            root.left = deleteNode(root.left, key);
        }else{
            // Navigate to right subtree
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}