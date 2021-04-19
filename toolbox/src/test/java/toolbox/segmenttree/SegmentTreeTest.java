package toolbox.segmenttree;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

/**
 *
 * @author marckoch
 */
public class SegmentTreeTest {
    int[] arr;
    SegmentTree instance;
    
    public SegmentTreeTest() {
    }

    @Before
    public void init() {
        arr = new int[] {1, 3, 5, 7, 9, 11};
        instance = new SegmentTree(arr);
    }
    
    @Test
    public void testGetTreeArray() {
        System.out.println("getTreeArray");

        int[] result = instance.getTreeArray();

        int[] expResult = {36, 9, 27, 4, 5, 16, 11, 1, 3, 0, 0, 7, 9, 0, 0};
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testUpdateValue() {
        System.out.println("updateValue");

        instance.updateValue(arr, 1, 10);

        int[] result = instance.getTreeArray();

        int[] expResult = {43, 16, 27, 11, 5, 16, 11, 1, 10, 0, 0, 7, 9, 0, 0};
        assertArrayEquals(expResult, result);
    }

    @Test
    public void testGetSum() {
        System.out.println("getSum");
        int n = 6;
        assertEquals(15, instance.getSum(n, 1, 3));

    }
    
    @Test
    public void testGetSumToGetOriginalArrayElements() {
        System.out.println("testGetSumToGetOriginalArrayElements");
        int n = 6;
        
        // original array
        assertEquals(arr[0], instance.getSum(n, 0, 0));
        assertEquals(arr[1], instance.getSum(n, 1, 1));
        assertEquals(arr[2], instance.getSum(n, 2, 2));
        assertEquals(arr[3], instance.getSum(n, 3, 3));
        assertEquals(arr[4], instance.getSum(n, 4, 4));
        assertEquals(arr[5], instance.getSum(n, 5, 5));
    }
    
    @Test
    public void testGetSumToGetOriginalArray() {
        System.out.println("testGetSumToGetOriginalArray");
        int n = 6;
        
        // original array
        assertArrayEquals(arr, instance.getOriginalArray(6));
    }
    
    @Test
    public void testGetSumWithWrongIndex() {
        System.out.println("testGetSumWithWrongIndex");
        int n = 6;
        
        assertEquals(-1, instance.getSum(n, -1, 2));
        assertEquals(-1, instance.getSum(n, 1, 0));
        assertEquals(-1, instance.getSum(n, 6, 6));
    }
}
