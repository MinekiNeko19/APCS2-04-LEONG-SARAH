public class Merge {
    public static void mergesort(int[] data) {
        int[] temp = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            temp[i] = data[i];
        }
        mergesort(data, temp, 0, data.length-1);
    }

    private static void mergesort(int[] data, int[] temp, int lo, int hi) {
        
    }
}
