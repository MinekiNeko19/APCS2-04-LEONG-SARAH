public class Quick {
    //note: start/end have been renamed to lo/hi in this to match the diagram, otherwise it is the same.
    public static int partition(int[]data ,int start, int end, int lvl){
        if (data.length == 0) return -1;
        if (data.length == 1) return 0;
        if (start==end) return start;

        int index = (int)(Math.random() * (end-start+1))+start;
        // int index = 7;
        int pivot = data[index];
        int current = data[start]; // to put the pivot in the first index
        int last = data[end]; // check what happens if the index chooses the last

        // System.out.println(
        //     "index: " + index +
        //     " pivot: " + pivot +
        //     " current: " + current +
        //     " last: " + last
        // );

        // puts pivot at front
        if (index == start) {
            data[start] = data[0];
            data[0] = pivot;
        } else {
            data[start] = data[0];
            data[index] = current;
            data[0] = pivot;
        }
        // toString(data);

        index = start; // now marks the original start of range
        // b/c pivot will be moved to index 1 and shift everything
        start++;

        // sort greater and less
        while (start != end) {
            // System.out.println("Start: " + start + " End: " + end);
            current = data[start];
            last = data[end];
            if (pivot < current) {
                data[end] = current;
                data[start] = last;
                end--;
            } else {
                start++; 
            }
            // toString(data);
        }
        // System.out.println("\nstart: " + start + " data: " + data[start] + " pivot: " + pivot);
        if (data[start] < pivot) {
            data[0] = data[index];
            data[index] = data[start];
            data[start] = pivot;
            // toString(data);
            return start;
        } else {
            data[0] = data[index];
            data[index] = data[start-1];
            data[start-1] = pivot;
            // toString(data);
            return start-1;
        }
    }

    public static int[] partitionDutch(int[] arr,int lo, int hi){
        //THIS IS OPTIONAL METHOD, it will make your quicksort faster.
        //return an int array: {lt,gt}

        // special cases
        // if (arr.length == 0) return new int[0];
        // if (arr.length == 1) return new int[]{0,0};
        // if (lo==hi) return new int[]{lo,hi};
        // if (hi-lo == 2) {
        //     if (arr[lo] > arr[hi]) {
        //         int temp = arr[hi];
        //         arr[hi] = arr[lo];
        //         arr[lo] = temp; 
        //     }
        //     return new int[]{lo, hi};
        // }
        
        // // random pivot
        // // int index = (int)(Math.random() * (hi-lo+1))+lo;
        // int index = 4;
        // int pivot = arr[index];
        // int lt = index;
        // int gt = index;
        // int temp = 0;

        // System.out.println(
        //     "index: " + index +
        //     " pivot: " + pivot +
        //     " lo: " + lo +
        //     " hi: " + hi
        // );

        // for (int i = lo; i <= hi; i++) {
        //     System.out.println("index: " + i);
        //     if (arr[i] < pivot) {
        //         System.out.println("less than piv");
        //         arr[lt] = arr[i];
        //         arr[i] = pivot;

        //         lt++;
        //         gt++;
        //     }
        //     else if (arr[i] > pivot) {
        //         System.out.println("greater than piv");
        //         arr[gt] = arr[i];
        //         arr[i] = pivot;

        //         i++;
        //     }
        //     else if (arr[i]==pivot) {
        //         System.out.println("equal to piv");
        //         gt++;
        //     }
        //     toString(arr);
        // }

        return null;
    }

    /*return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array can be modified. (If we did not want to modify the array, we could make a copy before we start the process)
    */
    public static int quickselect(int []data, int k) {
        return quickselect(data, k, 0, data.length-1, 0);
    }
    private static int quickselect(int[] data, int k, int start, int end, int lvl) {
        int index = partition(data, start, end, lvl);
        // System.out.println("Index: " + index);
        // System.out.println("Level: " + lvl);
        // toString(data);

        if (index==k) return data[k];

        if (k > index) {
            return quickselect(data, k, index+1, end, lvl++);
        }
        return quickselect(data, k, start, index-1, lvl++);
    }

    public static void quicksort(int[] data){
        //your code.
      }

    // for testing
    private static void toString(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
