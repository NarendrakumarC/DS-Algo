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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
       // Convert Linkedlist to arraylist and perform swap using third variable, 
       // then create new node with values from arraylist and return it
        List<Integer> nums = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            nums.add(temp.val);
            temp = temp.next;
        }
        for(int i=0; i<nums.size(); i+=2){
            int val1= nums.get(i);
            int val2=0;
            if((i+1) < nums.size()){
                val2 = nums.get(i+1);
                int k = val1;
                nums.set(i, val2);
                nums.set(i+1, k);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for(int i=0;i<nums.size();i++){
            ListNode nn = new ListNode(nums.get(i));
            //create link to newly create node
            curr.next = nn;
            //move the pointer to newly create node
            //move to attached node
            curr = nn;
        }
        return dummy.next;
    }
}