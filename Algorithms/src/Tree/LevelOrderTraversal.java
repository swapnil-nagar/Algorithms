package Tree;

import java.util.LinkedList;
import java.util.Queue;

import Tree.Model.BTreePrinter;
import Tree.Model.TreeExample;
import Tree.Model.TreeNode;

public class LevelOrderTraversal {
	
	public static void main (String  a[]) {
		TreeExample te = new TreeExample();
		TreeNode<Integer> root1 = te.getSampleTree2();

        BTreePrinter.printNode(root1);
		printLevelOrderTraversal(root1);
	}
	

	public static void printLevelOrderTraversal(TreeNode<Integer> root) {
		Queue<TreeNode<Integer>> queue = new LinkedList<TreeNode<Integer>>();
		
		queue.add(root);
		
		while(!queue.isEmpty()) {
			TreeNode<Integer> currentNode = queue.poll();
			if(currentNode != null){
				System.out.print(currentNode.data + ", ");
			
				queue.add(currentNode.left);
				queue.add(currentNode.right);
			}
		}
	}
}
