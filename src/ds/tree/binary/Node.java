package ds.tree.binary;

public class Node<Key> {
	private Key item;
	private Node<Key> left;
	private Node<Key> right;
	
	/**
	 * 생성자 
	 * @param item
	 * @param left
	 * @param right
	 */
	public Node(Key item, Node<Key> left, Node<Key> right) {	
		super();
		this.item = item;
		this.left = left;
		this.right = right;
	}

	public Key getItem() {
		return item;
	}

	public void setItem(Key item) {
		this.item = item;
	}

	public Node<Key> getLeft() {
		return left;
	}

	public void setLeft(Node<Key> left) {
		this.left = left;
	}

	public Node<Key> getRight() {
		return right;
	}

	public void setRight(Node<Key> right) {
		this.right = right;
	}
	
}
