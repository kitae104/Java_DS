package ds.tree.llrb;

import java.util.LinkedList;
import java.util.Queue;

public class RedBlackTree<Key extends Comparable<Key>, Value> {

	private static final boolean RED = true;
	private static final boolean BLACK = false;
	private Node root;

	/**
	 * <pre>
	 * ds.tree.llrb
	 * 노드 클래스
	 * </pre>
	 */
	private class Node {
		Key key;
		Value value;
		Node left, right;
		boolean color; // 부모노드 link의 색

		public Node(Key key, Value value, boolean color) {
			super();
			this.key = key;
			this.value = value;
			this.left = this.right = null;
			this.color = color;
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 비었는지 확인하기 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @return
	 */
	private boolean isEmpty() {
		return root == null;
	}

	/**
	 * <pre>
	 * 1. 개요 : 해당 노드가 레드인지 확인 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @return
	 */
	private boolean isRed(Node node) {
		if (node == null) {
			return false; // null의 색은 블랙
		}
		return (node.color == RED);
	}

	/**
	 * <pre>
	 * 1. 개요 : 탐색 (키 값 찾기) 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param key
	 * @return
	 */
	public Value get(Key key) {
		return get(root, key);
	} // 탐색 연산, 5-4-2절

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 탐색 (키 값 찾기)
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @param key
	 * @return
	 */
	public Value get(Node node, Key key) {
		if (node == null) {
			return null; // 탐색 실패
		}
		int t = node.key.compareTo(key);
		if (t > 0) {
			return get(node.left, key); // if (k < 노드 n의 id) 왼쪽 서브트리 탐색
		} else if (t < 0) {
			return get(node.right, key); // if (k > 노드 n의 id) 오른쪽서브트리 탐색
		} else {
			return (Value) node.value; // 탐색 성공
		}
	}

	/**
	 * <pre>
	 * 1. 개요 : 노드를 왼쪽으로 회전 - 노드의 오른쪽 레드 링크를 왼쪽으로 옮기는 연산 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @return
	 */
	private Node rotateLeft(Node node) {
		Node x = node.right;
		node.right = x.left;
		x.left = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}

	/**
	 * <pre>
	 * 1. 개요 : 노드를 오른쪽으로 회전 - 노드의 왼쪽 레드 링크를 오른쪽으로 옮기는 연산 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @return
	 */
	private Node rotateRight(Node node) {
		Node x = node.left;
		node.left = x.right;
		x.right = node;
		x.color = node.color;
		node.color = RED;
		return x;
	}

	/**
	 * <pre>
	 * 1. 개요 : 노드의 두 링크의 색이 같을 때, 둘다 다른 색으로 바꾸는 연산  
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 */
	private void flipColors(Node node) {
		node.color = !node.color;
		node.left.color = !node.left.color;
		node.right.color = !node.right.color;
	}

	/**
	 * <pre>
	 * 1. 개요 : 삽입 연산 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param key
	 * @param value
	 */
	public void put(Key key, Value value) { // 삽입 연산, 5-4-4절
		root = put(root, key, value);
		root.color = BLACK;
	}

	private Node put(Node node, Key key, Value value) {
		if (node == null) {
			return new Node(key, value, RED); // 새로운 레드 노드 생성
		}

		int t = key.compareTo(node.key);

		if (t < 0) {
			node.left = put(node.left, key, value);
		} else if (t > 0) {
			node.right = put(node.right, key, value);
		} else {
			node.value = value; // key가 트리에 있는 경우 value을 갱신
		}

		// 새 노드를 삽입한 후 발생할 수 있는 연속 레드 링크 문제를 해결하기 위한 동작
		if (!isRed(node.left) && isRed(node.right)) { // 외쪽 자식이 블랙이고 오른쪽 자식이 레드인 경우
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) { // 왼쪽 자식이 레드이고 자손이 레드인 경우
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) { // 왼쪽 자식이 레드이고 오른쪽 자식이 레드인 경우
			flipColors(node);
		}
		return node;
	}

	/**
	 * <pre>
	 * 1. 개요 : 레드 링크를 왼쪽 아래로 내려 보내기 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @return
	 */
	private Node moveRedLeft(Node node) {
		flipColors(node); // case 1 과 case 2
		if (isRed(node.right.left)) { // case 2
			node.right = rotateRight(node.right);
			node = rotateLeft(node);
			flipColors(node);
		}
		return node;
	}

	/**
	 * <pre>
	 * 1. 개요 : 레드 링크를 오른쪽 아래로 내려 보내기 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param n
	 * @return
	 */
	private Node moveRedRight(Node n){
		flipColors(n);             // case 1 과 case 2
		if (isRed(n.left.left)) {  // case 2
			n = rotateRight(n);
			flipColors(n);
		}
		return n;
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 최솟값 삭제 
	 * 2. 처리내용 :
	 * </pre>
	 */
	public void deleteMin() {
		root = deleteMin(root);
		root.color = BLACK;
	}

	/**
	 * <pre>
	 * 1. 개요 : 최솟값을 갖는 노드를 삭제
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @return
	 */
	private Node deleteMin(Node node) {
		if (node.left == null) { // 이 경우 노드가 최소값인 경우가 되고 null 반환
			return null;
		}
		if (!isRed(node.left) && !isRed(node.left.left)) {
			node = moveRedLeft(node);
		}
		node.left = deleteMin(node.left);
		return fixUp(node);
	}

	/**
	 * <pre>
	 * 1. 개요 : 규칙에 어긋난 부분을 수정
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @return
	 */
	private Node fixUp(Node node) {
		if (isRed(node.right)) {
			node = rotateLeft(node);
		}
		if (isRed(node.left) && isRed(node.left.left)) {
			node = rotateRight(node);
		}
		if (isRed(node.left) && isRed(node.right)) {
			flipColors(node);
		}
		return node;
	}

	/**
	 * <pre>
	 * 1. 개요 : 최솟값 찾기
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @return
	 */
	public Key min() {
		if (isEmpty()) {
			return null;
		}
		return (Key) min(root).key;
	}

	/**
	 * <pre>
	 * 1. 개요 : 최솟값 찾기
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @param node
	 * @return
	 */
	private Node min(Node node) {
		if (node.left == null) {
			return node;
		}
		return min(node.left);
	}

	/**
	 * <pre>
	 * 1. 개요 : 삭제 연산
	 * 2. 처리내용 : 
	 * </pre>
	 * @param key
	 */
	public void delete(Key key) { 
		root = delete(root, key);
		root.color = BLACK;
	}

	/**
	 * <pre>
	 * 1. 개요 : 삭제 연산
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 * @param key
	 * @return
	 */
	private Node delete(Node node, Key key) { 					// 노드n으로부터 키값 k를 가진 노드 삭제
		if (key.compareTo(node.key) < 0) { 						// k가 노드n의 id보다 작으면
			if (!isRed(node.left) && !isRed(node.left.left)) {
				node = moveRedLeft(node); 						// 왼쪽으로 레드 link 내려 보내기
			}
			node.left = delete(node.left, key); 				// k를 찾기 위해 완쪽 서브트리로 내려감
		} else { 												// k가 노드n의 id와 같거나 크면
			if (isRed(node.left)) {								// n의 왼쪽 자식이 레드이면
				node = rotateRight(node); 						// 오른쪽으로 레드 link 내려 보내기
			}
			if (key.compareTo(node.key) == 0 && (node.right == null)) { // n이 리프 노드일때
				return null; 									// 리프 노드 n 삭제
			}
			if (!isRed(node.right) && !isRed(node.right.left)){	// 오른쪽으로 레드 link 내려 보내기
				node = moveRedRight(node);
			}
			if (key.compareTo(node.key) == 0) { 				// 노드 n의 중위후속자 노드 정보를 복사하고 삭제함
				Node successor = min(node.right); 				// successor가 노드 node의 중위후속자 노드
				node.value = get(node.right, successor.key); 	// 노드n에 successor노드 value 복사
				node.key = successor.key; 						// 노드n에 successor노드 key 복사
				node.right = deleteMin(node.right); 			// successor노드 삭제
			} else
				node.right = delete(node.right, key); 			// k를 찾기 위해 오른쪽 서브트리로 내려감
		}
		return fixUp(node); 	// 직전 호출 노드로 리턴하며, 위배된 트리 조건 바로잡기
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 트리 출력 
	 * 2. 처리내용 : 
	 * </pre>
	 */
	public void print()  {  
		System.out.printf("\ninorder:\n");
		inorder(root);
		System.out.printf("\npreorder:\n");
		preorder(root);
		System.out.printf("\nlevel order:\n");
		levelorder(root);
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 중위 순회 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 */
	public void inorder(Node node){       		
		if (node != null) {
			inorder(node.left);   				// n의 왼쪽 서브 트리를 순회하기 위해
			System.out.print(node.key + " ");  	// 노드 n 방문
			inorder(node.right);  				// n의 오른쪽 서브 트리를 순회하기 위해
		}
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 레벨 순회
	 * 2. 처리내용 : 
	 * </pre>
	 * @param root
	 */
	public void levelorder(Node root) { 		
		Queue<Node> q = new LinkedList<Node>(); // 큐 자료구조 이용
		Node t;
		q.add(root);  							// 루트 노드 큐에 삽입
		while (!q.isEmpty()) { 
			t = q.remove();   					//큐에서 가장 앞에 있는 노드 제거
			System.out.print(t.key + " "); 		// 제거된 노드 출력(방문)
			if (t.left != null)      			// 제거된 왼쪽 자식이 null이 아니면
				q.add(t.left);       			// 큐에 왼쪽 자식 삽입
			if (t.right != null)     			// 제거된 오른쪽 자식이 null이 아니면
				q.add(t.right);      			// 큐에  오른쪽 자식 삽입
		} 
	}
	
	/**
	 * <pre>
	 * 1. 개요 : 전위 순회 
	 * 2. 처리내용 : 
	 * </pre>
	 * @param node
	 */
	public void preorder(Node node) {     		
		if (node != null) {
			System.out.print(node.key + " ");  	// 노드 n 방문
			preorder(node.left);  				// n의 왼쪽    서브 트리를 순회하기 위해
			preorder(node.right); 				// n의 오른쪽 서브 트리를 순회하기 위해
		}
	}	
}
