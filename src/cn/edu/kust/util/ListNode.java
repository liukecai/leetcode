package cn.edu.kust.util;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) { val = x; }

    public static void printList(ListNode list) {
        ListNode next = list;
        while (next.next != null) {
            System.out.print(next.val);
            System.out.print("->");
            next = next.next;
        }
        System.out.print(next.val);
        System.out.println("->NULL");
    }
}
