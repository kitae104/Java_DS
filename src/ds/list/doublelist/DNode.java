package ds.list.doublelist;

// 이중연결리스트의 노드
public class DNode<E> {
	private E item;
	private DNode<E> previous;
	private DNode<E> next;
	
	public DNode(E item, DNode<E> previous, DNode<E> next) {
		super();
		this.item = item;
		this.previous = previous;
		this.next = next;
	}
	
	public E getItem() {
		return item;
	}
	
	public void setItem(E item) {
		this.item = item;
	}
	
	public DNode<E> getPrevious() {
		return previous;
	}
	
	public void setPrevious(DNode<E> previous) {
		this.previous = previous;
	}
	
	public DNode<E> getNext() {
		return next;
	}
	
	public void setNext(DNode<E> next) {
		this.next = next;
	}
	
}
