package cn.edu.kust.easy;

import cn.edu.kust.util.ListNode;

/**
 *
 * 92. Reverse Linked List II
 * pass
 *
 * 206. Reverse Linked List
 * pass
 */
public class ReverseLinkedList {
    // 206
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

    // 92
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null)
            return head;

        ListNode reverseList = new ListNode(-1);
        reverseList.next = head;

        ListNode pre = reverseList;
        for(int i = 1; i < m; i++)
            pre = pre.next;

        ListNode curr = pre.next;
        for(int i = m; i < n; i++) {
            ListNode next = curr.next;
            curr.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return reverseList.next;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        ListNode next = list;
        int i = 2;
        while (i < 20) {
            next.next = new ListNode(i);
            next = next.next;
            i++;
        }

        System.out.println("====================Reverse all list====================");

        ListNode.printList(list);

        ReverseLinkedList reverse = new ReverseLinkedList();
        ListNode reversed = reverse.reverseList(list);

        ListNode.printList(reversed);

        System.out.println("====================Reverse partial list====================");

        ListNode.printList(reversed);
        ListNode reversedPartial = reverse.reverseBetween(reversed,8,15);
        ListNode.printList(reversedPartial);
    }
}
