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

    public static ListNode reverse(ListNode head){
            ListNode temp = head;
            ListNode prev = null;
            while(temp!=null){
                ListNode front = temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;
            }
            return prev; 
    }

   public static ListNode getKthNode(ListNode temp, int k){
    while(temp != null && k > 1){
        temp = temp.next;
        k--;
    }
    return temp;
}
public ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || k == 1) {
        return head;
    }

    ListNode temp = head;
    ListNode prev = null;

    while (temp != null) {
        ListNode kthNode = getKthNode(temp, k);
        if (kthNode == null) {
            if (prev != null) {
                prev.next = temp;  // connect leftover nodes
            }
            break;
        }

        ListNode nextNode = kthNode.next;
        kthNode.next = null;

        // reverse current k-group
        reverse(temp);

        // if we are reversing the very first group
        if (temp == head) {
            head = kthNode;
        } else {
            prev.next = kthNode;   // prev is safe here
        }

        prev = temp;   // now prev becomes the tail of the reversed group
        temp = nextNode;
    }

    return head;
}

}