package cn.edu.kust.easy;

import cn.edu.kust.util.ListNode;

/**
 *
 * 206. Reverse Linked List
 * pass
 */
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode p, q, r;
        p = head;
        q = head.next;
        if (q != null) {
            r = q.next;
            p.next = null;
            while (r != null) {
                q.next = p;
                p = q;
                q = r;
                r = r.next;
            }
            q.next = p;
            p = q;
        }

        return p;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode next = list;
        int i = 2;
        while (i < 8) {
            next.next = new ListNode(i);
            next = next.next;
            i++;
        }

        ListNode.printList(list);

        ReverseLinkedList reverse = new ReverseLinkedList();
        ListNode reversed = reverse.reverseList(list);

        ListNode.printList(reversed);
    }
}
