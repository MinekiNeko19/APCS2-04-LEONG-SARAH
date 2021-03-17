public class Merge {
    public static void mergesort(int[] data) {
        int[] temp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        mergesort(data, temp, 3, data.length-1);
        // transfer to original
        for (int i = 0; i < data.length; i++) {
            data[i] = temp[i];
        }
    }

    private static void mergesort(int[] data, int[] temp, int lo, int hi) {
        int rightstart = (hi-lo+1)/2 + lo;
        if (hi-lo >= 1) {
            mergesort(data, temp, lo, rightstart-1);
            // System.out.println("split");
            mergesort(data, temp, rightstart, hi);
            merge(data, temp, lo, hi);
        }
    }

    private static void merge(int[] data, int[] temp, int lo, int hi) {
        int leftstart = lo;
        int rightstart = (hi-lo+1)/2 + lo;
        if (hi-lo==1) { // only 2 element
            temp[lo] = Math.min(data[lo], data[hi]);
            temp[hi] = Math.max(data[lo], data[hi]);
            // System.out.println(temp[lo] + "split" + temp[hi]);
            data[lo] = temp[lo];
            data[hi] = temp[hi];
        }

        else { // more than 2 elements
            int left = 0;
            int right = 0;
            int ind = lo;
            
            // sort the elements
            for (int i = lo; i <= hi; i++) {
                while (leftstart < ((hi-lo+1)/2 + lo) && rightstart < hi) {
                    left = data[leftstart];
                    right = data[rightstart];
                    if (left <= right) {
                        temp[ind] = left;
                    } else {
                        temp[ind] = right;
                    }
                    ind++;
                }
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