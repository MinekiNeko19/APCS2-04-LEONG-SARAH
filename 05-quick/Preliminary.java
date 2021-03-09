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
        int pivot = data[index];
        int current = data[0]; // to put the pivot in the first index
        int last = data[end]; // check what happens if the index chooses the last
        int temp = data[1];

        System.out.println(
            "index: " + index +
            " pivot: " + pivot +
            " current: " + current +
            " last: " + last +
            " temp: " + temp
        );

        // data[0] = pivot;
        // data[index] = current;



        return 0; 
    }
}
