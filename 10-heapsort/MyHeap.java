public class MyHeap {
    // index of a node: i*2 + 1or2
    private static void pushDown(int[] data, int size, int index) {
        if (index <= size/2) {
            int leftInd = index*2 + 1;
            int rightInd = index*2 + 2;
            pushDown(data, size/2, leftInd);
            pushDown(data, size/2, rightInd);
            if (data[leftInd] > data[index]) {
                int temp = data[leftInd];
                data[leftInd] = data[index];
                data[index] = temp;
            }
            if (data[rightInd] > data[index]) {
                int temp = data[rightInd];
                data[rightInd] = data[index];
                data[index] = temp;
            }
        }
    }  
    private static void buildHeap(int[] data) {
        pushDown(data, data.length, 0);
    }

    private static void remove(int[] data, int index) {

    }
    public static void heapsort(int[] data) {

    }
    private static void toString(int[]data) {
        String arr = "[" + data[0];
        for (int i = 1; i < data.length; i++) {
            arr += ", " + data[i];
        }
        arr += "]";
        System.out.println(arr);
    }

    public static void main(String[] args) {
        // comment out later this is for private testing
        int[] a = new int[]{1,23,4,7,10}; // buildHeap order: 23, 10, 4, 7, 1
        int[] b = new int[]{1,1,1,1,1,1};

        toString(a); //toString works as intended
        buildHeap(a);
        toString(a);
    }
}