class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0); // Dummy node
        ListNode curr = head;

        while (curr != null) {
            ListNode prev = dummy;
            while (prev.next != null && prev.next.val < curr.val) {
                prev = prev.next;
            }
            ListNode nextTemp = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = nextTemp;
        }

        return dummy.next;
    }
}
