/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode anode=headA;
        ListNode bnode=headB;
        while(anode!=bnode){
            if(anode==null){
                anode=headB;
            }
            else{
                anode=anode.next;
            }
            if(bnode==null){
               bnode=headA;
            }
            else{
                bnode=bnode.next;
            }
        }
        return anode;

        
    }
}