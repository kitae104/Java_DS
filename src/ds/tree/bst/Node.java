package ds.tree.bst;

/**
 * 이진 탐색 트리를 위한 노드 
 * @author 김기태
 *
 * @param <Key> : 비교 연산을 위해 Comparable 사용 
 * @param <Value>
 */
public class Node<Key extends Comparable<Key>, Value> {
	
	private Key key;			// 키
	private Value value;		// 키와 관련된 정보 
	private Node left, right;
	
	public Node(Key key, Value value) {
		super();
		this.key = key;
		this.value = value;
		left = right = null;
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

}
