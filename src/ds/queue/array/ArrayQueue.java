package ds.queue.array;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {

	private E[] q;
	private int front, rear, size;

	/**
	 * 생성자
	 */
	public ArrayQueue() {
		q = (E[]) new Object[2]; // 초기에 크기가 2인 배열 생성
		front = rear = size = 0;
	}

	/**
	 * 큐에 있는 항목의 수를 리턴
	 * @return
	 */
	public int size() {
		return size;
	}  

	/**
	 * 큐가 empty이면 true를 리턴
	 * @return
	 */
	public boolean isEmpty() {
		return (size == 0);
	} 
	
	/**
	 * 큐 삽입 연산
	 * @param newItem
	 */
	public void add(E newItem) {
		if((rear + 1) % q.length == front) {	// 큐가 풀인 상태
			resize(2*q.length);		// 큐의 크기를 2개로 확장 
		}
		rear = (rear + 1) % q.length;
		q[rear] = newItem;
		size++;				
	}
	
	/**
	 * 큐 삭제 연산
	 * @return
	 */
	public E remove() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		front = (front+1) % q.length;
		E item = q[front];
		q[front] = null;	// 기존 내용 지우기 
		size--;
		
		if(size > 0 && size == q.length/4) {	// 큐의 항목수가  배열 크기의 1/4가 되면
			resize(q.length/2);					// 큐를 1/2 크기로 축소
		}
		return item;
	}
	
	/**
	 * 큐의 배열 크기 조절
	 * @param newSize
	 */
	private void resize(int newSize) { 
		Object[] t = new Object[newSize];
		for (int i = 1, j = front + 1; i < size + 1; i++, j++) {
			t[i] = q[j%q.length];
		}
		front = 0;
		rear = size;
		q = (E[])t;			// 배열 t를 배열 q로 
	}
	
	/**
	 * 큐의 항목들을 출력
	 */
	public void print() { 
		if(isEmpty()) {
			System.out.println("큐가 비어있음");
		} else {
			for (int i = 0; i < q.length; i++) {
				System.out.print(q[i] + "\t");
			}
			System.out.println();
		}
		
	}
}
