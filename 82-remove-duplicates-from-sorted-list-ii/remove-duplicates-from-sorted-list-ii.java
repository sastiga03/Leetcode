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
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(-1);
        dummy.next=head;
        ListNode prev=dummy;
        ListNode now=head;
        while(now!=null && now.next!=null){
            if(now.val==now.next.val){
                while(now.next!=null && now.val==now.next.val){
                    now=now.next;
                }
                prev.next=now.next;
            }
            else{
                prev=prev.next;
            }
            now=now.next;
        }
        return dummy.next;
    }
}