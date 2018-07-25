package Tree.Model;

public class TreeNode<T> {
	public TreeNode(T data) {
		this.data = data;
	}
	public T data;
	public TreeNode<T> left;
	public TreeNode<T> right;
}