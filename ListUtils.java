import java.util.*;

public class ListUtils<T extends Comparable<T>> implements Comparator<T> {
    private Node<T> first;



    public MySimpleLinkedList<T> construirListaComunNoOrdenada(
            MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {

        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        for (T elemento : l1) {
            for (T elemento2 : l2) {
                if (elemento.equals(elemento2) && !contains(resultado, elemento)) {
                    insertarOrdenado(resultado, elemento);
                }
            }
        }

        return resultado;
    }

    public MySimpleLinkedList<T> construirListaComunOrdenada(
            MySimpleLinkedList<T> l1, MySimpleLinkedList<T> l2) {

        MySimpleLinkedList<T> resultado = new MySimpleLinkedList<>();
        Iterator<T> it1 = l1.iterator();
        Iterator<T> it2 = l2.iterator();

        if (!it1.hasNext() || !it2.hasNext()) return resultado;

        T val1 = it1.next();
        T val2 = it2.next();

        while (it1.hasNext() && it2.hasNext()) {
            int cmp = compare(val1, val2);
            if (cmp == 0) {
                if (!contains(resultado, val1)) {
                    insertarOrdenado(resultado, val1);
                }
                val1 = it1.next();
                val2 = it2.next();
            } else if (cmp < 0) {
                val1 = it1.next();
            } else {
                val2 = it2.next();
            }
        }
        return resultado;
    }

    public void insertarOrdenado(MySimpleLinkedList<T> lista, T elemento) {

        Node<T> nuevoNodo = new Node<>(elemento, null);
        //Si la lista no esta vacia, verificamos si el primer nodo de la lista tiene un valor mayor que el elemento que estamos insertando.
        if (lista.isEmpty() || lista.iterator().next().compareTo(elemento) > 0) {
            nuevoNodo.setNext(lista.getFirst());
            lista.setFirst(nuevoNodo);
            return;
        }

        /*
        * Si no entramos en el if anterior, significa que el nuevo nodo debe insertarse en algun lugar despues del primer nodo.

        * El while  asegura que el valor en el siguiente nodo de actual es menor que el valor de elemento.
        * Si es asi, seguimos avanzando a través de la lista con actual = actual.getNext(), para encontrar la posicion correcta para elemento.

        * */
        Node<T> actual = lista.getFirst();
        while (actual.getNext() != null && actual.getNext().getInfo().compareTo(elemento) < 0) {
            actual = actual.getNext();
        }
        //Cuando el ciclo termina, significa que hemos encontrado la posición correcta para insertar el nuevo nodo.
        nuevoNodo.setNext(actual.getNext());
        actual.setNext(nuevoNodo);
    }

    private boolean contains(MySimpleLinkedList<T> lista, T elemento) {
        for (T item : lista) {
            if (item.equals(elemento)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compare(T o1, T o2) {
        return o1.compareTo(o2);
    }

}
