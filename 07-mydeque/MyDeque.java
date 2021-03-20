import java.util.NoSuchElementException;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = 0;
        end = 0;
    }
    public MyDeque(int initialCapacity){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = 0;
        end = 0;
    }
    public int size(){
        return size;
    }
    public String toString(){
        String s = "{";
        for (int i = 0; i < size; i++) {
            s += data[i];
            if (i < size-1) {
                s += ", ";
            }
        }
        return s + "}";
    }
    public void addFirst(E element){ // throws NullPointerException if element is null

    }
    public void addLast(E element){ // throws NullPointerException if element is null

    }
    public E removeFirst(){ // throws NoSuchElementException when empty
        return null;
    }
    public E removeLast(){ // throws NoSuchElementException when empty
        return null;
    }
    public E getFirst(){ // throws NoSuchElementException when empty
        return null;
    }
    public E getLast(){ // throws NoSuchElementException when empty
        return null;
    }
}
