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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        TreeNode root = solve(inorder, 0, n-1, postorder, 0, n-1);
        return root;
    }

private static TreeNode solve(int []in, int inst, int inend, int []post, int pst, int pend) {
        if(inst > inend || pst > pend){
            return null;
        }
        // create a current node from last of post order
        int data = post[pend];
        TreeNode n = new TreeNode(data);
        // find the index of that data in inorder
        int indx = findIndx(in, data);
        int count = indx-inst;

        // make a call for creation of left and right subtree
        n.left = solve(in, inst, indx, post, pst, pst+count-1);
        n.right = solve(in, indx+1, inend, post, pst+count, pend-1);

        return n;
    }

    private static int findIndx(int []arr, int data){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==data){
                return i;
            }
        }
        // not necessary
        return -1;
    }
}