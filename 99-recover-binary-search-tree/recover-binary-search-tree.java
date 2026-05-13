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
    TreeNode prev = null;
    TreeNode first = null;
    TreeNode second = null;
    public void recoverTree(TreeNode root) {
            inOrder(root);
            // swap the values of 2 nodes
            if(first != null && second != null){
                int temp = first.val;
                first.val = second.val;
                second.val = temp;
            }
    }
    private void inOrder(TreeNode node){
        if(node == null) return;
        // travers left
        inOrder(node.left);
        // detect violation
        if(prev != null && prev.val > node.val){
            // First violation
            if(first == null){
                first = prev;
            }
            //update second every time violation occurs
            second = node;  
        }
        prev = node;
        //traverse right
        inOrder(node.right);
    }
}


/*
✅ Input Tree
root = [1,3,null,null,2]

Tree Structure
     1
    /
   3
    \
     2

🎯 Goal
Recover BST so that:
Inorder = sorted

🔄 Inorder Traversal Order
Traversal goes:
LEFT → ROOT → RIGHT

👉 Actual traversal:
3 → 2 → 1

👉 Expected:
1 → 2 → 3

🧠 Variables Tracking
prev   → previous node
first  → first incorrect node
second → second incorrect node

Start:
prev = null
first = null
second = null

🟢 Step 1: Go Left → Visit node 3
Current = 3
prev = null

✅ No comparison yet
Update:
prev = 3

🟢 Step 2: Visit node 2
Current = 2
prev = 3

❌ Check violation:
3 > 2   ❌

👉 First violation found!
Update:
first  = prev = 3
second = current = 2

Update:
prev = 2

🟢 Step 3: Visit node 1
Current = 1
prev = 2

❌ Check violation:
2 > 1   ❌

👉 Second violation
Update:
second = current = 1   (overwrite)

Update:
prev = 1

📊 Final Identified Nodes
first  = 3
second = 1

🔁 Swap Them
swap(3, 1)

✅ Final Tree
     3
    /
   1
    \
     2

🔄 Verify (Inorder Again)
1 → 2 → 3 ✅ sorted

🎥 Visual Timeline Summary
Step 1: prev=null → 3 ✅
Step 2: 3 > 2 ❌ → first=3, second=2
Step 3: 2 > 1 ❌ → second=1

Final swap → (3 ↔ 1)
*/