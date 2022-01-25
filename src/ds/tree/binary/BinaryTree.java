package ds.tree.binary;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 바이너리 트리 클래스 
 * @author 김기태
 *
 * @param <Key>
 */
public class BinaryTree<Key extends Comparable<Key>> {

	private Node<Key> root;		// 루트 노드 

	/**
	 * 트리 생성자
	 */
	public BinaryTree() {
		root = null;			// 초기에 null로 설정 
	}

	/**
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
	 * <pre>
	 * 1. 개요 : 전위 순회
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : preOrder
	 * @param node
	 */
	public void preOrder(Node<Key> node) {
		if(node != null) {
			System.out.print(node.getItem() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 중위 순회
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : inOrder
	 * @param node
	 */
	public void inOrder(Node<Key> node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getItem() + " ");
			inOrder(node.getRight());
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 후위 순회 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : postOrder
	 * @param node
	 */
	public void postOrder(Node<Key> node) {
		if(node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getItem() + " ");
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 레벨 순회 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : levelOrder
	 * @param root
	 */
	public void levelOrder(Node<Key> root) {
		Queue<Node<Key>> q = new LinkedList<Node<Key>>();
		Node<Key> t;
		q.add(root);	// 루트 노드 큐에 삽입
		
		while(!q.isEmpty()) {
			t = q.remove();		//큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getItem() + " ");	// 제거된 노드 출력(방문)
			if(t.getLeft() != null) {
				q.add(t.getLeft());					// 큐에 왼쪽 자식 삽입
			}
			if(t.getRight() != null) {
				q.add(t.getRight());				// 큐에 오른쪽 자식 삽입 
			}
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : node를 루트로하는 (서브)트리에 있는 노드 수
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : size
	 * @param node
	 * @return
	 */
	public int size(Node<Key> node) {
		if(node == null) {
			return 0;
		} else {
			return (1 + (size(node.getLeft())) + size(node.getRight()));
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : node를 루트로하는 (서브)트리의 높이
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : height
	 * @param node
	 * @return
	 */
	public int height(Node<Key> node) {
		if(node == null) {
			return 0;
		} else {
			return (1 + Math.max(height(node.getLeft()), height(node.getRight())));
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 두 노드가 같은지 판단 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : isEquals
	 * @param n
	 * @param m
	 * @return
	 */
	public static boolean isEqual(Node n, Node m) {
		if(n == null || m == null) {	// 둘중에 하나라도 null이면
			return n == m;				// 둘다 null이면 true, 아니면 false
		}
		
		if(n.getItem().compareTo(m.getItem()) != 0) {
			return false;
		}
		// item이 같으면 왼쪽/오른쪽 자식으로 재귀 호출
		return (isEqual(n.getLeft(), m.getLeft()) && isEqual(n.getRight(), m.getRight()));
	}
	
	/**
	 * <pre>
	 * 1. 개요 : node를 루트로하여 (서브)트리 복사 
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : copy
	 * @param node
	 * @return
	 */
	public Node<Key> copy(Node<Key> node){
		Node<Key> left, right;
		if(node == null) {
			return null;
		} else {
			left = copy(node.getLeft());
			right = copy(node.getRight());
			return new Node<Key>(node.getItem(), left, right);
		}
		
	}
}
