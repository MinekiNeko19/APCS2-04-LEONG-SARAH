public class Merge {
    public static void mergesort(int[] data) {
        int[] temp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        mergesort(data, temp, 0, data.length-1);
    }

    private static void mergesort(int[] data, int[] temp, int lo, int hi) {
        if (hi-lo + 1 > 1) {
            mergesort(data, temp, 0, data.length/2-1);
            mergesort(data, temp, data.length/2, data.length-1);
            System.out.println("running");
            for (int i = lo;  i < hi-lo; i++) {
                if (data[lo] > data[hi]) {
                    System.out.println("lo val: " + data[lo] + " hi val: " + data[hi]);
                    temp[hi] = data[lo];
                    temp[lo] = data[hi];
                }
            }
            for (int i = 0; i < data.length; i++) {
                data[i] = temp[i];
            }
        }
    }
}
