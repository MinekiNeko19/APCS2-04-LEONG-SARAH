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
            int leftstart = lo;
            int rightstart = (hi-lo)/2;
            System.out.println(rightstart + " left: " + leftstart);
            // mergesort(data, temp, lo, leftend);
            // mergesort(data, temp, rightstart, lo-1);

            // merge code
            if (hi-lo==1) {
                temp[lo] = Math.min(data[lo], data[hi]);
                temp[hi] = Math.max(data[lo], data[hi]);
                System.out.println(temp[lo] + "split" + temp[hi]);
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
    }
}
