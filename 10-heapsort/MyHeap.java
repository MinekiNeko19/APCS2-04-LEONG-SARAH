public class MyHeap {
    // index of a node: i*2 + 1or2
    private static void pushDown(int[] data, int size, int index) {
        int leftInd = index*2 + 1;
        int rightInd = index*2 + 2;

        if (leftInd < size) {
            if (rightInd < size) {
                if (data[rightInd] > data[index] && data[rightInd] > data[leftInd]) {
                    int temp = data[rightInd];
                    data[rightInd] = data[index];
                    data[index] = temp;

                    pushDown(data, size, rightInd);
                }
                if (data[leftInd] > data[index] && data[rightInd] < data[leftInd]) {
                    int temp = data[leftInd];
                    data[leftInd] = data[index];
                    data[index] = temp;

                    pushDown(data, size, leftInd);
                }
            }
            if (data[leftInd] > data[index]) {
                int temp = data[leftInd];
                data[leftInd] = data[index];
                data[index] = temp;
            }
        }
    }  
    private static void buildHeap(int[] data) {
        for (int i = data.length-1; i >= 0; i--) {
            pushDown(data, data.length, i);
        }
    }

    private static void remove(int[] data, int index) {
        int temp = data[index];
        data[index] = data[0];
        data[0] = temp;
        pushDown(data, index, 0);
    }

    public static void heapsort(int[] data) {
        buildHeap(data);
        for (int i = data.length-1; i >= 0; i--) {
            remove(data, i);
        }
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
        int[] a = new int[]{1,23,4,7,10}; // 23, 10, 4, 7, 1
        int[] b = new int[]{2,19,100,3,25,1,17,7,36}; // 100, 19, 36, 17, 3, 25, 1, 2, 7
        int[] c = new int[]{1,40,22,10,3}; // 40, 10, 22, 1, 3
        int[] d = new int[]{1,20,50,15,9,40,30,2,3,5,6}; // 50,20,40,15,9,1,30,2,3,5,6
        int[] e = new int[]{10,20,50,15,9,40,30,2,3,5,6}; // 50,20,40,15,9,10,30,2,3,5,6
        int[] f = new int[]{20,15,8,10,5,7,6,2,9,1};

        System.out.println("a");
        toString(a);
        buildHeap(a);
        toString(a);

        System.out.println("b");
        toString(b);
        buildHeap(b);
        toString(b);
        
        System.out.println("c");
        toString(c);
        buildHeap(c);
        toString(c);
        
        System.out.println("d");
        toString(d);
        buildHeap(d);
        toString(d);
        
        System.out.println("e");
        toString(e);
        buildHeap(e);
        toString(e);

        System.out.println("a");
        toString(a);
        heapsort(a);
        toString(a);
    }
}