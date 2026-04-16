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
    public ListNode removeElements(ListNode head, int val) {
        ListNode nn = new ListNode(0,head);
        ListNode temp = nn;
            if(temp !=null && temp.val == val){
                temp = temp.next;
            }
            while (temp!=null){
                   while(temp.next!=null && temp.next.val == val){
                        temp.next = temp.next.next;
                   } 
                   temp = temp.next;
            }
            return nn.next;
    }
}