package LinkedList.Model;

public class ListNodePrinter {
	public static <T> void PrintListNode (ListNode<T> listNode) {
		ListNode<T> node = listNode;
		while (node != null) {
			System.out.print(node.data + ", ");
			node = node.next;
		}
		System.out.println();
	}
}
