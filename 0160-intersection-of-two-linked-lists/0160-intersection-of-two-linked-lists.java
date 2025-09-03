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
    public ListNode getIntersectionNode(ListNode h1, ListNode h2) {
        if(h1 == null || h2 == null) return null;

        ListNode t1 = h1;
        ListNode t2 = h2;
        while(t1!= t2){

            t1 = t1.next;
            t2 = t2.next;

            if(t1 == t2) return t1;
            if(t1 == null) t1 = h2;
            if(t2 == null) t2 = h1;

        }
        return t1;
    }
}