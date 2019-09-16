package cn.edu.kust.medium;

import cn.edu.kust.util.ListNode;

/**
 *
 * 2. Add Two Numbers
 * pass
 */
public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		int temp = 0;
		ListNode result = new ListNode(0);
		ListNode p = result;
		int i = 0;
		while(null != l1 && null != l2) {
			temp = l1.val + l2.val + carry;
			carry = 0;
			if (temp >= 10) {
				carry = 1;
				temp = temp % 10;
			}
			p.next = new ListNode(temp);
			p = p.next;
			l1 = l1.next;
			l2 = l2.next;
			System.out.println(i++);
		}
		
		if (l1 == null && l2 != null)
			while (l2 != null) {
				temp = l2.val + carry;
				carry = 0;
				if (temp >= 10) {
					carry = 1;
					temp = temp % 10;
				}
				p.next = new ListNode(temp);
				p = p.next;
				l2 = l2.next;
			}
		
		if (l2 == null && l1 != null) 
			while (l1 != null) {
				temp = l1.val + carry;
				carry = 0;
				if (temp >= 10) {
					carry = 1;
					temp = temp % 10;
				}
				p.next = new ListNode(temp);
				p = p.next;
				l1 = l1.next;
			}
		
		if (carry == 1) 
			p.next = new ListNode(carry);
		
		result = result.next;
		return result;
	}
	
	public ListNode addTwoNumbersOptimal(ListNode l1, ListNode l2) {
		if (l1 == null)
			return l2;
		if (l2 == null)
			return l1;
		
		ListNode result = new ListNode(0);
		ListNode p = result;
		int sum = 0;
		while(l1 != null || l2 != null) {
			sum /= 10;
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}
			p.next = new ListNode(sum % 10);
			p = p.next;
		}
		
		if (sum / 10 == 1)
			p.next = new ListNode(1);
		
		return result.next;
	}
	
	public static void main(String[] args) {
		ListNode t1 = new ListNode(1);
		t1.next = new ListNode(8);
		ListNode t2 = new ListNode(0);
		
		AddTwoNumbers add = new AddTwoNumbers();
		ListNode r = add.addTwoNumbersOptimal(t1, t2);
		System.out.println("Test...");
		while (r != null) {
			System.out.print(r.val + "->");
			r = r.next;
		}
	}
}