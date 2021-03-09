public class Preliminary {
    /*Modify the array such that:
       *1. A random index from start to end inclusive is chosen, the corresponding
       *   element is designated the pivot element.
       *2. all elements in range that are smaller than the pivot element are placed before the pivot element.
       *3. all elements in range that are larger than the pivot element are placed after the pivot element.
       *4. Only the indices from start to end inclusive are considered in range
       *@return the index of the final position of the pivot element.
       */
    public static int partition (int [] data, int start, int end){
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

    private static void toString(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
