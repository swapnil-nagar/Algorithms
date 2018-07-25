package Tree;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import Tree.Model.BTreePrinter;
import Tree.Model.TreeExample;
import Tree.Model.TreeNode;

public class VerticalOrderTraversal {
	public static void main (String  a[]) {
		TreeExample te = new TreeExample();
		TreeNode<Integer> root1 = te.getSampleTree2();

        BTreePrinter.printNode(root1);
		HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
		verticalOrderTraversal(root1, hashMap, 0);
		System.out.println(hashMap);
	}
	
	public static void verticalOrderTraversal(TreeNode<Integer> root, HashMap<Integer, List<Integer>> hashMap, Integer height) {
		if (root != null) {
			List<Integer> tempHeightList = new ArrayList<Integer>();
			if (hashMap.containsKey(height)) {
				tempHeightList = hashMap.get(height);
				tempHeightList.add(root.data);
			} else {
				tempHeightList.add(root.data);
			}
			hashMap.put(height, tempHeightList);
			verticalOrderTraversal(root.left, hashMap, height+1);
			verticalOrderTraversal(root.right, hashMap, height-1);
		}
	}
}
