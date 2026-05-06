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
    
// helper class to store row + value
    static class Pair {
        int row;
        int val;

        Pair(int row, int val) {
            this.row = row;
            this.val = val;
        }
    }
  // Hash map to store vertical number and list of pair
    Map<Integer, List<Pair>> hm = new HashMap<>();
    int leftmost = 0;
    int rightmost = 0;

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        preOrder(root, 0, 0);  // start DFS

        List<List<Integer>> ans = new ArrayList<>();

        // process columns from left to right
        for (int col = leftmost; col <= rightmost; col++) {
            List<Pair> list = hm.get(col);

            // sort by row first, then value
            Collections.sort(list, (a, b) -> {
                if (a.row != b.row)
                    return a.row - b.row;
                return a.val - b.val;
            });

            // extract only values
            List<Integer> colList = new ArrayList<>();
            for (Pair p : list) {
                colList.add(p.val);
            }

            ans.add(colList);
        }
        return ans;
    }

    // preorder traversal with row & column
    private void preOrder(TreeNode node, int row, int col) {
        // base case 
        if (node == null) return;

        hm.computeIfAbsent(col, k -> new ArrayList<>())
          .add(new Pair(row, node.val));

        leftmost = Math.min(leftmost, col);
        rightmost = Math.max(rightmost, col);

        preOrder(node.left, row + 1, col - 1);
        preOrder(node.right, row + 1, col + 1);
    }


}