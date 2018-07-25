package LinkedList;

import java.util.LinkedList;

import LinkedList.Model.ListNode;
import LinkedList.Model.ListNodePrinter;

public class AddNumbersRepresentedInLinkedList {
	public static void main (String a[]) {	
		ListNode<Integer> node1 = new ListNode<Integer>(0);
		node1.data = 7;
		node1.next = new ListNode<Integer>(8, new ListNode<Integer>(5, null));
		ListNode<Integer> node2 = new ListNode<Integer>(0);
		node2.data = 6;
		node2.next = new ListNode<Integer>(3, new ListNode<Integer>(6, null));
		ListNodePrinter.PrintListNode(node1);
		ListNodePrinter.PrintListNode(node2);
		ListNode<Integer> result = addNumbers(node1, node2);
		ListNodePrinter.PrintListNode(result);
	}
	
	public static ListNode<Integer> addNumbers(ListNode<Integer> node1, ListNode<Integer> node2) {
		ListNode<Integer> result = new ListNode<Integer>(0);
		ListNode<Integer> ret = result;
		int carry = 0;
		
		while (node1 != null || node2 != null) {
			
			if (node1 != null) {
				carry += node1.data;
				node1 = node1.next;
			}
			
			if (node2 != null) {
				carry += node2.data;
				node2 = node2.next;
			}
			ret.next = new ListNode<Integer> (carry % 10);
			ret = ret.next;
			carry = carry / 10;
		}
		
		if (carry > 0) {
			ret.next = new ListNode<Integer>(1);
		}
		return result.next;
	}
}
