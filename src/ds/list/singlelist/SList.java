package ds.list.singlelist;

import java.util.NoSuchElementException;

public class SList<E> {
	protected Node<E> head;		// 연결 리스트의 첫 노드 
	private int size;
	
	public SList() {
		super();
		head = null;
		size = 0;
	}

	public Node<E> getHead() {
		return head;
	}

	public void setHead(Node<E> head) {
		this.head = head;
	}
	
	public int size() { 
		return size; 
	}
	
	public boolean isEmpty() { 
		return size == 0; 
	}
	
	// 탐색 : 인자로 주어지는 target을 찾을 때까지 연결 리스트의 노드들을 첫 노드부터 차례로 탐색한다. 
	public int search(E target) {	// target을 탐색  
		Node<E> p = head;
		for (int i = 0; i < size; i++) {
			if(target == p.getItem()) {
				return i;			// 위치 반환 
			}
			p = p.getNext();		// 다음 노드로 이동 
		}
		return -1;
	}
	
	// 연결리스트 맨 앞에 새 노드 삽입
	public void insertFront(E newItem) {
		head = new Node<E>(newItem, head);
		size++;
	}
	
	// p가 가리키는 노드의 다음에 새 노드를 삽입 
	public void insertAfter(E newItem, Node<E> p) {
		p.setNext(new Node<E>(newItem, p.getNext()));
		size++;
	}
	
	// 리스트가 empty가 아닐 때, 리스트의 첫 노드를 삭제
	public void deleteFront() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		head = head.getNext();
		size--;
	}
	
	// p가 가리키는 노드의 다음 노드를 삭제
	public void deleteAfter(Node<E> p) {
		if(p==null) {
			throw new NoSuchElementException();
		}
		Node<E> t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}

	// 연결 리스트 노드들의 항목들을 차례로 출력
	public void print() {
		for(Node<E> p = head; p != null; p = p.getNext()) {
			System.out.print(p.getItem() + "\t");
		}
		//System.out.println();
	}

	// 두개의 정렬된 리스트 합병
	public Node<E> mergeTwoLists(Node<E> p1, Node<E> p2) {
		// TODO Auto-generated method stub
		return null;
	}

	// 역방향 리스트
	public Node<E> reverseList(Node<E> currentNode) {
		// TODO Auto-generated method stub
		return null;
	}

	// 중간 노드 찾기
	public Node<E> findMiddleNode(Node<E> head) {
		// TODO Auto-generated method stub
		return null;
	}

	// k와 같거나 작은 리스트와 k보다 큰 리스트로 분리
	public void splitList(Node<E> p, int k, SList<E> l1, SList<E> l2) {
		// TODO Auto-generated method stub
		
	}

	// 공통된 숫자의 합
	public String commonSum(SList<Integer> w) {
		// TODO Auto-generated method stub
		return null;
	}

	// 싸이클 검사
	public String cycleDetector() {
		// TODO Auto-generated method stub
		return null;
	}

	// 환형리스트 만들기
	public void createCycle() {
		// TODO Auto-generated method stub
		
	}
}
