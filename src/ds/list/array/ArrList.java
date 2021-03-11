package ds.list.array;

import java.util.NoSuchElementException;

import ds.list.doublelist.DNode;

// 리스트를 배열로 구현한 클래스 
public class ArrList<E> {
	private E a[];		// 리스트 항목을 저장할 배열 
	private int size;	// 리스트 항목 수 
	
	
	public ArrList() {
		super();
		a = (E[]) new Object[1];	// 최초로 1개의 원소를 가진 배열 생성 
		size = 0;					// 항목 수는 0으로 초기화 
	}	
	
	// 탐색 연산 - k 번재 항목을 리턴, 단순히 읽기만 
	public E peek(int k) {
		if(size == 0) {
			throw new NoSuchElementException();	// underflow 경우에 프로그램 정지 
		}
		return a[k];
	}
	
	// 맨 마지막 원소로 삽입 
	public void insertLast(E newItem) {
		if(size == a.length) {
			resize(2 * a.length);		// 배열 크기 2배로 
		}
		a[size++] = newItem;
	}
	
	// k번째 위치에 원소 삽입 
	public void insert(E newItem, int k) {
		if(size == a.length) {
			resize(2 * a.length);		// 배열 크기 2배로 
		}
		
		// 한 칸씩 뒤로 이동  
		for (int i = size-1; i >= k; i--) {
			a[i+1] = a[i];
		}
		
		a[k] = newItem;
		size++;		
	}

	// k번째 항목 삭제 
	public E delete(int k) {
		if(isEmpty()) {
			throw new NoSuchElementException();	
		}
		E item = a[k];
		for (int i = k; i < size; i++) {
			a[i] = a[i+1];				// 앞으로 하나씩 이동 
		}
		size--;
		
		if(size > 0 && size == a.length/4) {	// 배열 항목이 1/4가 되면 
			resize(a.length /2);
		}
		return item;
	}
	
	// 리스트가 empty이면 true 리턴
	private boolean isEmpty() {		
		return size == 0;
	}

	// 사이즈 변경하기 
	private void resize(int newSize) {
		Object[] t = new Object[newSize];
		for(int i = 0; i<size; i++) {
			t[i] = a[i];				// 이전 내용 복사 
		}
		a = (E[]) t;					// 배열 t를 배열 s로 
	}
	
	// 배열의 항목들을 출력
	public void print() { 
		if (isEmpty()) { 
			System.out.print("배열이 비어있음.");     
		} else {
			for(int i = 0; i < a.length; i++) {
				System.out.print(a[i]+"\t ");
			}
		}
		System.out.println();
	}
	
	
}
