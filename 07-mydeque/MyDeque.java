import java.util.*;

public class MyDeque<E> {
    private E[] data;
    private int size, start, end;

    public MyDeque(){
        @SuppressWarnings("unchecked")
        E[] d = (E[])new Object[10];
        data = d;
        size = 0;
        start = 5;
        end = 5;
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

        if (start < end) {
            for (int i = start; i <= end; i++) {
                s += data[i];
                if (i < end-1) {
                    s += ", ";
                }
            }
        }
        else {
            s += data[start];
            if (size != 1) {
                s += ", ";
            }
            for (int i = start+1; i != end+1; i++) {
                s += data[i];
                if (i != end) {
                    s += ", ";
                }
                if (i==data.length-1) {
                    i=-1;
                }
            }
        }

        return s + "}";
    }
    public void addFirst(E element){ // throws NullPointerException if element is null
        if (element==null) throw new NullPointerException();

        // if data capacity reached
        size++;
        if (size>data.length) {
            start = 0;
            end = data.length-1;
            @SuppressWarnings("unchecked")
            E[] temp = (E[]) new Object[data.length*2+1];
            for (int i = 0; i < data.length; i++) {
                temp[i] = data[i];
            }
            data = temp;
        }

        // add the value to the start
        start--;
        if (start == -1) {
            start = data.length-1;
        }
        data[start] = element;
        // special cases in the beginning
        if (size == 1) {
            end = start;
        }
        else if (size == 2) {
            end = start + 1;
        }
    }
    public void addLast(E element){ // throws NullPointerException if element is null
        if (element==null) throw new NullPointerException();

        // if data capacity reached

        // add the value to the end

        
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

    // Testing method to delete later
    public void startend() {
        System.out.println("Start: " + start);
        System.out.println("End: " + end);
    }
    public void dataGuts() { //to look into the whole array (testing)
        String s = "{";
        for (int i = 0; i < data.length; i ++) {
            s+=data[i];
            if (i < data.length-1) {
                s+= ", ";
            }
        }
        System.out.println(s+"}");
    }
}
