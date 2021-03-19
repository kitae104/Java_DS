package ds.tree.bst;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	public Node root;

	/**
	 * id와 name을 이용해서 루트노드 생성하는 생성자
	 * 
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
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	}

	/**
	 * 노드와 키가 주어진 경우는 노드부터 검색 시작
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public Value get(Node node, Key key) {

		if (node == null) {
			return null; // 해당 키를 발견하지 못함
		}

		int t = node.getKey().compareTo(key);

		if (t > 0) {
			return get(node.getLeft(), key); // 왼쪽 서브트리 탐색
		} else if (t < 0) {
			return get(node.getRight(), key); // 오른쪽 서브트리 탐색
		} else {
			return (Value) node.getValue(); // key를 가진 노드 발견
		}
	}

	/**
	 * 루트에 시작해서 노드 삽입
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) {
		root = put(root, key, value);
	}

	/**
	 * 지정된 노드로 부터 시작해서 노드 삽입
	 * 
	 * @param node
	 * @param key
	 * @param value
	 * @return
	 */
	public Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value);
		}
		int t = node.getKey().compareTo(key);
		if (t > 0) {
			node.setLeft(put(node.getLeft(), key, value));
		} else if (t < 0) {
			node.setRight(put(node.getRight(), key, value));
		} else {
			node.setValue(value);
		}

		return node;
	}

	/**
	 * 최솟값 찾기
	 * 
	 * @return
	 */
	public Key min() {
		if (root == null) {
			return null;
		}
		return (Key) min(root).getKey();
	}

	/**
	 * 최솟값 찾기
	 * 
	 * @param node
	 * @return
	 */
	private Node min(Node node) {
		if (node.getLeft() == null) {
			return node;
		}
		return min(node.getLeft());
	}

	/**
	 * 최솟값 삭제 연산
	 */
	public void deleteMin() {
		if (root == null) {
			System.out.println("Empty 트리");
		}
		root = deleteMin(root);
	}

	/**
	 * 최솟값 삭제 연산
	 * 
	 * @param node
	 * @return
	 */
	private Node deleteMin(Node node) {
		if (node.getLeft() == null) {
			return node.getRight();
		}
		node.setLeft(deleteMin(node.getLeft()));
		return node;
	}

	/**
	 * 노드 삭제하기
	 * 
	 * @param key
	 */
	public void delete(Key key) {
		root = delete(root, key);
	}

	/**
	 * 노드 삭제하기
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	private Node delete(Node node, Key key) {
		if (node == null) {
			return null;
		}

		int t = node.getKey().compareTo(key);

		if (t > 0) {
			node.setLeft(delete(node.getLeft(), key)); // if (k < 노드 n의 id) 왼쪽 자식으로 이동
		} else if (t < 0) {
			node.setRight(delete(node.getRight(), key)); // if (k > 노드 n의 id) 오른쪽 자식으로 이동
		} else { // 삭제할 노드 발견한 경우
			if (node.getRight() == null) {
				return node.getLeft(); // case 0, 1
			}
			if (node.getLeft() == null) {
				return node.getRight(); // case 1
			}

			Node target = node; // case 2

			node = min(target.getRight()); // 삭제할 노드 자리로 옮겨올 노드 찾아서 n이 가리키게 함
			node.setRight(deleteMin(target.getRight()));
			node.setLeft(target.getLeft());
		}
		return node;
	}

	/**
	 * 출력하기
	 * 
	 * @param root
	 */
	public void print(Node root) {
		System.out.printf("\ninorder:\n");
		inOrder(root);
		System.out.printf("\npreorder:\n");
		preOrder(root);
		System.out.printf("\nlevel order:\n");
		levelOrder(root);
	}

	public void inOrder(Node node) {
		if (node != null) {
			inOrder(node.getLeft());
			System.out.print(node.getKey() + " ");
			inOrder(node.getRight());
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 후위 순회 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : postOrder
	 * @param node
	 */
	public void postOrder(Node node) {
		if (node != null) {
			postOrder(node.getLeft());
			postOrder(node.getRight());
			System.out.print(node.getKey() + " ");
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 레벨 순회 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : levelOrder
	 * @param root
	 */
	public void levelOrder(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		Node t;
		q.add(root); // 루트 노드 큐에 삽입

		while (!q.isEmpty()) {
			t = q.remove(); // 큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.getKey() + " "); // 제거된 노드 출력(방문)
			if (t.getLeft() != null) {
				q.add(t.getLeft()); // 큐에 왼쪽 자식 삽입
			}
			if (t.getRight() != null) {
				q.add(t.getRight()); // 큐에 오른쪽 자식 삽입
			}
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 전위 순회
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : preOrder
	 * @param node
	 */
	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.getKey() + " "); // 노드 n 방문
			preOrder(node.getLeft()); // n의 왼쪽 서브 트리를 순회하기 위해
			preOrder(node.getRight()); // n의 오른쪽 서브 트리를 순회하기 위해
		}
	}

	/**
	 * 트리 높이 계산 
	 * @return
	 */
	public int height() {
		return height(root) + 1;
	}

	/**
	 * 특정 노드에서 트리 높이 계산 
	 * @param n
	 * @return
	 */
	private int height(Node n) {
		if (n == null) {
			return -1;
		}
		return 1 + Math.max(height(n.getLeft()), height(n.getRight()));
	}
}
