package ds.tree.avl;

public class Node<Key extends Comparable<Key>, Value> {
	private Key key;       	
	private Value value;   	
	private int height;   	
	private Node left, right;  

	public Node(Key key, Value value, int height) {
		super();
		this.key = key;
		this.value = value;
		this.height = height;
		this.left = this.right = null;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

	public int height(Node node) {
		if(node == null) {
			return 0;
		}
		return node.height;
	}
}
