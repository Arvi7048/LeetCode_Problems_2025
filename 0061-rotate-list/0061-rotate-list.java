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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 1;
        ListNode temp = head;

        while(temp.next!= null){
            len++;
            temp = temp.next;
        }
        k = k%len;
        int r = len-k;
        temp.next = head;
        ListNode newHead = head;
        for(int i = 1; i<r; i++){
            newHead = newHead.next;
        }
        ListNode nwH = newHead.next;
        newHead.next= null;
        return nwH;

    }
}