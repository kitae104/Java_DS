package ds.tree.binary;

public class BinaryTree<Key> {

	private Node<Key> root;

	/**
	 * 트리 생성자
	 */
	public BinaryTree() {
		root = null;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 루트 노드 가져오기
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getRoot
	 * @return
	 */
	public Node<Key> getRoot() {
		return root;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 루트 노드 설정하기 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : setRoot
	 * @param root
	 */
	public void setRoot(Node<Key> root) {
		this.root = root;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 트리가 비었는지 확인하기 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : isEmpty
	 * @return
	 */
	public boolean isEmpty() {
		return root == null;
	}
	
	/**
	 *
	 * <pre>
	 * 1. 개요 : 전위 순회
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : preOrder
	 * @param node
	 */
	public void preOrder(Node<Key> node) {
		
	}
}
