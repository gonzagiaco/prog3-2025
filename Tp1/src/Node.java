

public class Node<T> {

	private T info;
	private Node<T> next;
	private Node<T> previous;


	public Node() {
		this(null, null, null);
	}

	// constructor para lista simplemente enlazada
	public Node(T info, Node<T> next) {
		this(info, next, null);
	}

	// constructor para lista doblemente enlazada
	public Node(T info, Node<T> next, Node<T> previous) {
		this.info = info;
		this.next = next;
		this.previous = previous;
	}
	
	public Node<T> getNext() {
		return next;
	}
	public Node<T> getPrevious() {
		return this.previous;
	}
	public T getInfo() {

		return info;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}
	public void setPrevious(Node<T> previous) {
		this.previous = previous;
	}
	public void setInfo(T info) {
		this.info = info;
	}

}
