package io.ajarara.reorder;
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
    public void reorderList(ListNode head) {
        // find midpoint, reverse tail
        // interleave between head and 1+ midpoint
        ListNode midPoint = findMidpoint(head);

        // now reverse
        ListNode curr = reverse(midPoint);

        ListNode first = head;

        while (curr != null) {
            ListNode nextHead = head.next;
            ListNode nextCurr = curr.next;
            head.next = curr;
            curr.next = nextHead;
            
            head = nextHead;
            curr = nextCurr;
        }
    }

    // find midpoint, detach it
    private ListNode findMidpoint(ListNode head) {
        int count = 0;
        ListNode curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        // reset curr to head for midpoint
        curr = head;
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        return curr;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    private String debug(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        while (listNode != null) {
            sb.append(listNode.val + ",");
            listNode = listNode.next;
        }
        return sb.toString();
    }
}
