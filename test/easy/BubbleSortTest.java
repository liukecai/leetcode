package easy;

import cn.edu.kust.easy.BubbleSort;

import  static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {
    private static BubbleSort bs = new BubbleSort();

    @BeforeAll
    public static void before() {
        bs.sortIntegers(new int[] {1, 2, 3});
    }

    @Test
    public void testEmpty() {
        int[] A = {};
        int[] sortedA = {};
        assertArrayEquals(sortedA, bs.sortIntegers(A));
    }

    @Test
    public void testSame() {
        int[] A = {1, 1, 1, 1};
        int[] sortedA = {1, 1, 1, 1};
        assertArrayEquals(sortedA, bs.sortIntegers(A));
    }

    @Test
    public void testNormal() {
        int[] A = {3, 4, 45, 67, 23, 13, 65};
        int[] sortedA = {3, 4, 13, 23, 45, 65, 67};
        assertArrayEquals(sortedA, bs.sortIntegers(A));
    }
}
