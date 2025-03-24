import java.util.Iterator;

public class MySimpleLinkedList<T extends Comparable<T>> implements Iterable<T> {
	
	private Node<T> first;
	private Node<T> last;
	private int size;
	private boolean doubly;

	public Node<T> getFirst() {
		return first;
	}

	public void setFirst(Node<T> first) {
		this.first = first;
	}

	public MySimpleLinkedList() {
		this.first = null;
		this.last = null;
		this.size = 0;
    }

	public void insertFront(T info) {
		Node<T> newNode;

		if(doubly) {
			newNode = new Node<>(info, this.first, null);
		} else {
			newNode = new Node<>(info, this.first);
		}

		if (this.first != null && doubly) {
			this.first.setPrevious(newNode);
		}

		// Se asigna el nuevo nodo como primer elemento
		this.first = newNode;

		// siempre el primer nodo va a ser el ultimo. ya que cuando haga insertFront el primero se va a correr a la derecha
		if (this.last == null) {
			this.last = newNode;
		}

		size++;
	}
	
	public T extractFront() {		
		T tmp = this.first.getInfo();
		this.first = this.first.getNext();
		size--;
		return tmp;
	}

	public boolean isEmpty() {
		return this.first==null;
	}


	public T get(int index) {
		T info = null;
		int pos = 0;

		if(this.first == null){
			return null;
		}

		Node<T> firstNode = this.first; // Se mantiene la referencia original para no perder el primer nodo
		while (pos < index && index <= size) {
			firstNode = firstNode.getNext();
			pos++;
		}


		if(pos == index){
			info = this.first.getInfo();
		}

		return info;
	}

	public void setDoubly(boolean doubly) {
		this.doubly = doubly;
	}

	public int indexOf(T element){
		//reciba un elemento y retorne el índice donde está almacenado ese
		//elemento, o -1 si el elemento no existe en la lista
		Node<T>currentNode = this.first;
		int pos = 0;
		while (currentNode!=null){
			if (currentNode.getInfo().equals(element)){
				return pos;
			}

			currentNode = currentNode.getNext();
			pos++;
		}
		return -1;
	}

	public MySimpleLinkedList<T> buildList(MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {
		MySimpleLinkedList<T> listaEnComun = new MySimpleLinkedList<>();
		Node<T> NodoA = l1.first;

		while (NodoA != null) {
			Node<T> NodoB = l2.first;

			while (NodoB != null) {
				if (NodoA.getInfo().equals(NodoB.getInfo())) {
					listaEnComun.insertFront(NodoA.getInfo());
				}
				NodoB = NodoB.getNext();
			}

			NodoA = NodoA.getNext();
		}

		return listaEnComun;
	}

	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		String result = "";
		Node<T> current = this.first;

		while (current != null) {
			String prevInfo = (current.getPrevious() != null) ? current.getPrevious().getInfo().toString() : "null";
			String nextInfo = (current.getNext() != null) ? current.getNext().getInfo().toString() : "null";

			result = result + "[ Prev: " + prevInfo + " | Info: " + current.getInfo() + " | Next: " + nextInfo + " ]\n";
			current = current.getNext();
		}

		return result.isEmpty() ? "Lista vacía" : result.trim();
	}



	@Override
	public Iterator<T> iterator() {
		return new MyIterator<>(this.first);
	}

	
}
