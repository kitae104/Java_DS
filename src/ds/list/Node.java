package ds.list;

// 단순 연결리스트의 노드 클래스 
public class Node<E> {
	private E item;
	private Node<E> next;
	
	/**
	 * 생성자
	 * @param newItem
	 * @param next
	 */
	public Node(E newItem, Node<E> next) {
		super();
		this.item = newItem;
		this.next = next;
	}

	/**
	 * 항목 가져오기 
	 * <pre>
	 * 1. 개요 :
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getItem
	 * @return
	 */
	public E getItem() {
		return item;
	}

	/**
	 * 항목 설정하기 
	 * <pre>
	 * 1. 개요 :
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : setItem
	 * @param newItem
	 */
	public void setItem(E newItem) {
		this.item = newItem;
	}

	/**
	 * 다음 노드로 이동 
	 * <pre>
	 * 1. 개요 :
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : getNext
	 * @return
	 */
	public Node<E> getNext() {
		return next;
	}

	/**
	 * 다음 노드 설정 
	 * <pre>
	 * 1. 개요 :
	 * 2. 처리내용 : 
	 * </pre>
	 * @Method Name : setNext
	 * @param next
	 */
	public void setNext(Node<E> next) {
		this.next = next;
	}
	
	
}
