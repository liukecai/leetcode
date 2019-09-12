package hard;

import cn.edu.kust.hard.FindMedianSortedArrays;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class FindMedianSortedArraysTest {
    private FindMedianSortedArrays find = new FindMedianSortedArrays();

    @Test void testNomal() {
        assertEquals(2.0, find.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        assertEquals(2.5, find.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));
    }

    @Test void testOneNone() {
        assertEquals(2.0, find.findMedianSortedArrays(new int[]{1, 3}, new int[]{}));
        assertEquals(2.0, find.findMedianSortedArrays(new int[]{}, new int[]{1, 3}));
    }
}
