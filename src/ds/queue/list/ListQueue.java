package ds.queue.list;

import java.util.NoSuchElementException;

import ds.list.Node;

/**
 * 
 * <pre>
 * 리스트를 사용하여 작성된 큐 클래스
 * </pre>
 * 
 * @author : 김기태
 * @Date : 2021. 3. 13.
 * @Version :
 * @param <E>
 */
public class ListQueue<E> {
	private Node<E> front, rear;
	private int size; // 리스트 크기

	/**
	 * 생성자
	 */
	public ListQueue() {
		front = rear = null;
		size = 0;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 스택의 항목의 수를 리턴
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : size
	 * @return
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 스택이 empty이면 true 리턴
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : isEmpty
	 * @return
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * <pre>
	 * 1. 개요 : 새로운 항목 추가 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : add
	 * @param newItem
	 */
	public void add(E newItem) {
		Node<E> newNode = new Node<E>(newItem, null); // 새 노드 생성

		if (isEmpty()) {
			front = newNode;
		} else {
			rear.setNext(newNode);
		}

		rear = newNode;
		size++;
	}

	/**
	 * <pre>
	 * 1. 개요 : 큐에서 항목 제거 front에서 제거하고 빈 경우 rear를 null로 설정한다. 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : remove
	 * @return
	 */
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}
		E item = front.getItem();
		front = front.getNext();
		if (isEmpty()) {
			rear = null;
		}
		return item;
	}

	public void print() {
		if (isEmpty()) {
			System.out.print("큐가 empty임");
		} else {
			for (Node<E> p = front; p != null; p = p.getNext()) {
				System.out.print(p.getItem() + "\t ");
			}
		}
		System.out.println();
	}
}
