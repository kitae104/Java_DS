package ds.list.doublelist;

// 이중연결리스트를 위한 클래스
public class DList<E> {
	protected DNode<E> head, tail;
	protected int size;
	
	public DList() {
		super();
		head = new DNode<E>(null, null, null);
		tail = new DNode<E>(null, head, null);	// tail의 이전 노드를 head로 만든다
		head.setNext(tail);						// head의 다음 노드를 tail로 만든다.
		size = 0;
	}
	
	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	// 새 노드를 인자로 주어지는 노드 p 앞에 삽입한다. 
	public void insertBefore(DNode<E> p, E newItem) {
		DNode<E> t = p.getPrevious();
		DNode<E> newNode = new DNode<E>(newItem, t, p);
		p.setPrevious(newNode);
		t.setNext(newNode);
		size++;
	}
}
