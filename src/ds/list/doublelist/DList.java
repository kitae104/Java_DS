package ds.list.doublelist;

import java.util.NoSuchElementException;

// 이중연결리스트를 위한 클래스
public class DList<E> {
	protected DNode<E> head, tail;
	protected int size;

	public DList() {
		super();
		head = new DNode<E>(null, null, null);
		tail = new DNode<E>(null, head, null); // tail의 이전 노드를 head로 만든다
		head.setNext(tail); // head의 다음 노드를 tail로 만든다.
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

	// 인자로 주어지는 노드 p 다음에 새 노드를 삽입
	public void insertAfter(DNode<E> p, E newItem) {
		DNode<E> t = p.getNext();
		DNode<E> newNode = new DNode<E>(newItem, p, t);
		t.setPrevious(newNode);
		p.setNext(newNode);
		size++;
	}

	// 인자로 주어지는 노드 x를 삭제
	public void delete(DNode<E> x) {
		if (x == null) {
			throw new NoSuchElementException();
		}
		DNode<E> f = x.getPrevious();
		DNode<E> r = x.getNext();
		f.setNext(r);
		r.setPrevious(f);
		size--;
	}

	// 연결 리스트 노드들의 item들을 차례로 출력
	public void print() {
		if(size > 0) {
			for(DNode<E> p = head.getNext(); p != tail; p = p.getNext()) {
				System.out.print(p.getItem() + "\t");
			}
		} else {
			System.out.println("리스트 비었음");
		}
		System.out.println();
	}
}
