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
    public ListNode sortList(ListNode head) {
        if(head == null){
            return null;
        }
        if(head !=null && head.next == null){
            return head;
        }
        ListNode mid = middleNode(head);
        ListNode head2= mid.next;
        mid.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(head2);
        ListNode ans = mergeTwoSortedLL(left, right);
        return ans;
    }

    private static ListNode middleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode mergeTwoSortedLL(ListNode head1, ListNode head2){
        ListNode dummyhead = new ListNode(-1);
        ListNode i = head1;
        ListNode j = head2;
        ListNode temp = dummyhead;
        while(i!=null && j!=null){
            if(i.val <= j.val){
                temp.next = i;
                i = i.next;
            }else{
                temp.next = j;
                j = j.next;
            }
            temp = temp.next;
        }
        if(i!= null) temp.next=i;
        if(j!=null) temp.next = j;
        return dummyhead.next;

    }

}