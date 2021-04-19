package geeksforgeeks;

/**
 *
 * @author marckoch
 */
// Java program to print all combination of size
// r in an array of size n
class Permutation {

    static void processCombination(int[] data) {
        for (int j = 0; j < data.length; j++) {
            System.out.print(data[j] + " ");
        }
        System.out.println("");
    }

    /* 
    arr[]  ---> Input Array
    data[] ---> Temporary array to store current combination
    start & end ---> Staring and Ending indexes in arr[]
    index  ---> Current index in data[]
    r ---> Size of a combination to be printed */
    static void combinationUtil(int[] arr, int size, int index, int[] data, int i) {
        // Current combination is ready to be processed
        if (index == size) {
            processCombination(data);
            return;
        }

        // When no more elements are there to put in data[]
        if (i >= arr.length) {
            return;
        }

        // current is included, put next at next location
        data[index] = arr[i];
        combinationUtil(arr, size, index + 1, data, i + 1);

        // current is excluded, replace it with next 
        // (Note that i+1 is passed, but index is not changed)
        combinationUtil(arr, size, index, data, i + 1);
    }

    // The main function that prints all combinations
    // of size r in arr[] of size n. This function 
    // mainly uses combinationUtil()
    static void generateCombinations(int arr[], int size) {
        // A temporary array to store all combination one by one
        int[] data = new int[size];

        // Print all combination using temprary array 'data[]'
        combinationUtil(arr, size, 0, data, 0);
    }

    /* Driver function to check for above function */
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50};
        int size = 3;
        generateCombinations(arr, size);
    }
}
/* This code is contributed by Devesh Agrawal */
