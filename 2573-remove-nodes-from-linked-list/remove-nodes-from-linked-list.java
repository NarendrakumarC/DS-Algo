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
       //1. Reverse the list
       head = reverse(head);
       //2. Traverse and remove smaller nodes
       ListNode curr = head;
       int max = curr.val;

       while(curr != null && curr.next != null){
            // 5->3->13
            // curr = 13 , curr.next = 3 , traverse right to left , if 3 < 13 then remove 3 node
            if(curr.next.val < max){
                // Just move the pointers to next to next node
                curr.next = curr.next.next ;  // curr.next = 5 is assigned
            }else{
                // suppose if 14 < 13 - false means move curr to next node ie 14, exclude 13
                curr = curr.next;
                // update max value from updated curr node
                max= curr.val;
            }
       }
       // 3. reverse back
       return reverse(head);
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        while(head != null){
            // 1 -> 2 -> 3  prev -> head -> next
            ListNode next = head.next;
            //since prev is null , need to point to next for reverse right to left
            head.next  = prev;
            //Already prev = null is assigned to next node, now prev is unassigned provide link from 
            // from head to prev
            prev = head;
            //now head is un assigned , create link from next node to head node 
            head = next;
        }
        // return prev because head is travers from left to right but prev hold traverse from right to left, just exchange the pointers
        return prev;
    }
}