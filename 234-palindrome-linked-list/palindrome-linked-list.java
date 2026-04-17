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
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode middle = findMiddle(head);
        ListNode fast = head;
        ListNode slow = middle.next;
        middle.next = null; // cut the first and second halves
        slow = reverse(slow); // reverse 2nd half
        // compare two halves
        while(slow!=null && fast.val == slow.val){
            fast = fast.next;
            slow = slow.next;
        }   
        if(slow != null) return false;
        return true;
    }
    private static ListNode findMiddle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head){
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}