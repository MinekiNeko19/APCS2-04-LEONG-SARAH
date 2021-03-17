public class Merge {
    public static void mergesort(int[] data) {
        int[] temp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        mergesort(data, temp, 0, data.length-1);
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
            
            // sort the elements
            for (int i = lo; i <= hi; i++) {
                System.out.println("leftstart: " + leftstart + " rightstart: " + rightstart);
                // System.out.println("Index: " + i);
                left = data[leftstart];
                right = data[rightstart];

                System.out.println("left val: " + left + " right val: " + right);
                if (right < left) {
                    System.out.println("right less");
                    if (rightstart > hi) {
                        temp[i] = left;
                        leftstart++;
                        i++;
                    } else {
                        temp[i] = right;
                        rightstart++;
                    }
                }
                else if (left < right) {
                    System.out.println("left less");
                    if (leftstart >= (hi-lo+1)/2) {
                        temp[i] = right;
                        rightstart++;
                        i++;
                    } else {
                        temp[i] = left;
                        leftstart++;
                    }
                }
                // special case for equal
                else if (leftstart != rightstart){
                    System.out.println("equal");
                    temp[i] = right;
                    i = i + 1;
                    temp[i] = left;
                    rightstart++;
                    leftstart++;
                }
                // Testing
                // toString(temp);
                // toString(data);
                // System.out.println();
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