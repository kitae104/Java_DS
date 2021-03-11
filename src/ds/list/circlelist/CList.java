package ds.list.circlelist;

import java.util.NoSuchElementException;

import ds.list.Node;

// 원형 연결 리스트 
public class CList<E> {
	private Node<E> last;	// 리스트의 마지막 노드(항목)을 가리킨다. 
	private int size;		// 리스트의 항목(노드) 수
	
	// 생성자 
	public CList() {
		super();
		last = null;
		size = 0;
	}
	
	public int size() { 
		return size; 
	}
	
	public boolean isEmpty() { 
		return size == 0; 
	}
	
	// 노드 삽입하기 
	// 리스트가 empty인 경우와 그렇지 않은 경우로 나누어 삽입
	public void insert(E newItem) {
		Node<E> newNode = new Node<E>(newItem, null);	// 새 노드 생성
		
		if(last == null) {	// 리스트가 empty 인 경우 
			newNode.setNext(newNode);
			last = newNode;
		} else {
			newNode.setNext(last.getNext());	// newNode의 다음 노드가 last가 가리키는 노드의 다음노드가 되도록
			last.setNext(newNode);				// last가 가리키는 노드의 다음 노드가 newNode가 되도록
		}
		size++;
	}
	
	// last가 가리키는 노드의 다음 노드를 제거
	public Node<E> delete(){
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<E> x = last.getNext();
		if(x == last) {						// 리스트에 1개의 노드만 있는 경우
			last = null;
		} else {
			last.setNext(x.getNext());		// last가 가리키는 노드의 다음 노드가 x의 다음 노드가 되도록
			x.setNext(null);				// x의 next를 null로 만든다.
		}
		size--;
		return x;
	}
	
	// 연결 리스트 노드들의 항목들을 차례로 출력
	public void print() {
		if(size > 0) {
			int i = 0; 
			for(Node<E> p = last.getNext(); i<size; p = p.getNext(), i++) {
				System.out.print(p.getItem() + "\t");
			}			
		} else {
			System.out.println("리스트가 비어있음.");
		}
	}
}
