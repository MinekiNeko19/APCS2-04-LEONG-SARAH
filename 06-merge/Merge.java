public class Merge {
    public static void mergesort(int[] data) {
        int[] temp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        mergesort(data, temp, 0, data.length-1);
    }

    private static void mergesort(int[] data, int[] temp, int lo, int hi) {
        if (hi-lo >= 1) {
            // mergesort(data, temp, lo, leftend);
            // mergesort(data, temp, rightstart, lo-1);

            // merge code
            if (hi-lo==1) { // only 2 element
                temp[lo] = Math.min(data[lo], data[hi]);
                temp[hi] = Math.max(data[lo], data[hi]);
                System.out.println(temp[lo] + "split" + temp[hi]);
            }

            else { // more than 2 elements
                int leftstart = lo;
                int rightstart = (hi-lo+1)/2;
                int left = 0;
                int right = 0;
                for (int i = lo; i < hi; i++) {
                    System.out.println("left: " + leftstart + " right: " + rightstart);
                    System.out.println("Index: " + i);
                    if (leftstart != (hi-lo+1)/2) {
                        left = data[leftstart];
                    }
                    if (rightstart != (hi)) {
                        right = data[rightstart];
                    }

                    System.out.println("left val: " + left + " right val: " + right);
                    if (right < left) {
                        temp[i] = right;
                        rightstart++;
                    }
                    else if (left < right) {
                        temp[i] = left;
                        leftstart++;
                    }
                    toString(temp);
                    // toString(data);
                    System.out.println();
                    // special case for equal
                }

                int store = 0;
                for (int i = 0; i < data.length; i++) {
                    store = temp[i];
                    temp[i] = data[i];
                    data[i] = store;
                }
            }


            // transfer to original
            for (int i = 0; i < data.length; i++) {
                data[i] = temp[i];
            }
        }
    }
    private static void toString(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }
}
