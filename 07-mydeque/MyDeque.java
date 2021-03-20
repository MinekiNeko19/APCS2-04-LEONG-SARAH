import java.util.*;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    public MyDeque() {
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[10];
        data = d;
        size = 0;
        start = 5;
        end = 5;
    }

    public MyDeque(int initialCapacity) {
        @SuppressWarnings("unchecked")
        E[] d = (E[]) new Object[10];
        data = d;
        size = 0;
        start = 0;
        end = 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String s = "{";
        int j = start;

        for (int i = 0; i < size; i++) {
            if (j >= data.length) {
                j = 0;
            }
            s += data[j];
            if (i < size - 1) {
                s += ", ";
            }
            j++;
        }

        return s + "}";
    }

    public void addFirst(E element) { // throws NullPointerException if element is null
        if (element == null)
            throw new NullPointerException();

        size++;
        // if data capacity reached
        int j = start;
        if (size > data.length) {
            start = 0;
            end = data.length - 1;
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[data.length * 2 + 1];
            for (int i = 0; i < size-1; i++) {
                if (j >= data.length) {
                    j = 0;
                }
                temp[i] = data[j];
                j++;
            }
            data = temp;
        }

        // add the value to the start
        start--;
        if (start == -1) {
            start = data.length - 1;
        }
        data[start] = element;
        // special cases in the beginning
        if (size == 1) {
            end = start;
        } else if (size == 2) {
            end = start + 1;
        }
    }

    public void addLast(E element) { // throws NullPointerException if element is null
        if (element == null) throw new NullPointerException();

        size++;
        // if data capacity reached
        int j = start;
        if (size > data.length) {
            start = 0;
            end = data.length - 1;
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[data.length * 2 + 1];
            for (int i = 0; i < size-1; i++) {
                if (j >= data.length) {
                    j = 0;
                }
                temp[i] = data[j];
                j++;
            }
            data = temp;
        }

        // add the value to the end
        end++;
        if (end == data.length) {
            end = 0;
        }
        data[end] = element;
        // special cases in the beginning
        if (size == 1) {
            start = end;
        } else if (size == 2) {
            start = end - 1;
        }

    }

    public E removeFirst() { // throws NoSuchElementException when empty
        if (size==0) throw new NoSuchElementException();

        start++;
        size--;
        E store = data[start-1];
        if (start == data.length) {
            start = 0;
        }
        return store;
    }

    public E removeLast() { // throws NoSuchElementException when empty
        if (size==0) throw new NoSuchElementException();

        end--;
        size--;
        E store = data[end+1];
        if (end <= -1) {
            end = data.length-1;
        }
        return store;
    }

    public E getFirst() { // throws NoSuchElementException when empty
        if (size==0) throw new NoSuchElementException();
        return data[start];
    }

    public E getLast() { // throws NoSuchElementException when empty
        if (size==0) throw new NoSuchElementException();
        return data[end];
    }

    // Testing method to delete later
    private void startend() {
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
    }

    private void dataGuts() { // to look into the whole array (testing)
        String s = "{";
        for (int i = 0; i < data.length; i++) {
            s += data[i];
            if (i < data.length - 1) {
                s += ", ";
            }
        }
        System.out.println(s + "}");
    }
}
