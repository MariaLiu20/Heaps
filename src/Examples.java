/**
 * @author Maria Liu
 * @author Kevin Dang
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class Examples {

    public Examples(){}

    HeapChecker HT = new HeapChecker();

    IHeap emptyHeap = new MtHeap();
    IHeap invalidHeap = new DataHeap(6,new DataHeap(2), new DataHeap(1));
    IHeap hOrig1 = new DataHeap(5, new DataHeap(6), new DataHeap(8));
    IHeap hOrig2 = new DataHeap(3, new MtHeap(), new MtHeap());
    IHeap hOrig3 = new DataHeap(1, new DataHeap(3, new DataHeap(4), new MtHeap()), new DataHeap(5));
    IHeap hOrig4 = new DataHeap(2, new DataHeap(2), new DataHeap(2));
    IHeap hOrig5 = new DataHeap(-5, new DataHeap(-1), new DataHeap(-2, new DataHeap(0), new MtHeap()));
    IHeap hOrig6 = new DataHeap(4, new DataHeap(4, new DataHeap(4), new DataHeap(12)), new DataHeap(4, new DataHeap(4), new DataHeap(5)));

    @Test
    public void testAdd5ToEmptyHeap() {
        assertTrue(HT.addEltTester(emptyHeap, 5, emptyHeap.addElt(5)));
    }
    @Test
    public void testAdd9TohOrig1() {
        assertTrue(HT.addEltTester(hOrig1, 9, hOrig1.addElt(9)));
    }
    @Test
    public void testAdd5TohOrig2() {
        assertTrue(HT.addEltTester(hOrig2, 5, hOrig2.addElt(5)));
    }
    @Test
    public void testAdd2TohOrig1() {
        assertTrue(HT.addEltTester(hOrig2, 2, hOrig2.addElt(2)));
    }
    @Test
    public void testAddDuplicateToTopOfhOrig1() {
        assertTrue(HT.addEltTester(hOrig1, 5, hOrig1.addElt(5)));
    }
    @Test
    public void testAddNeg1TohOrig3() {
        assertTrue(HT.addEltTester(hOrig3, -1, hOrig3.addElt(-1)));
    }
    @Test
    public void testAddDuplicateToMiddleOfhOrig1() {
        assertTrue(HT.addEltTester(hOrig1, 6, hOrig1.addElt(6)));
    }
    @Test
    public void testComparingDiffHeaps(){
        assertFalse(HT.addEltTester(hOrig1,7,hOrig2.addElt(7)));
    }

    @Test
    public void testRemMinEltFromhOrig1() {
        assertTrue(HT.remMinEltTester(hOrig1, hOrig1.remMinElt()));
    }
    @Test
    public void testRemMinEltFromhOrig2() {
        assertFalse(HT.remMinEltTester(hOrig2, hOrig2.remMinElt()));
    }
    @Test
    public void testRemMinEltFromhOrig3() {
        assertTrue(HT.remMinEltTester(hOrig3, hOrig3.remMinElt()));
    }
    @Test
    public void testRemMinEltFromhOrig4() {
        assertTrue(HT.remMinEltTester(hOrig4, hOrig4.remMinElt()));
    }
    @Test
    public void testRemMinEltFromhOrig5() {
        assertTrue(HT.remMinEltTester(hOrig5, hOrig5.remMinElt()));
    }
    @Test
    public void testRemMinEltFromhOrig6() {
        assertTrue(HT.remMinEltTester(hOrig6, hOrig6.remMinElt()));
    }

    @Test
    public void testisHeapValid(){
        assertFalse(invalidHeap.isValidHeap());
    }
    @Test
    public void testisHeapValid1(){
        assertTrue(hOrig1.isValidHeap());
    }
}
