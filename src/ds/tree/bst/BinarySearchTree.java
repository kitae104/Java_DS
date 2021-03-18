package ds.tree.bst;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {
	
	public Node root;

	/**
	 * id와 name을 이용해서 루트노드 생성하는 생성자 
	 * @param id
	 * @param value
	 */
	public BinarySearchTree(Key key, Value value) {
		root = new Node(key, value);
	}
	
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	/**
	 * 키만 주어진 경우 루트부터 검색 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	/**
	 * 노드와 키가 주어진 경우는 노드부터 검색 시작 
	 * @param node
	 * @param key
	 * @return
	 */	
	public Value get(Node node, Key key) {
		
		if(node == null) {
			return null;		// 해당 키를 발견하지 못함 
		}
		
		int t = node.getKey().compareTo(key);
		
		if(t > 0) {
			return get(node.getLeft(), key); 	// 왼쪽 서브트리 탐색 
		} else if(t < 0) {
			return get(node.getRight(), key);	// 오른쪽 서브트리 탐색 
		} else {
			return (Value)node.getValue();		// key를 가진 노드 발견 
		}
	}
	
	
}
