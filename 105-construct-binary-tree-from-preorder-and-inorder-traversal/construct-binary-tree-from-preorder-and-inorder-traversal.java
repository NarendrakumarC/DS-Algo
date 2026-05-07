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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = inorder.length;
        TreeNode root = solve(inorder, 0,n-1,preorder,0,n-1);
        return root;
    }
    private static TreeNode solve(int []in, int inst, int inend,int []pre, int pst, int pend){
        // base case 
        if(inst > inend || pst > pend){
            return null;
        }
        // create current node from first node of pre order
        int data = pre[pst];
        TreeNode n = new TreeNode(data);
        // find the index of that data member in inorder
        int indx = findIndex(in, data);
        // find diff count 
        int count = indx - inst;
        // make a call for creation of left and right subtree
        n.left = solve(in, inst, indx-1, pre, pst+1, pst+count);
        n.right = solve(in, indx+1, inend, pre, pst+count+1, pend);
        // return created node
        return n;
    }
    private static int findIndex(int []in, int data){
        for(int i=0;i<in.length;i++) {
            if(in[i] == data) return i;
        }
        // dummy return 
        return -1;
    }
}