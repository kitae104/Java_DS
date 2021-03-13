package ds.stack.list;

import java.util.EmptyStackException;

import ds.list.Node;

public class ListStack<E> {

	private Node<E> top; // 스택 top 항목을 가진 Node를 가리키기 위해
	private int size; // 스택의 항목 수

	/**
	 * 생성자
	 */
	public ListStack() {
		top = null;
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
	 * 
	 * <pre>
	 * 1. 개요 : 스택 꼭대기에 있는 항목을 반환한다. 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : peek
	 * @return
	 */
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.getItem();
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 푸시 연산 : 스택 꼭대기에 항목 입력 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : push
	 * @param newItem
	 */
	public void push(E newItem) {
		Node<E> newNode = new Node<E>(newItem, top);
		top = newNode;
		size++;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 팝 연산 : 스택 꼭대기에 있는 항목 제거 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : pop
	 * @return top 항목 반환
	 */
	public E pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		E topItem = top.getItem();
		top = top.getNext();
		size--;
		return topItem;
	}

	/**
	 * 
	 * <pre>
	 * 1. 개요 : 스택 내용 출력하기 
	 * 2. 처리내용 :
	 * </pre>
	 * 
	 * @Method Name : print
	 */
	public void print() { // 스택의 항목들을 top부터 차례로 출력
		if (isEmpty()) {
			System.out.print("스택이 비어있음.");
		} else {
			for (Node<E> p = top; p != null; p = p.getNext()) {
				System.out.print(p.getItem() + "\t ");
			}
		}
		System.out.println();
	}
}
