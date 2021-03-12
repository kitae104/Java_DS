package ds.stack;

import java.util.EmptyStackException;

public class ArrayStack<E> {
	private E s[]; // 스택을 위한 배열
	private int top; // 스택의 top 항목의 배열 원소 인덱스

	/**
	 * 생성자
	 */
	public ArrayStack() {
		super();
		this.s = (E[]) new Object[1]; // 초기에 크기가 1인 배열 생성
		this.top = -1;
	}

	/**
	 * 스택의 항목 수
	 * 
	 * @return
	 */
	public int size() {
		return top + 1;
	}

	/**
	 * 스택이 비었는지 확인
	 * 
	 * @return
	 */
	public boolean isEmpty() {
		return (top == -1);
	}

	/**
	 * 스택 top 항목의 내용만을 리턴
	 * 
	 * @return
	 */
	public E peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return s[top];
	}

	/**
	 * 항목 넣기
	 * 
	 * @param newItem
	 */
	public void push(E newItem) {
		if (size() == s.length) {
			resize(2 * s.length); // 스택의 크기를 2배로
		}
		s[++top] = newItem;
	}

	/**
	 * 사이즈 변경하기
	 * @param newSize
	 */
	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for (int i = 0; i < size(); i++) {
			t[i] = s[i]; // 이전 내용 복사
		}
		s = (E[]) t; // 배열 t를 배열 s로
	}
	
	/**
	 * 스택의 항목들을 아래에서 위로 출력
	 */
	public void print() {
		if(isEmpty()) {
			System.out.println("스택이 비었습니다.");			
		} else {
			for (int i = 0; i < size(); i++) {
				System.out.print(s[i] + "\t");
			}
			System.out.println();
		}
	}

	public E pop() {
		if(isEmpty())
			throw new EmptyStackException();
		E item = s[top];
		s[top--] = null;		// 초기화 
		if(size() > 0 && size() == s.length/4) {
			resize(s.length/2);	// 스택 크기를 1/2 크기로 축소 
		}
		return item;
	}
}
