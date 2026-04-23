/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        boolean isCycle = false;
        if(head == null) return null;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        if(slow == fast){
            isCycle = true;
            break;
        }
          }
        if(isCycle == false){
            return null;
        }
        ListNode i = head;
        ListNode j = slow;
        while(i !=  j){
            i = i.next;
            j = j.next;
        }
        return j;
    }
}