public class MyHeap {
    // index of a node: i*2 + 1or2
    private static void pushDown(int[] data, int size, int index) {
        if (size > 1) {
            int leftsize = size/2;
            int rightsize = size/2;
            if (size % 2 == 1) leftsize=leftsize+1;

            int leftInd = index*2;
            int rightInd = index*2 + 1;

            if (rightInd < data.length && data[rightInd] > data[index]) {
                int temp = data[rightInd];
                data[rightInd] = data[index];
                data[index] = temp;
                pushDown(data, rightsize, rightInd);
            }
            if (data[leftInd] > data[index]) {
                int temp = data[leftInd];
                data[leftInd] = data[index];
                data[index] = temp;
                pushDown(data, leftsize, leftInd);
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
        // int[] b = new int[]{2,19,100,3,25,1,17,7,36}; // 100, 19, 36, 17, 3, 25, 1, 2, 7
        int[] c = new int[]{1,40,22,10,3};

        // toString(a); //toString works as intended
        // buildHeap(a);
        // toString(a);

        toString(c);
        buildHeap(c);
        toString(c);
    }
}