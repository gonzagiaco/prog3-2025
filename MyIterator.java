import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyIterator<T> implements Iterator<T> {

    private Node<T> cursor;


    public MyIterator(Node<T> cursor){
        this.cursor = cursor;
    }

    @Override
    public boolean hasNext() {
        return cursor != null;
    }

    @Override
    public T next() {
        if (cursor == null) {
            throw new NoSuchElementException("no hay mas elementos a los que apuntar en la lista");
        }
        T info = this.cursor.getInfo();
        this.cursor = this.cursor.getNext();
        return info;
    }



    public T getInfo() {
        if (cursor == null) {
            throw new NoSuchElementException("no hay mas info en la lista");
        }
        return cursor.getInfo();
    }
}
