package ds.tree.avl;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree<Key extends Comparable<Key>, Value> {

	private Node root;

	/**
	 * <pre>
	 * 1. 개요 : 루트 노드 가져오기
	 * 2. 처리내용 : 
	 * </pre>
	 * @return
	 */
	public Node getRoot() {
		return root;
	}

	/**
	 * 삽입 연산
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value, 1);
		}

		int t = node.getKey().compareTo(key);

		if (t < 0) {
			node.setLeft(put(node.getLeft(), key, value));
		} else if (t > 0) {
			node.setRight(put(node.getRight(), key, value));
		} else {
			node.setValue(value); // key 가 이미 트리에 있으므로 value만 갱신
			return node;
		}
		node.setHeight(tallerHeight(node.height(node.getLeft()), node.height(node.getRight()) + 1));
		return balance(node); // node위 균현 점검 및 불균형 바로 잡기
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 불균형 처리 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : balance
	 * @param node
	 * @return
	 */
	private Node balance(Node node) {
		if (bf(node) > 1) { // 노드 n의 왼쪽 서브트리가 높아서 불균형 발생
			if (bf(node.getLeft()) < 0) { // 노드 n의 왼쪽자식노드의 오른쪽 서브 트리가 높은 경우
				node.setLeft(rotateLeft(node.getLeft())); // LR-회전
			}
			node = rotateRight(node); // LL-회전
		} else if (bf(node) < -1) { // 노드 n의 오른쪽 서브트리가 높아서 불균형 발생
			if (bf(node.getRight()) > 0) { // 노드 n의 오른쪽자식노드의 왼쪽 서브트리가 높은 경우
				node.setRight(rotateRight(node.getRight())); // RL-회전
			}
			node = rotateLeft(node); // RR-회전
		}
		return node;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 오른쪽으로 회전 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : rotateRight
	 * @param node
	 * @return
	 */
	private Node rotateRight(Node node) {
		Node x = node.getLeft();
		node.setLeft(x.getRight());
		x.setRight(node);
		node.setHeight(tallerHeight(node.height(node.getLeft()), node.height(node.getRight())) + 1); // 높이 갱신
		x.setHeight(tallerHeight(node.height(x.getLeft()), node.height(x.getRight())) + 1); // 높이 갱신
		return x; // 회전 후 x가 n의 이전 자리로 이동되었으므로
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 왼쪽으로 회전 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : rotateLeft
	 * @param left
	 * @return
	 */
	private Node rotateLeft(Node node) {
		Node x = node.getLeft();
		node.setLeft(x.getRight());
		x.setRight(node);
		node.setHeight(tallerHeight(node.height(node.getLeft()), node.height(node.getRight())) + 1); // 높이 갱신
		x.setHeight(tallerHeight(x.height(x.getLeft()), x.height(x.getRight())) + 1); // 높이 갱신
		return x; // 회전 후 x가 n의 이전 자리로 이동되었으므로
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 트리 높이 차리를 반환 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : bf
	 * @param node
	 * @return
	 */
	private int bf(Node node) {
		return node.height(node.getLeft()) - node.height(node.getRight()); // bf = 왼쪽 서브트리 높이 - 오른쪽 서브트리 높이
	}

	/**
	 * <pre>
	 * 1. 개요 : 둘중에 큰 값을 반환 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : tallerHeight
	 * @param left
	 * @param right
	 * @return
	 */
	private int tallerHeight(int left, int right) {
		if (left > right) {
			return left;
		} else {
			return right;
		}
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 삭제 연산
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : delete
	 * @param key
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 삭제 연산 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : delete
	 * @param root2
	 * @param key
	 * @return
	 */
	private Node delete(Node node, Key key) {
		int t = node.getKey().compareTo(key);
		if (t < 0) {
			node.setLeft(delete(node.getLeft(), key));
		} else if (t > 0) {
			node.setRight(delete(node.getRight(), key));
		} else {
			if (node.getLeft() == null) {
				return node.getRight();
			} else if (node.getRight() == null) {
				return node.getLeft();
			} else {
				Node y = node;
				node = min(y.getRight());
				node.setRight(deleteMin(y.getRight()));
				node.setLeft(y.getLeft());
			}
		}

		node.setHeight(tallerHeight(node.height(node.getLeft()), node.height(node.getRight())) + 1);
		return balance(node);
	}

	/**
	 * <pre>
	 * 1. 개요 : 최솟값 찾기
	 * 2. 처리내용 : 
	 * </pre>
	 * @return
	 */
	public Key min() {
		return (Key) min(root).getKey();
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 최소값 찾기 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 * @return
	 */
	private Node min(Node node) {
		if(node.getLeft() == null) {
			return node;
		}
		return min(node.getLeft());
	}

	/**
	 * <pre>
	 * 1. 개요 : 최솟값 삭제 
	 * 2. 처리내용 : 
	 * </pre>
	 */
	public void deleteMin() {
		root = deleteMin(root);
	}
	
	/**
	 * 
	 * <pre>
	 * 1. 개요 : 최솟값 삭제
	 * 2. 처리내용 : 
	 * </pre>
	 * @param right
	 * @return
	 */
	private Node deleteMin(Node node) {
		if(node.getLeft() == null) {
			return node.getRight();
		}
		node.setLeft(deleteMin(node.getLeft()));
		node.setHeight(tallerHeight(node.height(node.getLeft()), node.height(node.getRight())) + 1);
				
		return balance(node);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 트리 출력 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param root
	 */
	public void print(Node root) {
		System.out.println("In-Order:");
		inOrder(root);
		System.out.println("\nPre-Order:");
		preOrder(root);
		System.out.println("\nPost-Order:");
		postOrder(root);
		System.out.println("\nLevel-Order:");
		levelOrder(root);
	}

	/**
	 * <pre>
	 * 1. 개요 : 후위 순회 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param root2
	 */
	private void postOrder(Node node) {
		if(node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getKey() + " ");
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 중위 순회
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 */
	private void inOrder(Node node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getKey() + " ");
			inOrder(node.getRight());
		}
	}

	private void preOrder(Node node) {
		if(node != null) {
			System.out.print(node.getKey() + " ");
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}		
	}

	/**
	 * <pre>
	 * 1. 개요 : 레벨 순회 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 */
	private void levelOrder(Node node) {
		Queue<Node> queue = new LinkedList<Node>();
		Node t; 								// 제거할 노드 
		queue.add(node);						// 루트노드 큐에 삽입 
		while(!queue.isEmpty()) {
			t = queue.remove();					//큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey() + " ");	// 제거된 노드 출력(방문)
			
			if(t.getLeft() != null) {			// 제거된 왼쪽 자식이 null이 아니면
				queue.add(t.getLeft());			// 큐에 왼쪽 자식 삽입
			}
			if(t.getRight() != null) {			// 제거된 오른쪽 자식이 null이 아니면
				queue.add(t.getRight());		// 큐에  오른쪽 자식 삽입
			}
		}
	}
}
