package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import Tree.Model.BTreePrinter;
import Tree.Model.TreeExample;
import Tree.Model.TreeNode;

public class TopViewTree {
	public static void main (String  a[]) {
		TreeExample te = new TreeExample();
		TreeNode<Integer> root1 = te.getSampleTree2();

        BTreePrinter.printNode(root1);
		HashMap<Integer, List<Integer>> hashMap = new HashMap<Integer, List<Integer>>();
		topViewTree(root1, hashMap, 0);
		System.out.println(hashMap);
	}
	
	public static void topViewTree(TreeNode<Integer> root, HashMap<Integer, List<Integer>> hashMap, Integer height) {
		if (root != null) {
			if (!hashMap.containsKey(height)) {
				List<Integer> tempHeightList = new ArrayList<Integer>();
				tempHeightList.add(root.data);
				hashMap.put(height, tempHeightList);
			}
			topViewTree(root.left, hashMap, height+1);
			topViewTree(root.right, hashMap, height-1);
		}
	}
}
