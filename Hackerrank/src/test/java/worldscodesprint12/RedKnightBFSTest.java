package worldscodesprint12;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marckoch
 */
public class RedKnightBFSTest {
    
    @Test
    public void testPrintShortestPathSample0() {
        int n = 7;
        int row_start = 6;
        int col_start = 6;
        int row_end = 0;
        int col_end = 1;
        String expResult = "4\nUL UL UL L";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testPrintShortestPathSample1() {
        int n = 6;
        int row_start = 5;
        int col_start = 1;
        int row_end = 0;
        int col_end = 5;
        String expResult = "Impossible";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testPrintShortestPathSample2() {
        int n = 7;
        int row_start = 0;
        int col_start = 3;
        int row_end = 4;
        int col_end = 3;
        String expResult = "2\nLR LL";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathSameRowLeft() {
        int n = 11;
        int row_start = 3;
        int col_start = 10;
        int row_end = 3;
        int col_end = 2;
        String expResult = "4\nL L L L";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathSameRowRight() {
        int n = 10;
        int row_start = 3;
        int col_start = 0;
        int row_end = 3;
        int col_end = 8;
        String expResult = "4\nR R R R";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    
    @Test
    public void testPrintShortestPathSample0Reverse() {
        int n = 7;
        int row_start = 0;
        int col_start = 1;
        int row_end = 6;
        int col_end = 6;
        String expResult = "4\nR LR LR LR";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathPreferRightOverDown() {
        int n = 7;
        int row_start = 2;
        int col_start = 0;
        int row_end = 6;
        int col_end = 6;
        String expResult = "4\nR R LR LR";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathLongWay() {
        int n = 201;
        int row_start = 200;
        int col_start = 200;
        int row_end = 0;
        int col_end = 0;
        String expResult = "150\nUL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL UL L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L L";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathLongWay2() {
        int n = 201;
        int row_start = 0;
        int col_start = 0;
        int row_end = 200;
        int col_end = 200;
        String expResult = "150\nR R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R R LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR LR";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathSidePathLeftDown() {
        int n = 10;
        int row_start = 0;
        int col_start = 0;
        int row_end = 4;
        int col_end = 0;
        String expResult = "2\nLR LL";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }

    @Test
    public void testPrintShortestPathSidePathLeftUp() {
        int n = 11;
        int row_start = 4;
        int col_start = 0;
        int row_end = 0;
        int col_end = 0;
        String expResult = "2\nUR UL";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathSidePathRightDown() {
        int n = 11;
        int row_start = 0;
        int col_start = 10;
        int row_end = 4;
        int col_end = 10;
        String expResult = "2\nLL LR";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathSidePathRightUp() {
        int n = 11;
        int row_start = 4;
        int col_start = 10;
        int row_end = 0;
        int col_end = 10;
        String expResult = "2\nUL UR";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathSidePathMiddleUp() {
        int n = 10;
        int row_start = 4;
        int col_start = 5;
        int row_end = 0;
        int col_end = 5;
        String expResult = "2\nUL UR";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }
    
    @Test
    public void testPrintShortestPathSidePathMiddleDown() {
        int n = 10;
        int row_start = 0;
        int col_start = 5;
        int row_end = 4;
        int col_end = 5;
        String expResult = "2\nLR LL";
        RedKnightBFS.Cell result = RedKnightBFS.findPath(new int[]{row_start, col_start}, new int[]{row_end, col_end}, n);
        assertEquals(expResult, result.toString());
    }    
}
