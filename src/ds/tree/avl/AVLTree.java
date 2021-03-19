package ds.tree.avl;

public class AVLTree<Key extends Comparable<Key>, Value> {

	private Node root;
	
	/**
	 * 삽입 연산 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node node, Key key, Value value) {
		if(node == null) {
			return new Node(key, value, 1);
		}
		
		int t = node.getKey().compareTo(key);
		
		if(t<0) {
			node.setLeft(put(node.getLeft(), key, value));
		} else if (t>0) {
			node.setRight(put(node.getRight(), key, value));
		} else {
			node.setValue(value);		// key 가 이미 트리에 있으므로 value만 갱신
			return node;
		}
		node.setHeight( tallerHeight(node.height(node.getLeft()), node.height(node.getRight()) + 1));
		return balance(node);
	}

	private Node balance(Node node) {
		// TODO Auto-generated method stub
		return node;
	}

	private int tallerHeight(int left, int right) {
		if(left > right) {
			return left;
		} else {
			return right;
		}
	}
	
	
}
