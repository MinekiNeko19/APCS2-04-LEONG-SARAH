public class Quick {
    //note: start/end have been renamed to lo/hi in this to match the diagram, otherwise it is the same.
    public static int partition(int[]data ,int lo, int hi){
        // lo start; hi end
        if (data.length == 0) return -1;
        if (data.length == 1) return 0;
        if (lo==hi) return lo;
        
        if (Math.abs(lo-hi) == 1) { // special case only two elements to look at
            return (int)(Math.random()*2)+lo;
        }
        
        int index = (int)(Math.random() * (hi-lo+1))+lo;
        // int index = 7;
        int pivot = data[index];
        int current = data[lo]; // to put the pivot in the first index
        int last = data[hi]; // check what happens if the index chooses the last

        System.out.println( // for testing
            "index: " + index +
            " pivot: " + pivot +
            " current: " + current +
            " last: " + last
        );

        // // puts pivot at front
        // if (index == lo) {
        //     data[lo] = data[0];
        //     data[0] = pivot;
        // } else {
        //     data[lo] = data[0];
        //     data[index] = current;
        //     data[0] = pivot;
        // }
        toString(data);

        index = lo; // now marks the original start of range
        // b/c pivot will be moved to index 1 and shift everything
        lo++;

        // sort greater and less
        while (lo != hi) {
            System.out.println("Start: " + lo + " End: " + hi);
            current = data[lo];
            last = data[hi];
            if (pivot < current) {
                data[hi] = current;
                data[lo] = last;
                hi--;
            } else {
                lo++; 
            }
            toString(data);
        }
        System.out.println("\nstart: " + lo + " data: " + data[lo] + " pivot: " + pivot);
        if (data[lo] < pivot || (data[lo] == pivot && Math.random() >= 0.5)) {
            data[0] = data[index];
            data[index] = data[lo];
            data[lo] = pivot;
            toString(data);
            return lo;
        }
        else {
            data[0] = data[index];
            data[index] = data[lo-1];
            data[lo-1] = pivot;
            toString(data);
            return lo-1;
        }
    }

    /*return the value that is the kth smallest value of the array.
    *@param data must have a length > 0
    *@param k is 0 to data.length-1 inclusive
    *@postcondition The array can be modified. (If we did not want to modify the array, we could make a copy before we start the process)
    */
    public static int quickselect(int []data, int k) {
        return quickselect(data, k, 0, data.length-1);
    }
    private static int quickselect(int[] data, int k, int start, int end) {
        // int pivind=partition(data, start, end);
        // if (pivind == k) {
        //     return data[pivind];
        // }

        // else if (pivind < k) {
        //     return quickselect(data, k, start, pivind-1);
        // }
        // else {
        //     return quickselect(data, k, pivind+1, end);
        // }
        return 0;
    }

    public static int[] partitionDutch(int[] arr,int lo, int hi){
        //THIS IS OPTIONAL METHOD, it will make your quicksort faster.
        //return an int array: {lt,gt}
        return null;
    }

    // for testing
    private static void toString(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
