package toolbox.segmenttree;

import java.util.Arrays;

/**
 *
 * @author marckoch
 */
public final class SegmentTree {

    private final int[] tree; // The array that stores segment tree nodes

    /* Constructor to construct segment tree from given array. This
       constructor  allocates memory for segment tree and calls
       constructSTUtil() to  fill the allocated memory */
    public SegmentTree(int[] arr) {
        // Allocate memory for segment tree
        // Height of segment tree
        int heightOfSegTree = (int) (Math.ceil(Math.log(arr.length) / Math.log(2)));
        System.err.println("heightOfSegTree=" + heightOfSegTree);

        // Maximum size of segment tree
        int max_size = 2 * (int) Math.pow(2, heightOfSegTree) - 1;
        System.err.println("segTree.length=" + max_size);

        this.tree = new int[max_size];

        constructSegmentTree(arr, 0, arr.length - 1, 0);
    }
    
    public int[] getTreeArray() {
        return this.tree;
    }
    
    public int[] getOriginalArray(int n) {
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = getSum(n, i, i);
        }
        return a;
    }

    // A utility function to get the middle index from corner indexes.
    private int getMid(int from, int to) {
        return from + (to - from) / 2;
    }

    /**  
     * A recursive function to get the sum of values in given range
        of the array.  The following are parameters for this function.

      si    --> Index of current node in the segment tree. Initially
                0 is passed as root is always at index 0
      segFrom & segTo: Starting and ending indexes of the segment represented
                       by current node, i.e., st[si]
      queryFrom & queryTo: Starting and ending indexes of query range 
      */
    private int getSumUtil(int segFrom, int segTo, int queryFrom, int queryTo, int si) {
        // If segment of this node is a part of given range, then return
        // the sum of the segment
        if (queryFrom <= segFrom && queryTo >= segTo) {
            return tree[si];
        }

        // If segment of this node is outside the given range
        if (segTo < queryFrom || segFrom > queryTo) {
            return 0;
        }

        // If a part of this segment overlaps with the given range
        int mid = getMid(segFrom, segTo);
        
        return 
            // get result from left child node
            getSumUtil(segFrom, mid,   queryFrom, queryTo, 2 * si + 1) +
            // get result from right child node
            getSumUtil(mid + 1, segTo, queryFrom, queryTo, 2 * si + 2);
    }

    /* A recursive function to update the nodes which have the given 
       index in their range. The following are parameters
        si, ss and se are same as getSumUtil()
        i    --> index of the element to be updated. This index is in
                 input array.
       diff --> Value to be added to all nodes which have i in range */
    private void updateValueUtil(int segFrom, int segTo, int i, int diff, int si) {
        // Base Case: If the input index lies outside the range of 
        // this segment
        if (i < segFrom || i > segTo) {
            return;
        }

        // If the input index is in range of this node, then update the
        // value of the node and its children
        tree[si] = tree[si] + diff;
        if (segTo != segFrom) {
            int mid = getMid(segFrom, segTo);
            // propagate change to left child node
            updateValueUtil(segFrom,   mid, i, diff, 2 * si + 1);
            // propagate change to right child node
            updateValueUtil(mid + 1, segTo, i, diff, 2 * si + 2);
        }
    }

    // The function to update a value in input array and segment tree.
    // It uses updateValueUtil() to update the value in segment tree
    public void updateValue(int[] arr, int i, int new_val) {
        // Check for erroneous input index
        if (i < 0 || i > arr.length - 1) {
            System.out.println("Invalid Input");
            return;
        }

        // Get the difference between new value and old value
        int diff = new_val - arr[i];

        // Update the value in array
        arr[i] = new_val;

        // Update the values of nodes in segment tree
        updateValueUtil(0, arr.length - 1, i, diff, 0);
    }

    // Return sum of elements in range from index queryFrom to queryTo.
    // It mainly uses getSumUtil()
    public int getSum(int n, int queryFrom, int queryTo) {
        // Check for erroneous input values
        if (queryFrom < 0 || queryTo > n - 1 || queryFrom > queryTo) {
            System.out.println("Invalid Input");
            return -1;
        }
        return getSumUtil(0, n - 1, queryFrom, queryTo, 0);
    }

    // A recursive function that constructs Segment Tree for array[ss..se].
    // si is index of current node in segment tree
    private int constructSegmentTree(int[] arr, int segFrom, int segTo, int segCurr) {
        // If there is one element in array, store it in current node of
        // segment tree and return
        if (segFrom == segTo) {
            tree[segCurr] = arr[segFrom];
            return arr[segFrom];
        }

        // If there are more than one elements, then recur for left and
        // right subtrees and store the sum of values in this node
        int mid = getMid(segFrom, segTo);
        tree[segCurr] = 
                constructSegmentTree(arr, segFrom,   mid, segCurr * 2 + 1)
              + constructSegmentTree(arr, mid + 1, segTo, segCurr * 2 + 2);
        return tree[segCurr];
    }

    // Driver program to test above functions
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11};
        int n = arr.length;
        SegmentTree tree = new SegmentTree(arr);

        // Build segment tree from given array
        // Print sum of values in array from index 1 to 3
        System.out.println("original array : " + Arrays.toString(arr));
        System.out.println("segment tree   : " + Arrays.toString(tree.getTreeArray()));
        System.out.println("Sum of values in given range (1,3) = " + tree.getSum(n, 1, 3));
        System.out.println("Sum of values in given range (4,4) = " + tree.getSum(n, 4, 4));
        System.out.println("Sum of values in given range (4,5) = " + tree.getSum(n, 4, 5));

        // Update: set arr[1] = 10 and update corresponding segment tree nodes
        System.out.println("updating element at index 1 to 10");
        tree.updateValue(arr, 1, 10);

        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(tree.getTreeArray()));

        // Find sum after the value is updated
        System.out.println("Updated sum of values in given range (1,3) = "
                + tree.getSum(n, 1, 3));
    }
}
