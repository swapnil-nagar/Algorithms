package Tree;

import Tree.Model.TreeExample;
import Tree.Model.TreeNode;

public class CheckIdenticalTree {
	public static void main (String  a[]) {
		TreeExample te = new TreeExample();
		TreeNode<Integer> root1 = te.getSampleTree1();
		TreeNode<Integer> root2 = te.getSampleTree2();
		
		boolean result = false;
		result  = checkIdenticalTree(root1, root2);
		System.out.println(result);
	}
	
	public static boolean checkIdenticalTree(TreeNode<Integer> root1, TreeNode<Integer> root2) {
		
		if(root1 == null && root2 == null) {
			return true;
		}
		
		if (root1 != null && root2 != null) {
			return root1.data == root2.data &&
					checkIdenticalTree(root1.left, root2.left) &&
					checkIdenticalTree(root1.right, root2.right);
		}
		
		return false;
	}

}
