/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/*
 ✅ Example
Input: 5 → 2 → 13 → 3 → 8


🌳 Recursion Call Tree
Each call waits for the result of the next node:
helper(5)
  ↓
  helper(2)
    ↓
    helper(13)
      ↓
      helper(3)
        ↓
        helper(8)
          ↓
          helper(null)


🔙 Backtracking Phase (Important Part)
Now recursion returns from bottom to top:
Step 1:
helper(8)
→ returns 8


Step 2:
helper(3)
→ next = 8
→ 8 > 3 → REMOVE 3
→ return 8


Step 3:
helper(13)
→ next = 8
→ 8 < 13 → KEEP 13
→ return 13 → 8


Step 4:
helper(2)
→ next = 13
→ 13 > 2 → REMOVE 2
→ return 13 → 8


Step 5:
helper(5)
→ next = 13
→ 13 > 5 → REMOVE 5
→ return 13 → 8


✅ Final Output
13 → 8


🎯 Visual Summary (Tree + Decisions)
                5
                |
                v
                2
                |
                v
               13
                |
                v
                3
                |
                v
                8

Backtracking decisions:

8  → keep
↑
3  → removed (8 > 3)
↑
13 → keep (13 > 8)
↑
2  → removed (13 > 2)
↑
5  → removed (13 > 5)

*/
class Solution {
    public ListNode removeNodes(ListNode head) {
        if(head == null || head.next == null){
            return head; // base case;
        }
        // process rest of list
        head.next = removeNodes(head.next);

        // if next node has greather value, remove current
        //Input: 5 → 2 → 13 → 3 → 8
        if(head.next != null && head.next.val > head.val){
            return head.next; // skip curr node and return max 
        }
        return head;
    }
}