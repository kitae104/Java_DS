package ds.tree.binary;

public class Node<Key extends Comparable<Key>> {
	private Key item;			// 아이템
	private Node<Key> left;		// 왼쪽 링크 
	private Node<Key> right;	// 오른쪽 링크 
	
	/**
	 * 생성자 - 각 인스턴스 변수 초기화 
	 * @param item 아이템
	 * @param left 왼쪽링크 
	 * @param right 오른쪽 링크 
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
