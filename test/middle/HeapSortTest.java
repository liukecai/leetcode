package middle;

import cn.edu.kust.medium.HeapSort;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import org.junit.jupiter.api.Test;

public class HeapSortTest {
    private HeapSort heapSort = new HeapSort();

    @Test
    public void testEmpty() {
        int[] A = {};
        int[] sortedA = {};
        assertArrayEquals(sortedA, heapSort.heapSort(A));
    }

    @Test
    public void testSame() {
        int[] A = {1, 1, 1, 1, 1};
        int[] sortedA = {1, 1, 1, 1, 1};
        assertArrayEquals(sortedA, heapSort.heapSort(A));
    }

    @Test
    public void testNormal1() {
        int[] A = {3, 4, 45, 67, 23, 13, 65};
        int[] sortedA = {3, 4, 13, 23, 45, 65, 67};
        assertArrayEquals(sortedA, heapSort.heapSort(A));
    }

    @Test
    public void testNormal2() {
        int[] A = {5,1,1,2,0,0};
        int[] sortedA = {0, 0, 1, 1, 2, 5};
        assertArrayEquals(sortedA, heapSort.heapSort(A));
    }
}
